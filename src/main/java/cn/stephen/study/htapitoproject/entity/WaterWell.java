package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

/**
 * @Acthor Tao.Lee @date 2021/11/26 9:57
 * @Description 水井
 */
@Data
public class WaterWell {
    private Integer ID;
    private String SmX;
    private String SmY;
    private String SmLibTileID;
    private String SmUserID;
    private String SmGeometrySize;
    private String SmGeoPosition;
    private String DotNo;
    private String VillageName;
    private String WellCode;
    private String Name;
    private String Pos;
    private String Depth;
    private String WaterLevel;
    private String ImageNo;
    private String Town;
    private String Phone;
    private String comment;
}
