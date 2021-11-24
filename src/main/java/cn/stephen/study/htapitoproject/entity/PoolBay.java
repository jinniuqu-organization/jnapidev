package cn.stephen.study.htapitoproject.entity;

import lombok.Data;

/**
 * @Acthor Tao.Lee @date 2021/11/24 14:38
 * @Description 窑湾数据接口
 */
@Data
public class PoolBay {
    private Integer Id;
    private String SN;
    private String Town;
    private String Name;
    private String Pos;
    private String Situation;
    private String X;
    private String Y;
    private String Comment;
    private String images;
    private String Person;
    private String Purpose;
}
