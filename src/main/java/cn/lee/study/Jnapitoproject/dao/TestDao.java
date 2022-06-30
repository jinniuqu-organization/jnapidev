package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.TestEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestDao {

    List<TestEntity> getById(String id);

    TestEntity insert(TestEntity testEntity);

}
