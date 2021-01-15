package com.boodoou.rd.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wong
 * @date 2020/12/28 10:59
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCacheTest {

    @Resource
    public RedisCache redisCache;

    @Test
    public void commonSetTest() {
        redisCache.getCommonSet().add("TEST");
    }
}