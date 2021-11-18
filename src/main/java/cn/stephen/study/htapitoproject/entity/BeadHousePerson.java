package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/18 13:49
 * @Description 养老院人员
 */
@Data
public class BeadHousePerson {

    private Integer id;

    private Integer auditState;

    private String name;

    private String gender;

    private String idcardNo;

    private String phone;

    private String selfCare;

    private String household;

    private String buildupArea;

    private String isPoor;

    private String town;

    private String villageName;

    private Boolean deleted;

    private String createdOn;

    private Date etlTime;
}
