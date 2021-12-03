package cn.stephen.study.htapitoproject.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor Tao.Lee
 * @date 2021/12/2 15:53
 * @Description说明：
 */
@Mapper
public interface TruncateTableDao {
    //清空所有表
    void truncathAllTable(String tablename);
}
