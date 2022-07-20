package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbZyxtclxx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 市网络理政办-智慧蓉城-转运系统车辆信息-详情接口(SmLzbZyxtclxx)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 02:27:02
 */
@Mapper
public interface SmLzbZyxtclxxDao extends BaseMapper<SmLzbZyxtclxx> {

/**
* 批量新增数据（MyBatis原生foreach方法）
*
* @param entities List<SmLzbZyxtclxx> 实例对象列表
* @return 影响行数
*/
int insertBatch(@Param("entities") List<SmLzbZyxtclxx> entities);

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SmLzbZyxtclxx> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SmLzbZyxtclxx> entities);

}

