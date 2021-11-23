package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.FarmingAgricultureDao;
import cn.stephen.study.htapitoproject.entity.Farm;
import cn.stephen.study.htapitoproject.entity.Housing;
import cn.stephen.study.htapitoproject.entity.Idlecourtyard;
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
 * @Acthor Tao.Lee @date 2021/11/22 11:30
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

}