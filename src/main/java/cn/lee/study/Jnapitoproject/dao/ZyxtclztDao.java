package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.zyxtclzt;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZyxtclztDao {


    zyxtclzt query(String ID);

    void insertBatch(List<zyxtclzt> list);

    void updateBatch(List<zyxtclzt> list);
}