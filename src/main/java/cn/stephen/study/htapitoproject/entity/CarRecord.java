package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Acthor Tao.Lee
 * @date 2021/12/18 11:40
 * @Description说明： 车辆出入记录
 */
@Data
public class CarRecord {
    private Long id;
    private String capTimeStr;
    private Integer carBrand;
    private Integer carColor;
    private String carDirect;
    private String carDirectStr;
    private String carImgUrl;
    private Integer carInnerCategory;
    private String carNum;
    private String carNumPic;
    private Integer carNumcolor;
    private Integer carType;
    private String carWayCode;
    private String devChnId;
    private String devChnName;
    private Integer devChnNum;
    private String devId;
    private String devName;
    private Integer draw;
    private String originalPicPath;
    private String parkingLot;
    private String parkingLotCode;
    private String realCapturePicPath;
    private Integer strobeState;
}
