package com.boodoou.mb.service;

import com.boodoou.mb.entity.Company;
import com.boodoou.mb.mapper.CompanyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wong
 * @date 2020/12/18 15:57
 */
@Service
public class CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    /**
     * 查询公司
     *
     * @param id 公司ID
     * @return 公司
     */
    public Company queryCompany(Long id) {
        return companyMapper.queryCompanyById(id);
    }
}
