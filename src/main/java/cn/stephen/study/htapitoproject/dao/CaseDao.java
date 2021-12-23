package cn.stephen.study.htapitoproject.dao;

import cn.stephen.study.htapitoproject.entity.CarRecord;
import cn.stephen.study.htapitoproject.entity.Case;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Acthor yzz
 * @date 2021/12/21 10:44
 * @Description说明：
 */
@Mapper
public interface CaseDao {
    int insertCase(Case bean);
}
