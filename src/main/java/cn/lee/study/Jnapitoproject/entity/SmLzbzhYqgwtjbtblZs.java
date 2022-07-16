package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-智慧蓉城疫情防控专班-按公卫数据统计所有本土在院病例-详情(正式)-接入基础技术文档(SmLzbzhYqgwtjbtblZs)实体类
 *
 * @author makejava
 * @since 2022-07-16 11:07:32
 */
@Data
public class SmLzbzhYqgwtjbtblZs implements Serializable {
    private static final long serialVersionUID = 874238710693853605L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 计数
    */
    private String count;
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

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
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