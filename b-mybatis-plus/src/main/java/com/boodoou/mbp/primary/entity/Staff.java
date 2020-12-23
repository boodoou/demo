package com.boodoou.mbp.primary.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工
 *
 * @author wong
 * @date 2020/12/16 12:21
 */
@Data
@Builder
@Accessors(chain = true)
@TableName(value = "staff")
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_UUID)
    private String id;
    private long deptId;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
