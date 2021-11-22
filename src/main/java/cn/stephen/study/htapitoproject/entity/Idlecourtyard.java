package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/22 15:40
 * @Description 闲置院落
 */
@Data
public class Idlecourtyard {
    private Integer id;
    private String SN;
    private String VillageName;
    private String Pos;
    private String LandType;
    private String Area;
    private String Appendant;
    private String UsageStatus;
    private String Contractor;
    private String IdCardNo;
    private String ContractorPhone;
    private String Principal;
    private String PrincipalPhone;
    private String Images;
    private String X;
    private String Y;
    private String Town;
    private String Location;
    private String Purpose;
    private String Materiel;
    private String Lessor;
    private String GridMember;
    private String Phone;
    private Date etlTime;
}
