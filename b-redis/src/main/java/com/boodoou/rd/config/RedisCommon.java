package com.boodoou.rd.config;

import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 系统缓存配置
 *
 * @author wong
 * @date 2020/10/26 19:51
 */
@Configuration
@NoArgsConstructor
@ConfigurationProperties(prefix = "redis.common")
public class RedisCommon extends RedisConfig {
}
