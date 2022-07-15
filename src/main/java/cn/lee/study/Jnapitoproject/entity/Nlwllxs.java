package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author LeeTao
 * @Date 2022/7/12 11:17
 * @Dxplanation
 */
@Data
public class Nlwllxs {

    private Integer id;

    private String dw;

    private String jdx;

    private String wdy;

    private BigDecimal wllxsgl;

    private BigDecimal wllxsqd;

    private String yjxx;

    private String dqsj;

    private Date etlTime;
}
