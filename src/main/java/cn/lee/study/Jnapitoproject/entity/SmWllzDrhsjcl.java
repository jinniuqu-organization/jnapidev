package cn.lee.study.Jnapitoproject.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 市网络理政办-当日核酸检测采样量-详情(SmWllzDrhsjcl)实体类
 *
 * @author makejava
 * @since 2022-07-16 15:47:37
 */
@Data
public class SmWllzDrhsjcl implements Serializable {
    private static final long serialVersionUID = 236732836797508304L;
    /**
    * 自增主键
    */
    private Long id;
    /**
    * 当日核酸检测采样量
    */
    private String hsrs;
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

    public String getHsrs() {
        return hsrs;
    }

    public void setHsrs(String hsrs) {
        this.hsrs = hsrs;
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