package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmLzbwjJjglsZs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-市卫健委-居家隔离数-详情(正式)(SmLzbwjJjglsZs)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-15 19:16:41
 */
@Mapper
public interface SmLzbwjJjglsZsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmLzbwjJjglsZs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmLzbwjJjglsZs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smLzbwjJjglsZs 实例对象
     * @return 对象列表
     */
    List<SmLzbwjJjglsZs> queryAll(SmLzbwjJjglsZs smLzbwjJjglsZs);

    /**
     * 新增数据
     *
     * @param smLzbwjJjglsZs 实例对象
     * @return 影响行数
     */
    int insert(SmLzbwjJjglsZs smLzbwjJjglsZs);

    /**
     * 修改数据
     *
     * @param smLzbwjJjglsZs 实例对象
     * @return 影响行数
     */
    int update(SmLzbwjJjglsZs smLzbwjJjglsZs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmLzbwjJjglsZs smLzbwjJjglsZs);

    void insertBatch(List<SmLzbwjJjglsZs> list);

    void updateBatch(List<SmLzbwjJjglsZs> list);
}