package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sm_lzb_zyxtzyrw
 * @author 
 */
@Data
public class SmLzbZyxtzyrw implements Serializable {
    /**
     * 任务ID
     */
    private String id;

    /**
     * 城市名称
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
     * 任务类型
     */
    private String transferTaskType;

    /**
     * 接送点类型
     */
    private String transferStartType;

    /**
     * 目的地类型
     */
    private String transferDestinationType;

    /**
     * 目的地名称
     */
    private String transferDestinationName;

    /**
     * 目的地地址
     */
    private String transferDestinationDetail;

    /**
     * 任务来源
     */
    private String transferTaskSource;

    /**
     * 车辆来源
     */
    private String transferCarSource;

    /**
     * 车辆ID
     */
    private String carId;

    /**
     * 车牌
     */
    private String carNo;

    /**
     * 准载人数
     */
    private String allowedPassengerNum;

    /**
     * 停放位置
     */
    private String parkingAddress;

    /**
     * 车辆联系电话
     */
    private String carPhone;

    /**
     * 司机来源
     */
    private String transferDriverSource;

    /**
     * 司机ID
     */
    private String driverId;

    /**
     * 司机名字
     */
    private String driverName;

    /**
     * 司机联系电话
     */
    private String driverPhone;

    /**
     * 随车人员来源
     */
    private String transferAccompanySource;

    /**
     * 随车人员ID
     */
    private String accompanyId;

    /**
     * 随车人员名字
     */
    private String accompanyName;

    /**
     * 随车人员联系电话
     */
    private String accompanyPhone;

    /**
     * 预计接送时间
     */
    private String expectTransferBeginTime;

    /**
     * 接送位置
     */
    private String transferBeginAddress;

    /**
     * 预计送达时间
     */
    private String expectTransferEndTime;

    /**
     * 送达时间
     */
    private String transferEndTime;

    /**
     * 转运任务状态
     */
    private String transferTaskStatus;

    /**
     * 派单人姓名
     */
    private String createUserName;

    /**
     * 接单时间
     */
    private String orderConfirmTime;

    /**
     * 接单人姓名
     */
    private String orderConfirmUserName;

    /**
     * 目的地联系人姓名
     */
    private String destinationContactsName;

    /**
     * 目的地联系人电话
     */
    private String destinationContactsPhone;

    /**
     * 任务创建方式
     */
    private String taskCreateWay;

    /**
     * 任务标签
     */
    private String transferTaskTag;

    /**
     * 航空公司
     */
    private String airlineCompany;

    /**
     * 航班号
     */
    private String flightNumber;

    /**
     * 备注
     */
    private String remark;

    /**
     * 任务类型
     */
    private String taskType;

    /**
     * 分配进度
     */
    private String assignSpeed;

    /**
     * 车型
     */
    private String carType;

    private static final long serialVersionUID = 1L;
}