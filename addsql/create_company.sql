CREATE TABLE `company` (
                           `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                           `name` varchar(32) NOT NULL COMMENT '公司名称',
                           `create_time` datetime NOT NULL COMMENT '创建时间',
                           `update_time` datetime NOT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`),
                           KEY `company_create_time_IDX` (`create_time`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='公司表';

CREATE TABLE `dept` (
                        `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                        `cid` bigint(20) NOT NULL COMMENT '公司ID',
                        `name` varchar(100) NOT NULL COMMENT '名称',
                        `create_time` datetime NOT NULL COMMENT '创建时间',
                        `update_time` datetime NOT NULL COMMENT '更新时间',
                        PRIMARY KEY (`id`),
                        KEY `dept_fk` (`cid`),
                        KEY `dept_create_time_IDX` (`create_time`) USING BTREE,
                        CONSTRAINT `dept_fk` FOREIGN KEY (`cid`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='部门表';

CREATE TABLE `staff` (
                         `id` varchar(32) NOT NULL COMMENT 'ID',
                         `name` varchar(100) NOT NULL COMMENT '姓名',
                         `dept_id` bigint(20) NOT NULL COMMENT '部门ID',
                         `create_time` datetime NOT NULL COMMENT '创建时间',
                         `update_time` datetime NOT NULL COMMENT '更新时间',
                         PRIMARY KEY (`id`),
                         KEY `staff_fk` (`dept_id`),
                         KEY `staff_create_time_IDX` (`create_time`) USING BTREE,
                         CONSTRAINT `staff_fk` FOREIGN KEY (`dept_id`) REFERENCES `dept` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工表';