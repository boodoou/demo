package com.boodoou.kfk.consummer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author wong
 * @date 2021/1/15 20:03
 */
@Slf4j
@Component
public class Consumer {

    /**
     * 新文章监控
     *
     * @param record r
     */
    @KafkaListener(topics = {"EssaysRcmdAlpha"}, autoStartup = "${biz.consumer}")
    public void newEssayListener(ConsumerRecord<?, ?> record) {
    }
}
