CREATE TABLE `account` (
                           `id` varchar(32) NOT NULL COMMENT '账号',
                           `name` varchar(100) NOT NULL COMMENT '账户名',
                           `password` varchar(64) NOT NULL COMMENT '密码',
                           `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                           `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                           PRIMARY KEY (`id`),
                           UNIQUE KEY `account_name_IDX` (`name`) USING BTREE,
                           KEY `account_create_time_IDX` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户表';

CREATE TABLE `user` (
                        `id` varchar(100) NOT NULL COMMENT 'ID',
                        `nick` varchar(100) NOT NULL COMMENT '昵称',
                        `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                        `update_time` datetime DEFAULT NULL COMMENT '更新时间',
                        PRIMARY KEY (`id`),
                        KEY `user_create_time_IDX` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE `account_user` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
                                `aid` varchar(32) NOT NULL COMMENT '账号',
                                `uid` varchar(32) NOT NULL COMMENT '用户ID',
                                `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态',
                                `create_time` datetime DEFAULT NULL COMMENT '创建时间',
                                `update_time` varchar(100) DEFAULT NULL COMMENT '更新时间',
                                PRIMARY KEY (`id`),
                                UNIQUE KEY `account_user_un` (`aid`,`uid`),
                                KEY `account_user_create_time_IDX` (`create_time`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='账户-用户关系表';