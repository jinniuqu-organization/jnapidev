package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-市公安局-110接警数量-详情(正式-智慧蓉城专用)(SmLzbgaBjslZs)实体类
 *
 * @author makejava
 * @since 2022-07-15 16:59:03
 */
@Data
public class SmLzbgaBjslZs implements Serializable {
    private static final long serialVersionUID = -58599030404027793L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 接警数量
    */
    private String dreamdbNum;
    /**
    * 区划代码
    */
    private String dreamdbOrgCode;
    /**
    * 区划名称
    */
    private String orgName;
    /**
    * 时间
    */
    private String businessTime;
    /**
    * 插入时间
    */
    private Date insertTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    
    private Integer deleteFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDreamdbNum() {
        return dreamdbNum;
    }

    public void setDreamdbNum(String dreamdbNum) {
        this.dreamdbNum = dreamdbNum;
    }

    public String getDreamdbOrgCode() {
        return dreamdbOrgCode;
    }

    public void setDreamdbOrgCode(String dreamdbOrgCode) {
        this.dreamdbOrgCode = dreamdbOrgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getBusinessTime() {
        return businessTime;
    }

    public void setBusinessTime(String businessTime) {
        this.businessTime = businessTime;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

}