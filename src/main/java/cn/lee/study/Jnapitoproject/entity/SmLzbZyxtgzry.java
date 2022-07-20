package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * sm_lzb_zyxtgzry
 * @author 
 */
@Data
public class SmLzbZyxtgzry implements Serializable {
    /**
     * 区县名称
     */
    private String districtsName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 角色
     */
    private String role;

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
     * 所属部门
     */
    private String organization;

    /**
     * 更新时间
     */
    private String updateTime;

    private static final long serialVersionUID = 1L;
}