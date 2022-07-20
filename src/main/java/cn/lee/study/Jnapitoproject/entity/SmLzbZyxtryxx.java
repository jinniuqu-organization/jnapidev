package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sm_lzb_zyxtryxx
 * @author 
 */
@Data
public class SmLzbZyxtryxx implements Serializable {
    /**
     * 人员ID
     */
    private String id;

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 转运状态
     */
    private String transferSubStatus;

    /**
     * 城市
     */
    private String cityName;

    /**
     * 区县
     */
    private String districtsCode;

    /**
     * 街道
     */
    private String streetCode;

    /**
     * 社区
     */
    private String communityName;

    /**
     * 国籍
     */
    private String nationality;

    /**
     * 居住地址
     */
    private String residentialAddress;

    /**
     * 户籍地址
     */
    private String permanentAddress;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String sex;

    /**
     * 证件类型
     */
    private String cardType;

    /**
     * 证件号
     */
    private String cardId;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 标签
     */
    private String transferPersonTag;

    /**
     * 来源
     */
    private String transferPersonSource;

    /**
     * 管控措施
     */
    private String transferPersonControlWay;

    /**
     * 健康状态
     */
    private String healthStatus;

    /**
     * 健康码状态
     */
    private String healthCodeStatus;

    /**
     * 航班号
     */
    private String flightNumber;

    /**
     * 座位号
     */
    private String seatNumber;

    /**
     * 是否发热
     */
    private String feelHot;

    /**
     * 入境时间
     */
    private String entryTime;

    /**
     * 预计接送时间
     */
    private String expectGetOnTime;

    /**
     * 预计接送地址
     */
    private String expectGetOnAddress;

    /**
     * 预计目的地
     */
    private String expectGetOffAddress;

    /**
     * 下发时间
     */
    private String xfTime;

    /**
     * 状态
     */
    private String status;

    /**
     * 取消转运原因
     */
    private String cancelTransferReason;

    /**
     * 更新时间
     */
    private String updateTime;

    private static final long serialVersionUID = 1L;
}