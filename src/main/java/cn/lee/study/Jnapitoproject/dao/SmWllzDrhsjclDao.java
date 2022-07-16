package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmWllzDrhsjcl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-当日核酸检测采样量-详情(SmWllzDrhsjcl)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-16 15:47:37
 */
@Mapper
public interface SmWllzDrhsjclDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmWllzDrhsjcl queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmWllzDrhsjcl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smWllzDrhsjcl 实例对象
     * @return 对象列表
     */
    List<SmWllzDrhsjcl> queryAll(SmWllzDrhsjcl smWllzDrhsjcl);

    /**
     * 新增数据
     *
     * @param smWllzDrhsjcl 实例对象
     * @return 影响行数
     */
    int insert(SmWllzDrhsjcl smWllzDrhsjcl);

    /**
     * 修改数据
     *
     * @param smWllzDrhsjcl 实例对象
     * @return 影响行数
     */
    int update(SmWllzDrhsjcl smWllzDrhsjcl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmWllzDrhsjcl smWllzDrhsjcl);

    void insertBatch(List<SmWllzDrhsjcl> list);

    void updateBatch(List<SmWllzDrhsjcl> list);
}