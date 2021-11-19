package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.TestDao;
import cn.stephen.study.htapitoproject.entity.TestEntity;
import cn.stephen.study.htapitoproject.utils.HttpUtil;
import cn.stephen.study.htapitoproject.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Acthor Tao.Lee @date 2021/11/18 11:18
 * @Description http请求测试类
 */
@Service
@Slf4j
public class HttpTestService {

    @Resource
    private TestDao testDao ;

   /* public static void main(String[] args) throws Exception {
        Map<String,String> parameters=new HashMap<String,String>();
        parameters.put("page", "1");
        parameters.put("pagesize", "100");
        String result = HttpUtil.sendGet("http://localhost:8082/legalperson/api/test", parameters,null);
        log.info(result);
        Object itemObj = JsonUtils.getObject(result, "$.data");
        List<Map> list = JSONArray.parseArray(itemObj.toString(), Map.class);
        for (Map map : list) {
            TestEntity testEntity=new TestEntity();
            testEntity.setFirstName((String) map.get("code"));
            testEntity.setLastName((String) map.get("name"));
            //testDao.insert(testEntity);
            log.info(testEntity.getFirstName()+testEntity.getLastName());
        }
    }*/
   public static void main(String[] args) {
       String s="Id\n" +
               "SmId\n" +
               "Name\n" +
               "Type\n" +
               "RegCapital\n" +
               "EstablishedTime\n" +
               "Status\n" +
               "Pos\n" +
               "X\n" +
               "Y\n" +
               "RawMaterial\n" +
               "Product\n" +
               "SalesRevenue\n" +
               "TechProcess\n" +
               "Phone\n" +
               "Email\n" +
               "BuzLicense\n" +
               "EIA\n" +
               "EIAcheck\n" +
               "FireControlFile\n" +
               "Certificate\n" +
               "TwoSysBuild\n" +
               "HazardRp\n" +
               "EmergencyPlan\n" +
               "Area\n" +
               "LandCardNo\n" +
               "LandType\n" +
               "LegalPerson\n" +
               "LegalPhone\n" +
               "Principal\n" +
               "SecPrincipal\n" +
               "SecOfficer\n" +
               "GridMember\n" +
               "ProdEquipment\n" +
               "EnvEquipment\n" +
               "SolidWaste\n" +
               "HazardousWaste\n" +
               "WastewaterOut\n" +
               "RaiseDust\n" +
               "ProdDust\n" +
               "ExhaustGasOut\n" +
               "StaffTotal\n" +
               "StaffGraduateAbove\n" +
               "StaffUndergraduate\n" +
               "StaffJuniorCollege\n" +
               "StaffOther\n" +
               "HasPartyOrg\n" +
               "PartyMemberTotal\n" +
               "VillageCode\n" +
               "Town\n" +
               "VillageName\n" +
               "IndustryType\n" +
               "IndustryCode\n" +
               "CurrentStatus\n" +
               "JiGaiShiJianNeiRong\n" +
               "LiXiangNeiRongWenHaoShiJian\n" +
               "EtlTime\n";
       for (String slist : s.split("\n")) {
         //  System.out.println("bean.set"+slist+"((String) map.get("+"\"\""+"));");
           System.out.println("         "+"#{"+slist+"},");
       }
   }

}
