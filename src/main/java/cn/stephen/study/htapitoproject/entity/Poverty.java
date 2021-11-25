package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

/**
 * @Acthor Tao.Lee @date 2021/11/25 10:24
 * @Description 扶贫数据
 */
@Data
public class Poverty {
    private Integer Id;
    private String Type;
    private String City;
    private String Town;
    private String AdminVillage;
    private String NaturalVillage;
    private String HouseholdNo;
    private String PersonCode;
    private String Name;
    private String IdCardNo;
    private String NumOfPeople;
    private String Relation;
    private String Nation;
    private String EducationalLevel;
    private String StudentStatus;
    private String HealthCondition;
    private String Skills;
    private String WorkingCondition;
    private String WorkingTime;
    private String HasDBYL;
    private String OffPoverty;
    private String OffPovertyYear;
    private String PovertyLevel;
    private String PovertyCauses;
    private String DangerousBuilding;
    private String HasSafeWater;
    private String PerIncome;
    private String Phone;
    private String Remark;
    private String ZiLiNengLi;
    private String JianHuRen;
    private String JianHuRenPhone;
}
