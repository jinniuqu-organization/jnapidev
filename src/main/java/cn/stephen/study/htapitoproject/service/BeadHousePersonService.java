package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.BeadHousePersonDao;
import cn.stephen.study.htapitoproject.entity.BeadHousePerson;
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

    @Scheduled(cron ="0 * * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertBeadHousePerson() throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "10000");
        Map<String,String> head=new HashMap<String,String>();
        head.put("Authorization", token);
        String result = HttpUtil.sendGet("http://10.136.130.194:10013/api/BeadHousePerson", parameters,head);
        log.info("#######"+result);
        Object itemObj = JsonUtils.getObject(result, "$.data");
        List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
        for (Map map : list) {
            BeadHousePerson bean=new BeadHousePerson();
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
            log.info("#####"+bean.getName());
        }

    }

}
