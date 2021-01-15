package com.boodoou.rd;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wong
 * @date 2020/12/23 19:18
 */
@Slf4j
@SpringBootApplication
public class RdBootstrap {
    public static void main(String[] args) {
        log.info("Start redis ...");
        SpringApplication.run(RdBootstrap.class, args);
    }
}
