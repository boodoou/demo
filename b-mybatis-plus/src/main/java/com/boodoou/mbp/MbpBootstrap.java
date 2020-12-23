package com.boodoou.mbp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wong
 * @date 2020/12/23 17:03
 */
@Slf4j
@SpringBootApplication
public class MbpBootstrap {

    public static void main(String[] args) {
        log.info("Start mybatis-plus demo ...");
        SpringApplication.run(MbpBootstrap.class, args);
    }
}
