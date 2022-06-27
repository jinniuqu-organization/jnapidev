package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.Case;
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
