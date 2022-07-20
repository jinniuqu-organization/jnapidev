package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbZyxtzyrw;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 市网络理政办-智慧蓉城-转运系统转运任务-详情接口(SmLzbZyxtzyrw)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-20 03:28:13
 */
@Mapper
public interface SmLzbZyxtzyrwDao extends BaseMapper<SmLzbZyxtzyrw> {

/**
* 批量新增或按主键更新数据（MyBatis原生foreach方法）
*
* @param entities List<SmLzbZyxtzyrw> 实例对象列表
* @return 影响行数
* @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
*/
int insertOrUpdateBatch(@Param("entities") List<SmLzbZyxtzyrw> entities);

}

