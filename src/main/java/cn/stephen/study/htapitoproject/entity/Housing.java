package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/22 14:39
 * @Description 住房信息
 */
@Data
public class Housing {
    private Integer id;
    private String IdCardNo;
    private String HouseholdNo;
    private String LiveProperty;
    private String BuildingProperty;
    private String BuildingUsage;
    private String UpLayerNum;
    private String DownLayerNum;
    private String NumPerLayer;
    private String HourseStatus;
    private String HourseUsage;
    private String HourseCode;
    private String Address;
    private String Town;
    private String VillageName;
    private Boolean deleted;
    private Date etlTime;
}
