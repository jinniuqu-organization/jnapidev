package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.Farm;
import cn.stephen.study.htapitoproject.entity.Housing;
import cn.stephen.study.htapitoproject.entity.Idlecourtyard;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor Tao.Lee @date 2021/11/22 11:29
 * @Description 养殖农业统一dao
 */
@Mapper
public interface FarmingAgricultureDao {

    void insertFarm(Farm bean);

    void insertHousing(Housing bean);

    void insertIdlecouryard(Idlecourtyard bean);
}
