package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    TestEntity getById(Integer id);

    TestEntity insert(TestEntity testEntity);

}
