package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.BeadHousePersonDao;
import cn.stephen.study.htapitoproject.entity.*;
import cn.stephen.study.htapitoproject.utils.HttpUtil;
import cn.stephen.study.htapitoproject.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.apache.xmlbeans.impl.xb.xsdschema.All;
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
        log.info("########"+"养老院人口");
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
        log.info("#######"+"社区人口");
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

    //key人口
    @Scheduled(cron ="0 10 1 * * ?")
    //@Scheduled(cron ="0 * * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertKeyPopul() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "160000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/KeyPopul", parameters,head);
        log.info("#######"+"key人口");
        if(null !=result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                KeyPopul bean =new KeyPopul();
                bean.setId((Integer) map.get("id"));
                bean.setName((String) map.get("name"));
                bean.setTownName((String) map.get("townName"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setAddress((String) map.get("address"));
                bean.setGender((String) map.get("gender"));
                bean.setPhone((String) map.get("phone"));
                bean.setType((String) map.get("type"));
                bean.setExtData((String) map.get("extData"));
                bean.setRemark((String) map.get("remark"));
                beadHousePersonDao.insertKeypopul(bean);
            }
        }
    }

    //总人口
    @Scheduled(cron ="0 0 1 * * ?")
    //@Scheduled(cron ="0 * * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertAllPopul() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "500000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/Popul", parameters,head);
        log.info("#######"+"总人口");
        if(null !=result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                AllPopul bean =new AllPopul();
                bean.setId((Integer) map.get("id"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setHouseholdNo((String) map.get("householdNo"));
                bean.setName((String) map.get("name"));
                bean.setRelation((String) map.get("relation"));
                bean.setCommittee((String) map.get("committee"));
                bean.setAddress((String) map.get("address"));
                bean.setFertileWoman((String) map.get("fertileWoman"));
                bean.setCommunityCorrection((String) map.get("communityCorrection"));
                bean.setPartyMember((String) map.get("partyMember"));
                bean.setMaritalStatus((String) map.get("maritalStatus"));
                bean.setPhone((String) map.get("phone"));
                bean.setNation((String) map.get("nation"));
                bean.setTown((String) map.get("town"));
                beadHousePersonDao.insertAllpopul(bean);
            }
        }
    }

    @Scheduled(cron ="0 20 1 * * ?")
    //扶贫数据
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertPoverty() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/Poverty", parameters,head);
        if(null !=result) {
            log.info("#######"+"扶贫数据");
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                Poverty bean=new Poverty();
                bean.setId((Integer) map.get("id"));
                bean.setType((String) map.get("type"));
                bean.setCity((String) map.get("city"));
                bean.setTown((String) map.get("town"));
                bean.setAdminVillage((String) map.get("adminVillage"));
                bean.setNaturalVillage((String) map.get("naturalVillage"));
                bean.setHouseholdNo((String) map.get("householdNo"));
                bean.setPersonCode((String) map.get("personCode"));
                bean.setName((String) map.get("name"));
                bean.setIdCardNo((String) map.get("idCardNo"));
                bean.setNumOfPeople((String) map.get("numOfPeople"));
                bean.setRelation((String) map.get("relation"));
                bean.setNation((String) map.get("nation"));
                bean.setEducationalLevel((String) map.get("educationalLevel"));
                bean.setStudentStatus((String) map.get("studentStatus"));
                bean.setHealthCondition((String) map.get("healthCondition"));
                bean.setSkills((String) map.get("skills"));
                bean.setWorkingCondition((String) map.get("workingCondition"));
                bean.setWorkingTime((String) map.get("workingTime"));
                bean.setHasDBYL((String) map.get("hasDBYL"));
                bean.setOffPoverty((String) map.get("offPoverty"));
                bean.setOffPovertyYear((String) map.get("offPovertyYear"));
                bean.setPovertyLevel((String) map.get("povertyLevel"));
                bean.setPovertyCauses((String) map.get("povertyCauses"));
                bean.setDangerousBuilding((String) map.get("dangerousBuilding"));
                bean.setHasSafeWater((String) map.get("hasSafeWater"));
                bean.setPerIncome((String) map.get("perIncome"));
                bean.setPhone((String) map.get("phone"));
                bean.setRemark((String) map.get("remark"));
                bean.setZiLiNengLi((String) map.get("ziLiNengLi"));
                bean.setJianHuRen((String) map.get("jianHuRen"));
                bean.setJianHuRenPhone((String) map.get("jianHuRenPhone"));
                beadHousePersonDao.insertPoverty(bean);
            }
        }
    }


}
