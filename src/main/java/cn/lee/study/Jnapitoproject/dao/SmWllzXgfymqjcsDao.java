package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmWllzXgfymqjcs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-新冠肺炎累计排查密切接触者数-详情(SmWllzXgfymqjcs)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-15 19:32:50
 */
@Mapper
public interface SmWllzXgfymqjcsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmWllzXgfymqjcs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmWllzXgfymqjcs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smWllzXgfymqjcs 实例对象
     * @return 对象列表
     */
    List<SmWllzXgfymqjcs> queryAll(SmWllzXgfymqjcs smWllzXgfymqjcs);

    /**
     * 新增数据
     *
     * @param smWllzXgfymqjcs 实例对象
     * @return 影响行数
     */
    int insert(SmWllzXgfymqjcs smWllzXgfymqjcs);

    /**
     * 修改数据
     *
     * @param smWllzXgfymqjcs 实例对象
     * @return 影响行数
     */
    int update(SmWllzXgfymqjcs smWllzXgfymqjcs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmWllzXgfymqjcs smWllzXgfymqjcs);

    void insertBatch(List<SmWllzXgfymqjcs> list);

    void updateBatch(List<SmWllzXgfymqjcs> list);
}