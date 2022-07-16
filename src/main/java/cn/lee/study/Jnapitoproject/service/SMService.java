package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.SmLzbgaBjslZsDao;
import cn.lee.study.Jnapitoproject.dao.SmLzbwjJjglsZsDao;
import cn.lee.study.Jnapitoproject.dao.SmWllzWljwhcgxxrhDao;
import cn.lee.study.Jnapitoproject.dao.SmWllzXgfymqjcsDao;
import cn.lee.study.Jnapitoproject.entity.SmLzbgaBjslZs;
import cn.lee.study.Jnapitoproject.entity.SmLzbwjJjglsZs;
import cn.lee.study.Jnapitoproject.entity.SmWllzWljwhcgxxrh;
import cn.lee.study.Jnapitoproject.entity.SmWllzXgfymqjcs;
import cn.lee.study.Jnapitoproject.utils.HttpUtil;
import cn.lee.study.Jnapitoproject.utils.JsonUtils;
import cn.lee.study.Jnapitoproject.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: jnapidev
 * @description: 数梦
 * @author: 作者名字
 * @create: 2022-07-15 15:08
 **/
@Service
@Slf4j
public class SMService {

    @Value("${qxtoken}")
    public String token;

    @Value("${smPrefix}")
    public String smPrefix;

    @Value("${appkey}")
    public String appkey;

    @Value("${appid}")
    public String appId;

    @Autowired
    SmLzbgaBjslZsDao smLzbgaBjslZsDao;

    @Autowired
    SmLzbwjJjglsZsDao smLzbwjJjglsZsDao;

    @Autowired
    SmWllzXgfymqjcsDao smWllzXgfymqjcsDao;

    @Autowired
    SmWllzWljwhcgxxrhDao smWllzWljwhcgxxrhDao;

