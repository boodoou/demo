package com.boodoou.mbp.primary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 公司
 *
 * @author wong
 * @date 2020/12/16 12:20
 */
@Data
@Accessors(chain = true)
@TableName(value = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
