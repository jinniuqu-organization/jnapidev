package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-文旅局-文化场馆信息-详情(融合服务)(SmWllzWljwhcgxxrh)实体类
 *
 * @author makejava
 * @since 2022-07-15 19:49:14
 */
@Data
public class SmWllzWljwhcgxxrh implements Serializable {
    private static final long serialVersionUID = -48413562300026833L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 详细地址
    */
    private String detailedAddress;
    /**
    * 开放时间（结束时间）
    */
    private String endTime;
    /**
    * 经纬度
    */
    private String position;
    /**
    * 开放时间（开始时间）
    */
    private String startTime;
    /**
    * 标签
    */
    private String label;
    /**
    * 适合人群
    */
    private String crowd;
    /**
    * 等级
    */
    private String grade;
    /**
    * 联系电话
    */
    private String mobilePhone;
    /**
    * 名称
    */
    private String name;
    /**
    * 最大服务人数
    */
    private String number;
    /**
    * 地址省市区
    */
    private String addressAreaCode;
    /**
    * 详细介绍
    */
    private String detailedIntroduction;
    
    private String objectId;
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