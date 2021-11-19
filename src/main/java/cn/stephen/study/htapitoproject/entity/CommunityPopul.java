package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/19 11:42
 * @Description 社区人口实体类
 */
@Data
public class CommunityPopul {

    private Integer		id	;
    private String		CommunityName	;
    private String		NeighbourhoodName	;
    private String		BuildingNo	;
    private String		UnitNo	;
    private String		StoreyNo	;
    private String		HouseholdNo	;
    private String		Name	;
    private String		Relation	;
    private String		Gender	;
    private String		Birthday	;
    private String		IdCardNo	;
    private String		Marriage	;
    private String		Nation	;
    private String		RegistrationStatus	;
    private String		Phone	;
    private String		Address	;
    private String		WorkPlace	;
    private String		PoliticalOrientation	;
    private String		Retiree	;
    private String		Note	;
    private String		RoomNo	;
    private String		Town	;
    private Integer		AuditState	;
    private String		createdOn	;
    private boolean		deleted	;
    private Date        etlTime	;

}
