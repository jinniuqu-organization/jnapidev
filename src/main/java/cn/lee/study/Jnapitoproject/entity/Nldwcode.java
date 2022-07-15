package cn.lee.study.Jnapitoproject.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author LeeTao
 * @Date 2022/7/12 10:22
 * @Dxplanation
 */
@Data
@TableName("dwv_dw_code")
public class Nldwcode {

    private Long code;

    private String dwmc;

    private String jdx;

    private String wdy;
}
