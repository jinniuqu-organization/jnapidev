package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-市卫健委-居家隔离数-详情(正式)(SmLzbwjJjglsZs)实体类
 *
 * @author makejava
 * @since 2022-07-15 19:16:41
 */
@Data
public class SmLzbwjJjglsZs implements Serializable {
    private static final long serialVersionUID = -18518881335467250L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 人数
    */
    private String num;
    /**
    * 区（市）县code
    */
    private String dreamdbStreetCode;
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