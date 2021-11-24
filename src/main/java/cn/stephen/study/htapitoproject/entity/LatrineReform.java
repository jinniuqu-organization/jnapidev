package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

/**
 * @Acthor Tao.Lee @date 2021/11/24 10:01
 * @Description
 */
@Data
public class LatrineReform {
    private Integer Id;
    private String IdCardNo;
    private String HouseholdNo;
    private String Name;
    private String Relation;
    private String Committee;
    private String Address;
    private String DryToilet;
    private String DryToiletType;
    private String DryToiletUsageType;
    private String HourseCode;
    private String Gas2Coal;
    private String Ele2Coal;
    private String X;
    private String Y;
    private String Town;
    private String ToiletType;
    private String ToiletDryDate;
    private String IsMaintain;
    private String HeatType;
    private String HeatDryDate;
    private String Image;
    private String HeatImage;
}
