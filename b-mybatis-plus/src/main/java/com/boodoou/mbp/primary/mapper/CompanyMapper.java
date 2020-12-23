package com.boodoou.mbp.primary.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boodoou.mbp.primary.entity.Company;

import java.util.List;
import java.util.Map;

/**
 * 公司
 *
 * @author wong
 * @date 2020/12/16 12:21
 */
public interface CompanyMapper extends BaseMapper<Company> {
    List<Company> queryListPage(Page<Map<Integer, Integer>> page);
}
