package com.boodoou.mbp.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.Map;

/**
 * @author wong
 * @date 2020/12/23 18:36
 */
public class PageUtils {
    /**
     * 获取分页数据
     *
     * @param page p
     * @param size s
     * @return page
     */
    public static Page<Map<Integer, Integer>> create(int page, int size) {
        return new Page<>(page, size);
    }

    /**
     * 禁止实例化
     */
    private PageUtils() {
    }
}
