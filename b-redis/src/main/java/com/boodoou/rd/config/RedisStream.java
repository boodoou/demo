package com.boodoou.rd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 推荐缓存配置
 *
 * @author wong
 * @date 2020/10/27 13:59
 */
@Configuration
@ConfigurationProperties(prefix = "redis.stream")
public class RedisStream extends RedisConfig {
}
