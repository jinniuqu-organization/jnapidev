package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmWllzFxryzs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-风险人员总数-详情(SmWllzFxryzs)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-16 16:00:13
 */
@Mapper
public interface SmWllzFxryzsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmWllzFxryzs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmWllzFxryzs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smWllzFxryzs 实例对象
     * @return 对象列表
     */
    List<SmWllzFxryzs> queryAll(SmWllzFxryzs smWllzFxryzs);

    /**
     * 新增数据
     *
     * @param smWllzFxryzs 实例对象
     * @return 影响行数
     */
    int insert(SmWllzFxryzs smWllzFxryzs);

    /**
     * 修改数据
     *
     * @param smWllzFxryzs 实例对象
     * @return 影响行数
     */
    int update(SmWllzFxryzs smWllzFxryzs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmWllzFxryzs smWllzFxryzs);

    void insertBatch(List<SmWllzFxryzs> list);

    void updateBatch(List<SmWllzFxryzs> list);
}