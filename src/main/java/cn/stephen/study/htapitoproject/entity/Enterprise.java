package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee @date 2021/11/19 15:37
 * @Description
 */
@Data
public class Enterprise {
    private Integer	Id		;
    private String	SmId		;
    private String	Name		;
    private String	Type		;
    private String	RegCapital		;
    private String	EstablishedTime		;
    private String	Status		;
    private String	Pos		;
    private String	X		;
    private String	Y		;
    private String	RawMaterial		;
    private String	Product		;
    private String	SalesRevenue		;
    private String	TechProcess		;
    private String	Phone		;
    private String	Email		;
    private String	BuzLicense		;
    private String	EIA		;
    private String	EIAcheck		;
    private String	FireControlFile		;
    private String	Certificate		;
    private String	TwoSysBuild		;
    private String	HazardRp		;
    private String	EmergencyPlan		;
    private String	Area		;
    private String	LandCardNo		;
    private String	LandType		;
    private String	LegalPerson		;
    private String	LegalPhone		;
    private String	Principal		;
    private String	SecPrincipal		;
    private String	SecOfficer		;
    private String	GridMember		;
    private String	ProdEquipment		;
    private String	EnvEquipment		;
    private String	SolidWaste		;
    private String	HazardousWaste		;
    private String	WastewaterOut		;
    private String	RaiseDust		;
    private String	ProdDust		;
    private String	ExhaustGasOut		;
    private String	StaffTotal		;
    private String	StaffGraduateAbove		;
    private String	StaffUndergraduate		;
    private String	StaffJuniorCollege		;
    private String	StaffOther		;
    private String	HasPartyOrg		;
    private String	PartyMemberTotal		;
    private String	VillageCode		;
    private String	Town		;
    private String	VillageName		;
    private String	IndustryType		;
    private String	IndustryCode		;
    private String	CurrentStatus		;
    private String	JiGaiShiJianNeiRong		;
    private String	LiXiangNeiRongWenHaoShiJian;
    private Date    EtlTime;

}
