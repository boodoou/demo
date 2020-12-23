package com.boodoou.mbp.primary.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.boodoou.common.utils.JsonUtils;
import com.boodoou.mbp.primary.entity.Company;
import com.boodoou.mbp.utils.PageUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author wong
 * @date 2020/12/23 18:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CompanyServiceTest {

    @Resource
    private CompanyService companyService;

    /**
     * 分页查询公司
     */
    @Test
    public void queryListPageTest() {
        final Page<Map<Integer, Integer>> page = PageUtils.create(1, 1);
        final List<Company> companies = companyService.queryListPage(page);

        System.out.println(JsonUtils.toJson(companies));
        System.out.println(JsonUtils.toJson(page));
    }
}