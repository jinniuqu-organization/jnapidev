package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

/**
 * @Acthor Tao.Lee @date 2021/11/25 13:55
 * @Description 垃圾清运
 */
@Data
public class RubbishClear {
    private Integer Id;
    private String SN;
    private String Town;
    private String VillageName;
    private String Name;
    private String X;
    private String Y;
    private String Pos;
    private String Situation;
    private String Texture;
    private String Desc;
    private String ImageNo;
    private String ImageUrl;
}
