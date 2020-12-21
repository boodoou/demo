package com.boodoou.mb;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动
 *
 * @author boododu
 */
@Slf4j
@SpringBootApplication
@MapperScan("com.boodoou.mb.mapper")
public class MbBootstrap {
    public static void main(String[] args) {
        log.info("Start mb ...");
        SpringApplication.run(MbBootstrap.class, args);
    }
}
