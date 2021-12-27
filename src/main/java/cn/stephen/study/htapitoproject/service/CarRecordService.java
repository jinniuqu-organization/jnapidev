package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.CarRecordDao;
import cn.stephen.study.htapitoproject.entity.CarRecord;
import cn.stephen.study.htapitoproject.utils.HttpUtil;
import cn.stephen.study.htapitoproject.utils.HttpsUtil;
import cn.stephen.study.htapitoproject.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Acthor Tao.Lee
 * @date 2021/12/18 11:43
 * @Description说明：
 */
@Service
@Slf4j
public class CarRecordService {

    @Value("${accessToken}")
    public String accessToken;

    @Resource
    private CarRecordDao CarRecordDao;

    //十分钟跑一次前一个小时的数据
    @Scheduled(cron = "0 */12 * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void inserCarRecord() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String queryTimeEndStr=sdf.format(new Date());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.HOUR_OF_DAY,-1);//前一个小时的
        String queryTimeBeginStr= sdf.format(calendar.getTime());
        parameters.put("queryTimeBegin",queryTimeBeginStr.replace(" ","%20"));
        parameters.put("queryTimeEnd",queryTimeEndStr.replace(" ","%20"));
        parameters.put("pageNum", "1");
        parameters.put("pageSize", "1000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("accessToken", accessToken);
        //String result = HttpsUtil.httpsGet("http://223.99.14.39:80/ipms/carcapture/find/conditions", parameters, head);
        String result = HttpsUtil.httpsGet("http://10.136.245.212:80/ipms/carcapture/find/conditions", parameters, head);
        HashMap itemObj1 = (HashMap) JsonUtils.getObject(result, "$.data");
        //log.info(itemObj1.toString());
        //List<Student> studentList1 = JSON.parseArray(JSON.parseObject(json).getString("studentList"), Student.class);
        log.info("----");
        if (null != itemObj1) {
            log.info("#######" + "车辆出入记录");
            List<Map> list = JSONArray.parseArray(itemObj1.get("pageData").toString(),Map.class);
            //log.info(list.toString());
            for (Map map : list) {
                CarRecord bean=new CarRecord();
                bean.setId((Long) map.get("id"));
                bean.setCapTimeStr((String) map.get("capTimeStr"));
                bean.setCarBrand((Integer) map.get("carBrand"));
                bean.setCarColor((Integer) map.get("carColor"));
                bean.setCarDirect((String) map.get("carDirect"));
                bean.setCarDirectStr((String) map.get("carDirectStr"));
                bean.setCarImgUrl((String) map.get("carImgUrl"));
                bean.setCarInnerCategory((Integer) map.get("carInnerCategory"));
                bean.setCarNum((String) map.get("carNum"));
                bean.setCarNumPic((String) map.get("carNumPic"));
                bean.setCarNumcolor((Integer) map.get("carNumcolor"));
                bean.setCarType((Integer) map.get("carType"));
                bean.setCarWayCode((String) map.get("carWayCode"));
                bean.setDevChnId((String) map.get("devChnId"));
                bean.setDevChnName((String) map.get("devChnName"));
                bean.setDevChnNum((Integer) map.get("devChnNum"));
                bean.setDevId((String) map.get("devId"));
                bean.setDevName((String) map.get("devName"));
                bean.setDraw((Integer) map.get("draw"));
                bean.setOriginalPicPath((String) map.get("originalPicPath"));
                bean.setParkingLot((String) map.get("parkingLot"));
                bean.setParkingLotCode((String) map.get("parkingLotCode"));
                bean.setRealCapturePicPath((String) map.get("realCapturePicPath"));
                bean.setStrobeState((Integer) map.get("strobeState"));
                CarRecordDao.insertCarRecord(bean);
            }
        }
    }



}
