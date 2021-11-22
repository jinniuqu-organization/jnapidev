package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.BeadHousePersonDao;
import cn.stephen.study.htapitoproject.entity.BeadHousePerson;
import cn.stephen.study.htapitoproject.entity.CommunityPopul;
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
 * @Acthor Tao.Lee @date 2021/11/18 13:58
 * @Description 养老院人员
 */
@Service
@Slf4j
public class BeadHousePersonService {

    @Resource
    private BeadHousePersonDao beadHousePersonDao;

    @Value("${token}")
    public String token;

    //养老院人口
    //每天2点35执行一次
    @Scheduled(cron ="0 35 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertBeadHousePerson() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/BeadHousePerson", parameters,head);
        log.info("#######"+result);
        if(null !=result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                BeadHousePerson bean = new BeadHousePerson();
                bean.setId((Integer) map.get("id"));
                bean.setAuditState((Integer) map.get("auditState"));
                bean.setBuildupArea((String) map.get("buildUpArea"));
                bean.setName((String) map.get("name"));
                bean.setGender((String) map.get("gender"));
                bean.setCreatedOn((String) map.get("createdOn"));
                bean.setIdcardNo((String) map.get("idCardNo"));
                bean.setPhone((String) map.get("phone"));
                bean.setSelfCare((String) map.get("selfCare"));
                bean.setHousehold((String) map.get("household"));
                bean.setIsPoor((String) map.get("isPoor"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setDeleted((Boolean) map.get("deleted"));
                bean.setEtlTime(new Date());
                beadHousePersonDao.insert(bean);
                //log.info("#####" + bean.getName());
            }
        }

    }

    //社区人口
    @Scheduled(cron ="0 30 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertCommunityPopul() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "160000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/CommunityPopul", parameters,head);
        log.info("######"+result);
        if(null !=result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                CommunityPopul bean=new CommunityPopul();
                bean.setId((Integer) map.get("id"));
                bean.setCommunityName((String) map.get("communityName"));
                bean.setNeighbourhoodName((String) map.get("neighbourhoodName"));
                bean.setBuildingNo((String) map.get("buildingNo"));
                bean.setUnitNo((String) map.get("unitNo"));
                bean.setStoreyNo((String) map.get("storeyNo"));
                bean.setHouseholdNo((String) map.get("householdNo"));
                bean.setName((String) map.get("name"));
                bean.setRelation((String) map.get("relation"));
                bean.setGender((String) map.get("gender"));
                bean.setBirthday((String) map.get("birthday"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setMarriage((String) map.get("marriage"));
                bean.setNation((String) map.get("nation"));
                bean.setRegistrationStatus((String) map.get("registrationStatus"));
                bean.setPhone((String) map.get("phone"));
                bean.setAddress((String) map.get("address"));
                bean.setWorkPlace((String) map.get("workPlace"));
                bean.setPoliticalOrientation((String) map.get("politicalOrientation"));
                bean.setRetiree((String) map.get("retiree"));
                bean.setNote((String) map.get("note"));
                bean.setRoomNo((String) map.get("roomNo"));
                bean.setTown((String) map.get("town"));
                bean.setAuditState((Integer) map.get("auditState"));
                bean.setCreatedOn((String) map.get("createdOn"));
                bean.setDeleted((Boolean) map.get("deleted"));
                bean.setEtlTime(new Date());
                beadHousePersonDao.insertpopul(bean);
                //log.info("####"+bean.getName());
            }
        }
    }

}