    //气象实时数据//未来两小时降雨量
    //@Scheduled(cron = "0 15 2 * * ?")
//    @Scheduled(cron="0 */5 * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertNlqxxx(){
//        List<Nldwcode> list= nldwcodeDao.selectList();
//        for (Nldwcode nldwcode : list) {
//            String jdx = nldwcode.getJdx();
//            String wdy = nldwcode.getWdy();
//            String dwmc = nldwcode.getDwmc();
////            String jdx = "104.041037";
////            String wdy = "30.720807";
//            String url = smPrefix + "v2.5/" + token + "/" + jdx + "," + wdy + "/" + "realtime";
//            log.info(url);
//            String result = HttpsUtil.httpsGet(url, null, null);
//            log.info("############" + "气象实时数据");
//            if (null != result) {
//                Nlqxxx bean = new Nlqxxx();
//                bean.setDwmc(dwmc);
//                bean.setJdx(jdx);
//                bean.setWdy(wdy);
//                bean.setDqtq(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").get("skycon")));
//                bean.setDqwd(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").get("temperature")));
//                bean.setDqjylqd(String.valueOf(JSONObject.parseObject(result).getJSONObject("result").getJSONObject("realtime").getJSONObject("precipitation").getJSONObject("local").get("intensity")));
//                bean.setDqsj(timeStamp2Date(String.valueOf( JSONObject.parseObject(result).get("server_time"))));
//                nlqxxxDao.insert(bean);
//            }
//            String url2 = "https://api.caiyunapi.com/v2.5/" + token + "/" + jdx + "," + wdy + "/" + "minutely";
//            log.info(url2);
//            String result2 = HttpsUtil.httpsGet(url2, null, null);
//            log.info("############" + "未来两小时降雨数据");
//            if(null!=result2){
//                Nlwllxs bean=new Nlwllxs();
//                bean.setDw(dwmc);
//                bean.setJdx(jdx);
//                bean.setWdy(wdy);
//                bean.setWllxsgl((BigDecimal)JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").getJSONArray("probability").get(0));
//                bean.setWllxsqd((BigDecimal)JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").getJSONArray("precipitation_2h").get(0));
//                bean.setYjxx(String.valueOf(JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").get("description")));
//                bean.setDqsj(timeStamp2Date(String.valueOf( JSONObject.parseObject(result).get("server_time"))));
//                nlwllxsDao.insert(bean);
//            }
//        }
    }

    /**
     * 市网络理政办-市公安局-110接警数量-详情(正式-智慧蓉城专用)接口
     */
    @Transactional(rollbackFor = Exception.class)
    public void lzbgaBjslZs() throws Exception {
        String url = smPrefix + "/gateway/api/1/lzbga/bjsl/zs";
        log.info(url);
        String json = "{moduleId:f4da7c1e85054090a328b148d989ecd0}";
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("jsonData", json);
        headers.put("appkey", appkey);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("RESULT").getJSONArray("data");
        List<SmLzbgaBjslZs> updateList = new ArrayList<>(0);
        List<SmLzbgaBjslZs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmLzbgaBjslZs smLzbgaBjslZs = new SmLzbgaBjslZs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smLzbgaBjslZs.setOrgName(tmpJson.getString("ORG_NAME"));
            smLzbgaBjslZs.setDreamdbNum(tmpJson.getString("dreamdb.num"));
            smLzbgaBjslZs.setBusinessTime(tmpJson.getString("business_time"));
            smLzbgaBjslZs.setDreamdbOrgCode(tmpJson.getString("dreamdb.ORG_CODE"));
            SmLzbgaBjslZs queryRes = smLzbgaBjslZsDao.query(smLzbgaBjslZs);
            if (queryRes == null){
                insertList.add(smLzbgaBjslZs);
            }else {
                smLzbgaBjslZs.setId(queryRes.getId());
                updateList.add(smLzbgaBjslZs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smLzbgaBjslZsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smLzbgaBjslZsDao.updateBatch(updateList);
        }
    }


    /**
     * 市网络理政办-市卫健委-居家隔离数-详情(正式)
     */
    @Transactional(rollbackFor = Exception.class)
    public void lzbwjJjglsZs() throws Exception{
        String url = smPrefix + "/gateway/api/1/lzbwj/jjgls/zs";
        log.info(url);
        String json = "{\"pageSize\": \"1000\",\"pageNum\": \"1\",\"moduleId\": \"1d7816adc900493db3ddbfce44b77e3b\"}";
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("jsonData", json);
        headers.put("appkey", appkey);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("RESULT").getJSONArray("data");
        List<SmLzbwjJjglsZs> updateList = new ArrayList<>(0);
        List<SmLzbwjJjglsZs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmLzbwjJjglsZs smLzbwjJjglsZs = new SmLzbwjJjglsZs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smLzbwjJjglsZs.setNum(tmpJson.getString("num"));
            smLzbwjJjglsZs.setDreamdbStreetCode(tmpJson.getString("dreamdb.street_code"));
            SmLzbgaBjslZs queryRes = smLzbwjJjglsZsDao.query(smLzbwjJjglsZs);
            if (queryRes == null){
                insertList.add(smLzbwjJjglsZs);
            }else {
                smLzbwjJjglsZs.setId(queryRes.getId());
                updateList.add(smLzbwjJjglsZs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smLzbwjJjglsZsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smLzbwjJjglsZsDao.updateBatch(updateList);
        }
    }


    /**
     * 市网络理政办-新冠肺炎累计排查密切接触者数-详情
     */
    @Transactional(rollbackFor = Exception.class)
    public void wllzXgfymqjcs() throws Exception{
        String url = smPrefix + "/gateway/api/1/wllz/xgfymqjcs";
        log.info(url);
        String json = "{\"moduleId\": \"cc5c0f68634044fcbf42301989e58c58\"}";
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("jsonData", json);
        headers.put("appkey", appkey);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("RESULT").getJSONArray("data");
        List<SmWllzXgfymqjcs> updateList = new ArrayList<>(0);
        List<SmWllzXgfymqjcs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmWllzXgfymqjcs smWllzXgfymqjcs = new SmWllzXgfymqjcs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smWllzXgfymqjcs.setDreamdbLjrs(tmpJson.getString("dreamdb.ljrs"));
            smWllzXgfymqjcs.setTjrq(tmpJson.getString("tjrq"));
            SmLzbgaBjslZs queryRes = smWllzXgfymqjcsDao.query(smWllzXgfymqjcs);
            if (queryRes == null){
                insertList.add(smWllzXgfymqjcs);
            }else {
                smWllzXgfymqjcs.setId(queryRes.getId());
                updateList.add(smWllzXgfymqjcs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smWllzXgfymqjcsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smWllzXgfymqjcsDao.updateBatch(updateList);
        }
    }

    /**
     * 市网络理政办-文旅局-文化场馆信息-详情(融合服务)
     */
    @Transactional(rollbackFor = Exception.class)
    public void wllzWljwhcgxxrh() throws Exception{
        String url = smPrefix + "/gateway/mixservice/1/wllz/wljwhcgxxrh";
        log.info(url);
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("appkey", appkey);
        /*调用第三方接口*/
        String res = HttpUtil.sendGet(url, params, headers).split("=")[2];
        res = res.substring(0, res.length() -9);
        JSONArray jsonArray = JSONObject.parseArray(res);
        List<SmWllzWljwhcgxxrh> updateList = new ArrayList<>(0);
        List<SmWllzWljwhcgxxrh> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmWllzWljwhcgxxrh smWllzWljwhcgxxrh = new SmWllzWljwhcgxxrh();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smWllzWljwhcgxxrh.setDetailedAddress(tmpJson.getString("DetailedAddress"));
            smWllzWljwhcgxxrh.setEndTime(tmpJson.getString("EndTime"));
            smWllzWljwhcgxxrh.setPosition(tmpJson.getString("Position"));
            smWllzWljwhcgxxrh.setStartTime(tmpJson.getString("StartTime"));
            smWllzWljwhcgxxrh.setLabel(tmpJson.getString("Label"));
            smWllzWljwhcgxxrh.setCrowd(tmpJson.getString("Crowd"));
            smWllzWljwhcgxxrh.setGrade(tmpJson.getString("Grade"));
            smWllzWljwhcgxxrh.setMobilePhone(tmpJson.getString("MobilePhone"));
            smWllzWljwhcgxxrh.setName(tmpJson.getString("Name"));
            smWllzWljwhcgxxrh.setNumber(tmpJson.getString("Number"));
            smWllzWljwhcgxxrh.setAddressAreaCode(tmpJson.getString("Address_AreaCode"));
            smWllzWljwhcgxxrh.setDetailedIntroduction(tmpJson.getString("DetailedIntroduction"));
            smWllzWljwhcgxxrh.setObjectId(tmpJson.getString("objectId"));

            SmLzbgaBjslZs queryRes = smWllzWljwhcgxxrhDao.query(smWllzWljwhcgxxrh);
            if (queryRes == null){
                insertList.add(smWllzWljwhcgxxrh);
            }else {
                smWllzWljwhcgxxrh.setId(queryRes.getId());
                updateList.add(smWllzWljwhcgxxrh);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smWllzWljwhcgxxrhDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smWllzWljwhcgxxrhDao.updateBatch(updateList);
        }
    }

    /**
     * 市网络理政办-智慧蓉城疫情防控专班-按公卫数据统计所有本土在院病例-详情(正式)-接入基础技术文档
     */
    @Transactional(rollbackFor = Exception.class)
    public void lzbzhYqgwtjbtblZs() throws Exception{
        String url = smPrefix + "/gateway/api/1/lzbzh/yqgwtjbtbl/zs";
        log.info(url);
        String json = "{\"moduleId\": \"cc5c0f68634044fcbf42301989e58c58\"}";
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("current", "1");
        params.put("size", "1000");
        headers.put("appkey", appkey);
        headers.put("app-id", appId);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("RESULT").getJSONArray("data");
        List<SmWllzXgfymqjcs> updateList = new ArrayList<>(0);
        List<SmWllzXgfymqjcs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmWllzXgfymqjcs smWllzXgfymqjcs = new SmWllzXgfymqjcs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smWllzXgfymqjcs.setDreamdbLjrs(tmpJson.getString("dreamdb.ljrs"));
            smWllzXgfymqjcs.setTjrq(tmpJson.getString("tjrq"));
            SmLzbgaBjslZs queryRes = smWllzXgfymqjcsDao.query(smWllzXgfymqjcs);
            if (queryRes == null){
                insertList.add(smWllzXgfymqjcs);
            }else {
                smWllzXgfymqjcs.setId(queryRes.getId());
                updateList.add(smWllzXgfymqjcs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smWllzXgfymqjcsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smWllzXgfymqjcsDao.updateBatch(updateList);
        }
    }


}
