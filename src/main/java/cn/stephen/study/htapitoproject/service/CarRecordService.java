package cn.stephen.study.htapitoproject.service;

import cn.stephen.study.htapitoproject.dao.CarRecordDao;
import cn.stephen.study.htapitoproject.entity.CarRecord;
import cn.stephen.study.htapitoproject.utils.HttpUtil;
import cn.stephen.study.htapitoproject.utils.HttpsUtil;
import cn.stephen.study.htapitoproject.utils.JsonUtils;
import com.alibaba.fastjson.JSONArray;
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
    @Scheduled(cron = "0 * * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void inserCarRecord() throws Exception {
        Map<String, String> parameters = new HashMap<String, String>();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String queryTimeEndStr=sdf.format(new Date());
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.add(calendar.HOUR_OF_DAY,-12);//前一个小时的
        String queryTimeBeginStr= sdf.format(calendar.getTime());
        parameters.put("queryTimeBegin",queryTimeBeginStr.replace(" ","%20"));
        parameters.put("queryTimeEnd",queryTimeEndStr.replace(" ","%20"));
        parameters.put("pageNum", "1");
        parameters.put("pageSize", "10000");
        Map<String, String> head = new HashMap<String, String>();
        head.put("accessToken", accessToken);
        String result = HttpsUtil.httpsGet("http://223.99.14.39:80/ipms/carcapture/find/conditions", parameters, head);
        //Object itemObj = JsonUtils.getObject(result, "$..pageData");
        //log.info(itemObj.toString());
        HashMap itemObj = (HashMap) JsonUtils.getObject(result, "$.data");
        log.info(itemObj.toString());
        if (null != itemObj) {
            log.info("#######" + "车辆出入记录");
            List<Map> list = JSONArray.parseArray(itemObj.get("pageData").toString(), Map.class);
            for (Map map : list) {
                CarRecord bean=new CarRecord();
                bean.setId((String) map.get("id"));
                bean.setCapTimeStr((Date) map.get("capTimeStr"));
                bean.setCarBrand((Integer) map.get("carBrand"));
                bean.setCarColor((Integer) map.get("carColor"));
                bean.setCarDirect((String) map.get("carDirect"));
                bean.setCarDirectStr((String) map.get("carDirectStr"));
                bean.setCarImgUrl((String) map.get("carImgUrl"));
                bean.setCarInnerCategory((Integer) map.get("carInnerCategory"));
                bean.setCarNum((String) map.get("carNum"));
                bean.setCarNumPic((String) map.get("carNumPic"));
                bean.setCarNumcolor((String) map.get("carNumcolor"));
                bean.setCarType((String) map.get("carType"));
                bean.setCarWayCode((String) map.get("carWayCode"));
                bean.setDevChnId((String) map.get("devChnId"));
                bean.setDevChnName((String) map.get("devChnName"));
                bean.setDevChnNum((Integer) map.get("devChnNum"));
                bean.setDevId((String) map.get("devId"));
                bean.setDevName((String) map.get("devName"));
                bean.setDraw((String) map.get("draw"));
                bean.setOriginalPicPath((String) map.get("originalPicPath"));
                bean.setParkingLot((String) map.get("parkingLot"));
                bean.setParkingLotCode((String) map.get("parkingLotCode"));
                bean.setRealCapturePicPath((String) map.get("realCapturePicPath"));
                bean.setStrobeState((Integer) map.get("strobeState"));
                log.info("1");
                CarRecordDao.inserCarRecord(bean);
            }
        }
    }



}
