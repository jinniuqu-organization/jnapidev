package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-风险人员总数-详情(SmWllzFxryzs)实体类
 *
 * @author makejava
 * @since 2022-07-16 16:00:13
 */
@Data
public class SmWllzFxryzs implements Serializable {
    private static final long serialVersionUID = 636895247953108255L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 风险人员总数
    */
    private Long count;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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