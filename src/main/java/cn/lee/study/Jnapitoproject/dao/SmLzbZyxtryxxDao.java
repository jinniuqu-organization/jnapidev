package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbZyxtryxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 市网络理政办-智慧蓉城-转运系统工作人员-详情接口(SmLzbZyxtryxx)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 03:22:01
 */
@Mapper
public interface SmLzbZyxtryxxDao extends BaseMapper<SmLzbZyxtryxx> {


/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SmLzbZyxtryxx> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SmLzbZyxtryxx> entities);

}

