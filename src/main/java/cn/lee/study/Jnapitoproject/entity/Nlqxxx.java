package cn.lee.study.Jnapitoproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author LeeTao
 * @Date 2022/7/11 16:20
 * @Dxplanation
 */
@Data
@TableName("dwv_qxxx")
public class Nlqxxx {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String dwmc;

    private String jdx;

    private String wdy;

    private String dqtq;

    private String dqwd;

    private String dqjylqd;

    private String dqsj;

    private Date etlTime;

}
