package com.boodoou.mbp.primary.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boodoou.mbp.primary.entity.Company;
import com.boodoou.mbp.primary.mapper.CompanyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 公司
 *
 * @author wong
 * @date 2020/12/16 15:20
 */
@Slf4j
@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 分页查询公司
     *
     * @param page page
     * @return list
     */
    List<Company> queryListPage(Page<Map<Integer, Integer>> page) {
        return companyMapper.queryListPage(page);
    }
}
