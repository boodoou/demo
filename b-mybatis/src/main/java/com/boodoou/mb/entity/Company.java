package com.boodoou.mb.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * 公司
 *
 * @author wong
 * @date 2020/12/16 12:20
 */
@Data
@ToString
@Accessors(chain = true)
public class Company {

    private long id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
