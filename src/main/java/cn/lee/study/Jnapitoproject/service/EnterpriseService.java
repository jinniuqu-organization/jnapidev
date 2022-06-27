package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.entity.Enterprise;
import cn.lee.study.Jnapitoproject.dao.EnterpriseDao;
import cn.lee.study.Jnapitoproject.utils.HttpUtil;
import cn.lee.study.Jnapitoproject.utils.JsonUtils;
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
 * @Acthor Tao.Lee @date 2021/11/19 14:45
 * @Description 企业数据
 */
@Service
@Slf4j
public class EnterpriseService {

    @Value("${token}")
    public String token;

    @Resource
    private EnterpriseDao enterpriseDao;

    //企业数据
    @Scheduled(cron = "0 15 2 * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertEnterprise() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/Enterprise", parameters, head);
        log.info("#######" + "企业数据");
        if (null != result) {
            Object itemObj = JsonUtils.getObject(result, "$.data");
            List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
            for (Map map : list) {
                Enterprise bean=new Enterprise();
                bean.setId((Integer) map.get("id"));
                bean.setSmId((String) map.get("smId"));
                bean.setName((String) map.get("name"));
                bean.setType((String) map.get("type"));
                bean.setRegCapital((String) map.get("regCapital"));
                bean.setEstablishedTime((String) map.get("establishedTime"));
                bean.setStatus((String) map.get("status"));
                bean.setPos((String) map.get("pos"));
                bean.setX((String) map.get("x"));
                bean.setY((String) map.get("y"));
                bean.setRawMaterial((String) map.get("rawMaterial"));
                bean.setProduct((String) map.get("product"));
                bean.setSalesRevenue((String) map.get("salesRevenue"));
                bean.setTechProcess((String) map.get("techProcess"));
                bean.setPhone((String) map.get("phone"));
                bean.setEmail((String) map.get("email"));
                bean.setBuzLicense((String) map.get("buzLicense"));
                bean.setEIA((String) map.get("eia"));
                bean.setEIAcheck((String) map.get("eiAcheck"));
                bean.setFireControlFile((String) map.get("fireControlFile"));
                bean.setCertificate((String) map.get("certificate"));
                bean.setTwoSysBuild((String) map.get("twoSysBuild"));
                bean.setHazardRp((String) map.get("hazardRp"));
                bean.setEmergencyPlan((String) map.get("emergencyPlan"));
                bean.setArea((String) map.get("area"));
                bean.setLandCardNo((String) map.get("landCardNo"));
                bean.setLandType((String) map.get("landType"));
                bean.setLegalPerson((String) map.get("legalPerson"));
                bean.setLegalPhone((String) map.get("legalPhone"));
                bean.setPrincipal((String) map.get("principal"));
                bean.setSecPrincipal((String) map.get("secPrincipal"));
                bean.setSecOfficer((String) map.get("secOfficer"));
                bean.setGridMember((String) map.get("gridMember"));
                bean.setProdEquipment((String) map.get("prodEquipment"));
                bean.setEnvEquipment((String) map.get("envEquipment"));
                bean.setSolidWaste((String) map.get("solidWaste"));
                bean.setHazardousWaste((String) map.get("hazardousWaste"));
                bean.setWastewaterOut((String) map.get("wastewaterOut"));
                bean.setRaiseDust((String) map.get("raiseDust"));
                bean.setProdDust((String) map.get("prodDust"));
                bean.setExhaustGasOut((String) map.get("exhaustGasOut"));
                bean.setStaffTotal((String) map.get("staffTotal"));
                bean.setStaffGraduateAbove((String) map.get("staffGraduateAbove"));
                bean.setStaffUndergraduate((String) map.get("staffUndergraduate"));
                bean.setStaffJuniorCollege((String) map.get("staffJuniorCollege"));
                bean.setStaffOther((String) map.get("staffOther"));
                bean.setHasPartyOrg((String) map.get("hasPartyOrg"));
                bean.setPartyMemberTotal((String) map.get("partyMemberTotal"));
                bean.setVillageCode((String) map.get("villageCode"));
                bean.setTown((String) map.get("town"));
                bean.setVillageName((String) map.get("villageName"));
                bean.setIndustryType((String) map.get("industryType"));
                bean.setIndustryCode((String) map.get("industryCode"));
                bean.setCurrentStatus((String) map.get("currentStatus"));
                bean.setJiGaiShiJianNeiRong((String) map.get("jiGaiShiJianNeiRong"));
                bean.setLiXiangNeiRongWenHaoShiJian((String) map.get("liXiangNeiRongWenHaoShiJian"));
                bean.setEtlTime(new Date());
                enterpriseDao.insertEnterprise(bean);
                //log.info(bean.getName());
            }
        }
    }
}
