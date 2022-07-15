package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.NldwcodeDao;
import cn.lee.study.Jnapitoproject.dao.NlqxxxDao;
import cn.lee.study.Jnapitoproject.dao.NlwllxsDao;
import cn.lee.study.Jnapitoproject.entity.Nldwcode;
import cn.lee.study.Jnapitoproject.entity.Nlqxxx;
import cn.lee.study.Jnapitoproject.entity.Nlwllxs;
import cn.lee.study.Jnapitoproject.utils.HttpsUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * @Author LeeTao
 * @Date 2022/7/11 16:28
 * @Dxplanation 内涝气象实时信息
 */
@Service
@Slf4j
public class NlqxxxService {
    @Value("${qxtoken}")
    public String token;

    @Resource
    private NlqxxxDao nlqxxxDao;

    @Resource
    private NldwcodeDao nldwcodeDao;

    @Resource
    private NlwllxsDao nlwllxsDao;

    //气象实时数据//未来两小时降雨量
    //@Scheduled(cron = "0 15 2 * * ?")
    @Scheduled(cron="0 */5 * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertNlqxxx(){
        List<Nldwcode> list= nldwcodeDao.selectList();
        for (Nldwcode nldwcode : list) {
            String jdx = nldwcode.getJdx();
            String wdy = nldwcode.getWdy();
            String dwmc = nldwcode.getDwmc();
//            String jdx = "104.041037";
//            String wdy = "30.720807";
            String url = "https://api.caiyunapi.com/v2.5/" + token + "/" + jdx + "," + wdy + "/" + "realtime";
            log.info(url);
            String result = HttpsUtil.httpsGet(url, null, null);
            log.info("############" + "气象实时数据");
            if (null != result) {
                Nlqxxx bean = new Nlqxxx();
                bean.setDwmc(dwmc);
                bean.setJdx(jdx);
                bean.setWdy(wdy);
                bean.setDqtq(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").get("skycon")));
                bean.setDqwd(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").get("temperature")));
                bean.setDqjylqd(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").getJSONObject("precipitation").getJSONObject("local").get("intensity")));
                bean.setDqsj(timeStamp2Date(String.valueOf( JSONObject.parseObject(result).get("server_time"))));
                nlqxxxDao.insert(bean);
            }
            String url2 = "https://api.caiyunapi.com/v2.5/" + token + "/" + jdx + "," + wdy + "/" + "minutely";
            log.info(url2);
            String result2 = HttpsUtil.httpsGet(url2, null, null);
            log.info("############" + "未来两小时降雨数据");
            if(null!=result2){
                Nlwllxs bean=new Nlwllxs();
                bean.setDw(dwmc);
                bean.setJdx(jdx);
                bean.setWdy(wdy);
                bean.setWllxsgl((BigDecimal)JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").getJSONArray("probability").get(0));
                bean.setWllxsqd((BigDecimal)JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").getJSONArray("precipitation_2h").get(0));
                bean.setYjxx(String.valueOf(JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").get("description")));
                bean.setDqsj(timeStamp2Date(String.valueOf( JSONObject.parseObject(result).get("server_time"))));
                nlwllxsDao.insert(bean);
            }
        }
    }



    public static String timeStamp2Date(String time) {
        Long timeLong = Long.parseLong(time)*1000L;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//要转换的时间格式
        Date date;
        try {
            date = sdf.parse(sdf.format(timeLong));
            return sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}



