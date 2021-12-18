package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.CarRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor Tao.Lee
 * @date 2021/12/18 11:44
 * @Description说明：
 */
@Mapper
public interface CarRecordDao {

    void inserCarRecord(CarRecord bean);

}
