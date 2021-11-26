package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.*;
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
    //旱厕改造
    void insertLatrineReform(LatrineReform bean);
    //九小场所
    void insertNineSmallPlaces(NineSmallPlaces bean);
    //窑厂
    void insertPoolBay(PoolBay bean);
    //垃圾清运
    void insertRubbishClear(RubbishClear bean);
    //水井
    void insertWaterWell(WaterWell bean);
    //信教人员
    void insertXinJiaoRenYuan(XinJiaoRenYuan bean);
    //种粮大户
    void insertZhongLiangDaHu(ZhongLiangDaHu bean);
}
