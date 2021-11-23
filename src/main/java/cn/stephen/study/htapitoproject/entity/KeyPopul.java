package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/23 13:57
 * @Description 人口
 */
@Data
public class KeyPopul {
    private Integer Id;
    private String Name;
    private String TownName;
    private String VillageName;
    private String IdCardNo;
    private String Address;
    private String Gender;
    private String Phone;
    private String Type;
    private String ExtData;
    private String Remark;
    private Date EtlTime;
}
