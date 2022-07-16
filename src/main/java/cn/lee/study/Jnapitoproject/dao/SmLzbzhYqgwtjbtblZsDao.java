package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmLzbzhYqgwtjbtblZs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-智慧蓉城疫情防控专班-按公卫数据统计所有本土在院病例-详情(正式)-接入基础技术文档(SmLzbzhYqgwtjbtblZs)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-16 11:07:32
 */
@Mapper
public interface SmLzbzhYqgwtjbtblZsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmLzbzhYqgwtjbtblZs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmLzbzhYqgwtjbtblZs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smLzbzhYqgwtjbtblZs 实例对象
     * @return 对象列表
     */
    List<SmLzbzhYqgwtjbtblZs> queryAll(SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs);

    /**
     * 新增数据
     *
     * @param smLzbzhYqgwtjbtblZs 实例对象
     * @return 影响行数
     */
    int insert(SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs);

    /**
     * 修改数据
     *
     * @param smLzbzhYqgwtjbtblZs 实例对象
     * @return 影响行数
     */
    int update(SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs);

    void insertBatch(List<SmLzbzhYqgwtjbtblZs> list);

    void updateBatch(List<SmLzbzhYqgwtjbtblZs> list);
}