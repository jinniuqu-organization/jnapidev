package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.TestDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

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
       String s="id\n" +
               "capTimeStr\n" +
               "carBrand\n" +
               "carColor\n" +
               "carDirect\n" +
               "carDirectStr\n" +
               "carImgUrl\n" +
               "carInnerCategory\n" +
               "carNum\n" +
               "carNumPic\n" +
               "carNumcolor\n" +
               "carType\n" +
               "carWayCode\n" +
               "devChnId\n" +
               "devChnName\n" +
               "devChnNum\n" +
               "devId\n" +
               "devName\n" +
               "draw\n" +
               "originalPicPath\n" +
               "parkingLot\n" +
               "parkingLotCode\n" +
               "realCapturePicPath\n" +
               "strobeState\n";
       for (String slist : s.split("\n")) {
          //System.out.println("private String "+slist+";");
          //System.out.println("bean.set"+slist+"((String) map.get("+"\"\""+"));");
           // System.out.println("         "+"#{"+slist+"},");
       }
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       //Date queryTimeBegin=new Date();
       String queryTimeBeginStr=sdf.format(new Date());
       System.out.println(queryTimeBeginStr);
       Calendar calendar = new GregorianCalendar();
       calendar.setTime(new Date());
       calendar.add(calendar.HOUR_OF_DAY,-1);
       String date2= sdf.format(calendar.getTime());
       System.out.println(date2.replaceAll(" ","%20"));
   }

}
