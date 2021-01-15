package com.boodoou.rd.cache;

import com.boodoou.rd.config.RedisCommon;
import com.boodoou.rd.config.RedisStream;
import org.redisson.api.RSet;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author wong
 * @date 2020/12/28 10:39
 */
@Component
public class RedisCache {

    private final RedissonClient common;
    private final RedissonClient stream;

    @Autowired
    public RedisCache(RedisCommon redisCommon, RedisStream redisStream) {
        this.common = redisCommon.getClient();
        this.stream = redisStream.getClient();
    }

    public RSet<String> getCommonSet() {
        return common.getSet("BD_SET_TEST");
    }
}
