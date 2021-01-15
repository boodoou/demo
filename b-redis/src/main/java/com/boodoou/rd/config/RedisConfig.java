package com.boodoou.rd.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * Redisson 配置
 *
 * @author wong
 */
@Data
public class RedisConfig {

    private String address;
    private String password;
    private int database;
    private int timeout;
    private int connectTimeout;
    private int connectionPoolSize;
    private int connectionMinimumIdleSize;
    private int subscriptionConnectionPoolSize;

    /**
     * 构建redis配置
     *
     * @return config
     */
    private Config getSingleServerConfig() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress(this.address)
                .setDatabase(this.database)
                .setPassword(this.password)
                .setTimeout(this.timeout)
                .setRetryAttempts(10)
                .setPingConnectionInterval(1000)
                .setConnectTimeout(this.connectTimeout)
                .setConnectionPoolSize(this.connectionPoolSize)
                .setConnectionMinimumIdleSize(this.connectionMinimumIdleSize)
                .setSubscriptionConnectionPoolSize(this.subscriptionConnectionPoolSize);
        return config;
    }

    /**
     * 获取RedissonClient
     *
     * @return client
     */
    public RedissonClient getClient() {
        final Config a = getSingleServerConfig();
        final RedissonClient client = Redisson.create(a);
        return client;
    }
}