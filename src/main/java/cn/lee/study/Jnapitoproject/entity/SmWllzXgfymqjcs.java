package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-新冠肺炎累计排查密切接触者数-详情(SmWllzXgfymqjcs)实体类
 *
 * @author makejava
 * @since 2022-07-15 19:32:50
 */
@Data
public class SmWllzXgfymqjcs implements Serializable {
    private static final long serialVersionUID = 648057487746326351L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 累计人数
    */
    private String tjrq;
    /**
    * 截止日期
    */
    private String dreamdbLjrs;
    /**
    * 插入时间
    */
    private Date insertTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    
    private Integer deleteFlag;


}