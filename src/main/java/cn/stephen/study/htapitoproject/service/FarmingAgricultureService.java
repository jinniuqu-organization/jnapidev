package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.FarmingAgricultureDao;
import cn.stephen.study.htapitoproject.entity.*;
import cn.stephen.study.htapitoproject.utils.HttpUtil;
import cn.stephen.study.htapitoproject.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Acthor Tao.Lee
 * @date 2021/11/22 11:30
 * @Description 养殖农业统一业务层
 */
@Slf4j
@Service
public class FarmingAgricultureService {

    @Resource
    private FarmingAgricultureDao farmingAgricultureDao;

    @Value("${token}")
    public String token;

    //养殖鸡鸭鹅
    //每天2点5分执行一次
    //@Scheduled(cron ="0 * * * * ?")
    @Scheduled(cron ="0 5 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertFarm() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/Farm", parameters, head);
        log.info("#######" + "养殖鸡鸭鹅");
        if (null != result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                Farm bean=new Farm();
                bean.setId((Integer) map.get("id"));
                bean.setSN((String) map.get("sn"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setHostName((String) map.get("hostName"));
                bean.setPhone((String) map.get("phone"));
                bean.setImages((String) map.get("pos"));
                bean.setSow((String) map.get("sow"));
                bean.setBoar((String) map.get("boar"));
                bean.setCommercialPig((String) map.get("commercialPig"));
                bean.setDairyCow((String) map.get("dairyCow"));
                bean.setCattle((String) map.get("cattle"));
                bean.setGoat((String) map.get("goat"));
                bean.setSheep((String) map.get("sheep"));
                bean.setLayingHen((String) map.get("layingHen"));
                bean.setDorking((String) map.get("dorking"));
                bean.setLayingDuck((String) map.get("layingDuck"));
                bean.setMeatDuck((String) map.get("meatDuck"));
                bean.setGoose((String) map.get("goose"));
                bean.setOther((String) map.get("other"));
                bean.setHasPool((String) map.get("hasPool"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setTown((String) map.get("town"));
                bean.setOwner((String) map.get("owner"));
                bean.setArea((String) map.get("area"));
                bean.setPurpose((String) map.get("purpose"));
                bean.setBuildDate((String) map.get("buildDate"));
                bean.setHasRecord((String) map.get("hasRecord"));
                bean.setDeleted((Boolean) map.get("deleted"));
                bean.setEtlTime(new Date());
                farmingAgricultureDao.insertFarm(bean);
                //log.info(bean.getHostName());
            }
        }
    }

    //住房
    //每天1点45分执行一次
    //@Scheduled(cron ="0 * * * * ?")
    @Scheduled(cron ="0 35 1 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertHousing() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "200000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/Housing", parameters, head);
        log.info("#######" + "住房");
        if (null != result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                Housing bean =new Housing();
                bean.setId((Integer) map.get("id"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setHouseholdNo((String) map.get("householdNo"));
                bean.setLiveProperty((String) map.get("liveProperty"));
                bean.setBuildingProperty((String) map.get("buildingProperty"));
                bean.setBuildingUsage((String) map.get("buildingUsage"));
                bean.setUpLayerNum((String) map.get("upLayerNum"));
                bean.setDownLayerNum((String) map.get("downLayerNum"));
                bean.setNumPerLayer((String) map.get("numPerLayer"));
                bean.setHourseStatus((String) map.get("hourseStatus"));
                bean.setHourseUsage((String) map.get("hourseUsage"));
                bean.setHourseCode((String) map.get("hourseCode"));
                bean.setAddress((String) map.get("address"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setDeleted((Boolean) map.get("deleted"));
                bean.setEtlTime(new Date());
                farmingAgricultureDao.insertHousing(bean);
            }
        }
    }

    //闲置院落
    //每天1点15分执行一次
    //@Scheduled(cron ="0 * * * * ?")
    @Scheduled(cron ="0 15 1 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertIdlecouryard() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "20000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/IdleCourtyard", parameters, head);
        log.info("#######" + "闲置院落");
        if (null != result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                Idlecourtyard bean=new Idlecourtyard();
                bean.setId((Integer) map.get("id"));
                bean.setSN((String) map.get("sn"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setPos((String) map.get("pos"));
                bean.setLandType((String) map.get("landType"));
                bean.setArea((String) map.get("area"));
                bean.setAppendant((String) map.get("appendant"));
                bean.setUsageStatus((String) map.get("usageStatus"));
                bean.setContractor((String) map.get("contractor"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setContractorPhone((String) map.get("contractorPhone"));
                bean.setPrincipal((String) map.get("principal"));
                bean.setPrincipalPhone((String) map.get("principalPhone"));
                bean.setImages((String) map.get("imageUrl"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setTown((String) map.get("town"));
                bean.setLocation((String) map.get("location"));
                bean.setPurpose((String) map.get("purpose"));
                bean.setMateriel((String) map.get("materiel"));
                bean.setLessor((String) map.get("lessor"));
                bean.setGridMember((String) map.get("gridMember"));
                bean.setPhone((String) map.get("phone"));
                farmingAgricultureDao.insertIdlecouryard(bean);
            }
        }
    }

    //旱厕改造
    //每天1点15分执行一次
    //@Scheduled(cron ="0 * * * * ?")
    @Scheduled(cron ="0 55 1 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertLatrineReform() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "200000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/LatrineReform", parameters, head);
        if (null != result) {
            log.info("#######" + "旱厕改造");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                LatrineReform bean=new LatrineReform();
                bean.setId((Integer) map.get("id"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setHouseholdNo((String) map.get("householdNo"));
                bean.setName((String) map.get("name"));
                bean.setRelation((String) map.get("relation"));
                bean.setCommittee((String) map.get("committee"));
                bean.setAddress((String) map.get("address"));
                bean.setDryToilet((String) map.get("dryToilet"));
                bean.setDryToiletType((String) map.get("dryToiletType"));
                bean.setDryToiletUsageType((String) map.get("dryToiletUsageType"));
                bean.setHourseCode((String) map.get("hourseCode"));
                bean.setGas2Coal((String) map.get("gas2Coal"));
                bean.setEle2Coal((String) map.get("ele2Coal"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setTown((String) map.get("town"));
                bean.setToiletType((String) map.get("toiletType"));
                bean.setToiletDryDate((String) map.get("toiletDryDate"));
                bean.setIsMaintain((String) map.get("isMaintain"));
                bean.setHeatType((String) map.get("heatType"));
                bean.setHeatDryDate((String) map.get("heatDryDate"));
                bean.setImage((String) map.get("image"));
                bean.setHeatImage((String) map.get("heatImage"));
                farmingAgricultureDao.insertLatrineReform(bean);
            }
        }
    }

    //九小场所
    //每天1点45分执行一次
    //@Scheduled(cron ="0 * * * * ?")
    @Scheduled(cron ="0 45 1 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertNineSmallPlaces() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/NineSmallPlaces", parameters, head);
        if (null != result) {
            log.info("#######" + "九小场所");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                NineSmallPlaces bean =new NineSmallPlaces();
                bean.setId((Integer) map.get("id"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setCompanyName((String) map.get("companyName"));
                bean.setCompanyType((String) map.get("companyType"));
                bean.setPersonInCharge((String) map.get("personInCharge"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setPhone((String) map.get("phone"));
                bean.setSmX((String) map.get("smX"));
                bean.setSmY((String) map.get("smY"));
                bean.setPos((String) map.get("pos"));
                bean.setComment((String) map.get("comment"));
                bean.setImageNo((String) map.get("imageNo"));
                bean.setTown((String) map.get("town"));
                farmingAgricultureDao.insertNineSmallPlaces(bean);
            }
        }
    }

    //窑湾数据
    //每天1点40分执行一次
    @Scheduled(cron ="0 40 1 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertPoolBay() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "5000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/PoolBay", parameters, head);
        if (null != result) {
            log.info("#######" + "窑湾数据");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                PoolBay bean =new PoolBay();
                bean.setId((Integer) map.get("id"));
                bean.setSN((String) map.get("sn"));
                bean.setTown((String) map.get("town"));
                bean.setName((String) map.get("name"));
                bean.setPos((String) map.get("pos"));
                bean.setSituation((String) map.get("situation"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setComment((String) map.get("comment"));
                bean.setImages((String) map.get("images"));
                bean.setPerson((String) map.get("person"));
                bean.setPurpose((String) map.get("purpose"));
                farmingAgricultureDao.insertPoolBay(bean);
            }
        }
    }

    //垃圾清运
    //每天1点40分执行一次
    @Scheduled(cron ="0 25 1 * * ?")
    //@Scheduled(cron ="0 * * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertRubbishClear() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "5000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/RubbishClear", parameters, head);
        if (null != result) {
            log.info("#######" + "垃圾清运");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                RubbishClear bean =new RubbishClear();
                bean.setId((Integer) map.get("id"));
                bean.setSN((String) map.get("sn"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setName((String) map.get("name"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setPos((String) map.get("pos"));
                bean.setSituation((String) map.get("situation"));
                bean.setTexture((String) map.get("texture"));
                bean.setImageNo((String) map.get("imageNo"));
                bean.setImageUrl((String) map.get("imageUrl"));
                farmingAgricultureDao.insertRubbishClear(bean);
            }
        }
    }

    //水井
    //每天2点55分执行一次
    @Scheduled(cron ="0 55 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertWaterWell() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/WaterWell", parameters, head);
        if (null != result) {
            log.info("#######" + "水井");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                WaterWell bean=new WaterWell();
                bean.setID((Integer) map.get("id"));
                bean.setSmX((String) map.get("smX"));
                bean.setSmY((String) map.get("smY"));
                bean.setSmLibTileID((String) map.get("smLibTileID"));
                bean.setSmUserID((String) map.get("smUserID"));
                bean.setSmGeometrySize((String) map.get("smGeometrySize"));
                bean.setSmGeoPosition((String) map.get("smGeoPosition"));
                bean.setDotNo((String) map.get("dotNo"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setWellCode((String) map.get("wellCode"));
                bean.setName((String) map.get("name"));
                bean.setPos((String) map.get("pos"));
                bean.setDepth((String) map.get("depth"));
                bean.setWaterLevel((String) map.get("waterLevel"));
                bean.setImageNo((String) map.get("imageNo"));
                bean.setTown((String) map.get("town"));
                bean.setPhone((String) map.get("phone"));
                bean.setComment((String) map.get("comment"));
                farmingAgricultureDao.insertWaterWell(bean);
            }
        }
    }

    //信教人员
    //每天2点50分执行一次
    @Scheduled(cron ="0 50 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertXinJiaoRenYuan() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "1000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/XinJiaoRenYuan", parameters, head);
        if (null != result) {
            log.info("#######" + "信教人员");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                XinJiaoRenYuan bean =new XinJiaoRenYuan();
                bean.setId((Integer) map.get("id"));
                bean.setName((String) map.get("name"));
                bean.setGender((String) map.get("gender"));
                bean.setPhone((String) map.get("phone"));
                bean.setMinZu((String) map.get("minZu"));
                bean.setWenHuaChengDu((String) map.get("wenHuaChengDu"));
                bean.setZhengZhiMianMao((String) map.get("zhengZhiMianMao"));
                bean.setGongZuoDanWeiZhiWu((String) map.get("gongZuoDanWeiZhiWu"));
                bean.setXinYangZongJiao((String) map.get("xinYangZongJiao"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setHuJiDi((String) map.get("huJiDi"));
                bean.setXianJuZhuDi((String) map.get("xianJuZhuDi"));
                bean.setJuHuiDiDian((String) map.get("juHuiDiDian"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                farmingAgricultureDao.insertXinJiaoRenYuan(bean);
            }
        }
    }

    //种粮大户
    //每天2点50分执行一次
    @Scheduled(cron ="0 20 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertZhongLiangDaHu() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "500");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/ZhongLiangDaHu", parameters, head);
        if (null != result) {
            log.info("#######" + "种粮大户");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                ZhongLiangDaHu bean=new ZhongLiangDaHu();
                bean.setId((Integer) map.get("id"));
                bean.setAuditState((Integer) map.get("auditState"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setName((String) map.get("name"));
                bean.setArea((String) map.get("area"));
                bean.setVarieties((String) map.get("varieties"));
                bean.setPhone((String) map.get("phone"));
                farmingAgricultureDao.insertZhongLiangDaHu(bean);
            }
        }
    }
}