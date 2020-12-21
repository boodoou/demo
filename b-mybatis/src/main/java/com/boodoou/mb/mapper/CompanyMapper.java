package com.boodoou.mb.mapper;

import com.boodoou.mb.entity.Company;
import org.springframework.stereotype.Repository;

/**
 * 公司
 *
 * @author wong
 * @date 2020/12/18 15:51
 */
@Repository
public interface CompanyMapper {
    /**
     * 查询公司
     *
     * @param id 公司IDs
     * @return 公司
     */
    Company queryCompanyById(Long id);
}
