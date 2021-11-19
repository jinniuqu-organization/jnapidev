package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.Enterprise;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor Tao.Lee @date 2021/11/19 14:48
 * @Description
 */
@Mapper
public interface EnterpriseDao {

    void insertEnterprise(Enterprise bean);
}
