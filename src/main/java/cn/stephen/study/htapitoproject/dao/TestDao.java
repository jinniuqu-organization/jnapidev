package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    TestEntity getById(Integer id);

    TestEntity insert(TestEntity testEntity);

}
