package com.boodoou.mbp.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * mbp config
 *
 * @author wong
 * @since 2020-12-16
 */
@Configuration
public class MybatisPlusConfig {

    // 数据源

    /**
     * 主数据源
     */
    @Bean("primaryDs")
    @ConfigurationProperties("datasource.primary")
    public DruidDataSource primaryDs() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

    /**
     * 副数据源
     */
    @Bean("secondaryDs")
    @ConfigurationProperties("datasource.secondary")
    public DruidDataSource secondaryDs() {
        return DataSourceBuilder.create().type(com.alibaba.druid.pool.DruidDataSource.class).build();
    }

    // 配置

    /**
     * 创建全局配置
     */
    @Bean
    public GlobalConfig mpGlobalConfig() {
        // 全局配置文件
        GlobalConfig globalConfig = new GlobalConfig();
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        // 默认为自增
        dbConfig.setIdType(IdType.AUTO);
        // 逻辑删除注入器
        dbConfig.setLogicDeleteField("status");
        dbConfig.setLogicDeleteValue("1");

        globalConfig.setDbConfig(dbConfig);
        return globalConfig;
    }

    /**
     * 主数据源 SqlSession
     */
    @Bean(name = "primarySqlSessionFactory")
    public MybatisSqlSessionFactoryBean primarySqlSessionFactory(
            DruidDataSource primaryDs,
            GlobalConfig globalConfig) throws IOException {
        final String mappingPath = "classpath:mapper/primary/*Mapper.xml";
        final String entityPackage = "com.boodoou.mbp.primary.entity";
        return getSessionFactoryBean(primaryDs, globalConfig, mappingPath, entityPackage);
    }

    /**
     * 副数据源 SqlSession
     */
    @Bean(name = "secondarySqlSessionFactory")
    public MybatisSqlSessionFactoryBean secondarySqlSessionFactory(
            DruidDataSource secondaryDs,
            GlobalConfig globalConfig) throws IOException {
        final String mappingPath = "classpath:mapper/secondary/*Mapper.xml";
        final String entityPackage = "com.boodoou.mbp.secondary.entity";
        return getSessionFactoryBean(secondaryDs, globalConfig, mappingPath, entityPackage);
    }

    /**
     * 主数据源的MapperScan
     * <p>
     * MapperScannerConfigurer 是 BeanFactoryPostProcessor 的一个实现，如果配置类中出现 BeanFactoryPostProcessor ，会破坏默认的
     * post-processing, 如果不加static, 会导致整个都提前加载, 这时候, 取不到projectStage的值
     */
    @Bean
    public static MapperScannerConfigurer primaryMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.boodoou.mbp.primary");
        // 设置为上面的 factory name
        configurer.setSqlSessionFactoryBeanName("primarySqlSessionFactory");
        return configurer;
    }

    /**
     * 副数据源的MapperScan
     */
    @Bean
    public static MapperScannerConfigurer secondaryMapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.boodoou.mbp.secondary");
        // 设置为上面的 factory name
        configurer.setSqlSessionFactoryBeanName("secondarySqlSessionFactory");
        return configurer;
    }

    /**
     * SessionFactory
     */
    private MybatisSqlSessionFactoryBean getSessionFactoryBean(
            DruidDataSource dataSource,
            GlobalConfig globalConfig,
            String mappingPath,
            String entityPackage) throws IOException {

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setGlobalConfig(globalConfig);
        configuration.setMapUnderscoreToCamelCase(true);
        sqlSessionFactoryBean.setConfiguration(configuration);
        List<MybatisPlusInterceptor> interceptors = new ArrayList<>();

        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(mappingPath));
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);

        // 设置分页插件
        interceptors.add(mybatisPlusInterceptor());
        sqlSessionFactoryBean.setPlugins(interceptors.toArray(new MybatisPlusInterceptor[0]));
        return sqlSessionFactoryBean;
    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
