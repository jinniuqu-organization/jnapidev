package cn.lee.study.Jnapitoproject.dao;

import cn.lee.study.Jnapitoproject.entity.Nldwcode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author LeeTao
 * @Date 2022/7/12 10:25
 * @Dxplanation
 */
@Mapper
public interface NldwcodeDao {
    List<Nldwcode> selectList();
}
