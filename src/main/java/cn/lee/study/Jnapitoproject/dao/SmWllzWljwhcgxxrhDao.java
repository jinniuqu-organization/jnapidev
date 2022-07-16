package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmWllzWljwhcgxxrh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-文旅局-文化场馆信息-详情(融合服务)(SmWllzWljwhcgxxrh)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-15 19:49:14
 */
@Mapper
public interface SmWllzWljwhcgxxrhDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmWllzWljwhcgxxrh queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmWllzWljwhcgxxrh> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smWllzWljwhcgxxrh 实例对象
     * @return 对象列表
     */
    List<SmWllzWljwhcgxxrh> queryAll(SmWllzWljwhcgxxrh smWllzWljwhcgxxrh);

    /**
     * 新增数据
     *
     * @param smWllzWljwhcgxxrh 实例对象
     * @return 影响行数
     */
    int insert(SmWllzWljwhcgxxrh smWllzWljwhcgxxrh);

    /**
     * 修改数据
     *
     * @param smWllzWljwhcgxxrh 实例对象
     * @return 影响行数
     */
    int update(SmWllzWljwhcgxxrh smWllzWljwhcgxxrh);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmWllzWljwhcgxxrh smWllzWljwhcgxxrh);

    void insertBatch(List<SmWllzWljwhcgxxrh> list);

    void updateBatch(List<SmWllzWljwhcgxxrh> list);
}