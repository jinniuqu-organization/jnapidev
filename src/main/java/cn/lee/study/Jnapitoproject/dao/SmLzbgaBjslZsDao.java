package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 市网络理政办-市公安局-110接警数量-详情(正式-智慧蓉城专用)(SmLzbgaBjslZs)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-15 16:48:30
 */
@Mapper
public interface SmLzbgaBjslZsDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmLzbgaBjslZs queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SmLzbgaBjslZs> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param smLzbgaBjslZs 实例对象
     * @return 对象列表
     */
    List<SmLzbgaBjslZs> queryAll(SmLzbgaBjslZs smLzbgaBjslZs);

    /**
     * 新增数据
     *
     * @param smLzbgaBjslZs 实例对象
     * @return 影响行数
     */
    int insert(SmLzbgaBjslZs smLzbgaBjslZs);

    /**
     * 修改数据
     *
     * @param smLzbgaBjslZs 实例对象
     * @return 影响行数
     */
    int update(SmLzbgaBjslZs smLzbgaBjslZs);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmLzbgaBjslZs query(SmLzbgaBjslZs smLzbgaBjslZs);

    void insertBatch(List<SmLzbgaBjslZs> list);

    void updateBatch(List<SmLzbgaBjslZs> list);
}