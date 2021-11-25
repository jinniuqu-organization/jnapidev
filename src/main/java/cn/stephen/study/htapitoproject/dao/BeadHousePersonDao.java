package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.*;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor Tao.Lee @date 2021/11/18 13:56
 * @Description
 */
@Mapper
public interface BeadHousePersonDao {

    void insert(BeadHousePerson bean);

    void insertpopul(CommunityPopul bean);

    void insertKeypopul(KeyPopul bean);

    void insertAllpopul(AllPopul bean);
    //扶贫数据
    void insertPoverty(Poverty bean);
}
