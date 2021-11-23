package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.AllPopul;
import cn.stephen.study.htapitoproject.entity.BeadHousePerson;
import cn.stephen.study.htapitoproject.entity.CommunityPopul;
import cn.stephen.study.htapitoproject.entity.KeyPopul;
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
}
