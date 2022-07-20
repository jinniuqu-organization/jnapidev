package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sm_lzb_zyxtclxx
 * @author 
 */
@Data
public class SmLzbZyxtclxx implements Serializable {
    /**
     * ID
     */
    private String id;

    /**
     * 车牌
     */
    private String 车牌;

    /**
     * 车型
     */
    private String type;

    /**
     * 准载人数
     */
    private String allowedPassengerNum;

    /**
     * 驾照类型
     */
    private String licenseType;

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
     * 停放位置
     */
    private String parkingAddress;

    /**
     * 所属单位
     */
    private String organization;

    private static final long serialVersionUID = 1L;
}