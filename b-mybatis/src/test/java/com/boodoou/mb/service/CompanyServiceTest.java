package com.boodoou.mb.service;


import com.boodoou.common.utils.JsonUtils;
import com.boodoou.mb.entity.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author wong
 * @date 2020/12/21 23:34
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyServiceTest {

    @Resource
    private CompanyService companyService;

    @Test
    public void queryCompanyTest() {
        final Company company = companyService.queryCompany(1L);
        final String json = JsonUtils.toJson(company);
        System.out.println(json);
    }
}