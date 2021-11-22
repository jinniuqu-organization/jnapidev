package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/22 11:24
 * @Description 养殖
 */
@Data
public class Farm {
    private Integer id;
    private String SN;
    private String VillageName;
    private String HostName;
    private String Phone;
    private String Images;
    private String Sow;
    private String Boar;
    private String CommercialPig;
    private String DairyCow;
    private String Cattle;
    private String Goat;
    private String Sheep;
    private String LayingHen;
    private String Dorking;
    private String LayingDuck;
    private String MeatDuck;
    private String Goose;
    private String Other;
    private String HasPool;
    private String X;
    private String Y;
    private String Town;
    private String Owner;
    private String Area;
    private String Purpose;
    private String BuildDate;
    private String HasRecord;
    private Boolean deleted;
    private Date etlTime;
}
