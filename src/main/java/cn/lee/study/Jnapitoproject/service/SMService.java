package cn.lee.study.Jnapitoproject.service;

import cn.hutool.crypto.SecureUtil;
import cn.lee.study.Jnapitoproject.dao.*;
import cn.lee.study.Jnapitoproject.entity.*;
import cn.lee.study.Jnapitoproject.utils.HttpUtil;
import cn.lee.study.Jnapitoproject.utils.JsonUtils;
import cn.lee.study.Jnapitoproject.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    @Value("${AK}")
    public String AK;

    @Value("${SK}")
    public String SK;

    @Autowired
    SmLzbgaBjslZsDao smLzbgaBjslZsDao;

    @Autowired
    SmWllzDrhsjclDao smWllzDrhsjclDao;

    @Autowired
    SmLzbwjJjglsZsDao smLzbwjJjglsZsDao;

    @Autowired
    SmWllzXgfymqjcsDao smWllzXgfymqjcsDao;

    @Autowired
    SmWllzFxryzsDao smWllzFxryzsDao;

    @Autowired
    SmWllzWljwhcgxxrhDao smWllzWljwhcgxxrhDao;
    @Autowired
    SmLzbzhYqgwtjbtblZsDao smLzbzhYqgwtjbtblZsDao;


    /**
     * 市网络理政办-市公安局-110接警数量-详情(正式-智慧蓉城专用)接口
     */
    //    @Scheduled(cron="0 */5 * * * ?")
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
            smLzbgaBjslZs.setOrgName(StringUtils.trim(tmpJson.getString("ORG_NAME")));
            smLzbgaBjslZs.setDreamdbNum(StringUtils.trim(tmpJson.getString("dreamdb.num")));
            smLzbgaBjslZs.setBusinessTime(StringUtils.trim(tmpJson.getString("business_time")));
            smLzbgaBjslZs.setDreamdbOrgCode(StringUtils.trim(tmpJson.getString("dreamdb.ORG_CODE")));
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
            smLzbwjJjglsZs.setNum(StringUtils.trim(tmpJson.getString("num")));
            smLzbwjJjglsZs.setDreamdbStreetCode(StringUtils.trim(tmpJson.getString("dreamdb.street_code")));
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
            smWllzXgfymqjcs.setDreamdbLjrs(StringUtils.trim(tmpJson.getString("dreamdb.ljrs")));
            smWllzXgfymqjcs.setTjrq(StringUtils.trim(tmpJson.getString("tjrq")));
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
            log.info(tmpJson.toJSONString());
            smWllzWljwhcgxxrh.setDetailedAddress(StringUtils.trim(tmpJson.getString("DetailedAddress")));
            smWllzWljwhcgxxrh.setEndTime(StringUtils.trim(tmpJson.getString("EndTime")));
            smWllzWljwhcgxxrh.setPosition(StringUtils.trim(tmpJson.getString("Position")));
            smWllzWljwhcgxxrh.setStartTime(StringUtils.trim(tmpJson.getString("StartTime")));
            smWllzWljwhcgxxrh.setLabel(StringUtils.trim(tmpJson.getString("Label")));
            smWllzWljwhcgxxrh.setCrowd(StringUtils.trim(tmpJson.getString("Crowd")));
            smWllzWljwhcgxxrh.setGrade(StringUtils.trim(tmpJson.getString("Grade")));
            smWllzWljwhcgxxrh.setMobilePhone(StringUtils.trim(tmpJson.getString("MobilePhone")));
            smWllzWljwhcgxxrh.setName(StringUtils.trim(tmpJson.getString("Name")));
            smWllzWljwhcgxxrh.setNumber(StringUtils.trim(tmpJson.getString("Number")));
            smWllzWljwhcgxxrh.setAddressAreaCode(StringUtils.trim(tmpJson.getString("Address_AreaCode")));
            smWllzWljwhcgxxrh.setDetailedIntroduction(StringUtils.trim(tmpJson.getString("DetailedIntroduction")));
            smWllzWljwhcgxxrh.setObjectId(StringUtils.trim(tmpJson.getString("objectId")));

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
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("current", "1");
        params.put("size", "1000");
        headers.put("appkey", appkey);
        headers.put("app-id", appId);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("data").getJSONArray("data");
        List<SmLzbzhYqgwtjbtblZs> updateList = new ArrayList<>(0);
        List<SmLzbzhYqgwtjbtblZs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs = new SmLzbzhYqgwtjbtblZs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smLzbzhYqgwtjbtblZs.setCount(StringUtils.trim(tmpJson.getString("count(*)")));
            smLzbzhYqgwtjbtblZs.setUpdateTime(new Date());
            SmLzbgaBjslZs queryRes = smLzbzhYqgwtjbtblZsDao.query(smLzbzhYqgwtjbtblZs);
            if (queryRes == null){
                insertList.add(smLzbzhYqgwtjbtblZs);
            }else {
                smLzbzhYqgwtjbtblZs.setId(queryRes.getId());
                updateList.add(smLzbzhYqgwtjbtblZs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smLzbzhYqgwtjbtblZsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smLzbzhYqgwtjbtblZsDao.updateBatch(updateList);
        }
    }

    /**
     * 市网络理政办-当日核酸检测采样量-详情
     */
    @Transactional(rollbackFor = Exception.class)
    public void wllzDrhsjcl() throws Exception{
        String url = smPrefix + "/gateway/api/1/wllz/drhsjcl";
        log.info(url);
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        String json = "{\"moduleId\": \"4f7a3695167d47a9a920b1883e3dbf4e\"}";
        params.put("jsonData", json);
        headers.put("appkey", appkey);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("RESULT").getJSONArray("data");
        List<SmWllzDrhsjcl> updateList = new ArrayList<>(0);
        List<SmWllzDrhsjcl> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmWllzDrhsjcl smWllzDrhsjcl = new SmWllzDrhsjcl();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smWllzDrhsjcl.setHsrs(StringUtils.trim(tmpJson.getString("HSRS")));
            smWllzDrhsjcl.setUpdateTime(new Date());
            SmLzbgaBjslZs queryRes = smWllzDrhsjclDao.query(smWllzDrhsjcl);
            if (queryRes == null){
                insertList.add(smWllzDrhsjcl);
            }else {
                smWllzDrhsjcl.setId(queryRes.getId());
                updateList.add(smWllzDrhsjcl);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smWllzDrhsjclDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smWllzDrhsjclDao.updateBatch(updateList);
        }
    }

    /**
     * 市网络理政办-风险人员总数-详情
     */
    @Transactional(rollbackFor = Exception.class)
    public void wllzFxryzs() throws Exception{
        String url = smPrefix + "/gateway/api/1/wllz/fxryzs";
        log.info(url);
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("pageIndex", "1");
        params.put("pageSize", "1000");
        headers.put("appkey", appkey);
        headers.put("app-id", appId);
        /*调用第三方接口*/
        String res = HttpUtil.sendPostForm(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("data").getJSONArray("data");
        List<SmWllzFxryzs> updateList = new ArrayList<>(0);
        List<SmWllzFxryzs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmWllzFxryzs smWllzFxryzs = new SmWllzFxryzs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smWllzFxryzs.setCount(tmpJson.getLong("风险人员总数"));
            smWllzFxryzs.setUpdateTime(new Date());
            SmLzbgaBjslZs queryRes = smWllzFxryzsDao.query(smWllzFxryzs);
            if (queryRes == null){
                insertList.add(smWllzFxryzs);
            }else {
                smWllzFxryzs.setId(queryRes.getId());
                updateList.add(smWllzFxryzs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smWllzFxryzsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smWllzFxryzsDao.updateBatch(updateList);
        }
    }

    /**
     * 市网络理政办-百度集团交通系统-道路路况监控及研判场景-获取指定拥堵预警的拥堵详情-详情(测试)
     */
    @Transactional(rollbackFor = Exception.class)
    public void bdjtHqzdyjydxq() throws Exception{
        String url = smPrefix + "/gateway/api/2/bdjt/hqzdyjydxq";
        log.info(url);
        HashMap<String, String> params = new HashMap<>();
        HashMap<String, String> headers = new HashMap<>();
        params.put("nodeId", "7692");
        params.put("eventId", "131-首都机场辅路-201905280708-15260461540");
        headers.put("appkey", appkey);
        headers.put("account", AK);
        headers.put("secretKey", SK);
        long millis = System.currentTimeMillis();
        headers.put("requestTime", millis + "");
        headers.put("signature", getSignature(millis));
        /*调用第三方接口*/
        String res = HttpUtil.sendGet(url, params, headers);
        JSONArray jsonArray = JSONObject.parseObject(res).getJSONObject("result").getJSONArray("data");
        List<SmLzbzhYqgwtjbtblZs> updateList = new ArrayList<>(0);
        List<SmLzbzhYqgwtjbtblZs> insertList = new ArrayList<>(0);
        /*解析*/
        for (int i = 0; i < jsonArray.size(); i++) {
            SmLzbzhYqgwtjbtblZs smLzbzhYqgwtjbtblZs = new SmLzbzhYqgwtjbtblZs();
            JSONObject tmpJson = jsonArray.getJSONObject(i);
            smLzbzhYqgwtjbtblZs.setCount(StringUtils.trim(tmpJson.getString("count(*)")));
            smLzbzhYqgwtjbtblZs.setUpdateTime(new Date());
            SmLzbgaBjslZs queryRes = smLzbzhYqgwtjbtblZsDao.query(smLzbzhYqgwtjbtblZs);
            if (queryRes == null){
                insertList.add(smLzbzhYqgwtjbtblZs);
            }else {
                smLzbzhYqgwtjbtblZs.setId(queryRes.getId());
                updateList.add(smLzbzhYqgwtjbtblZs);
            }
        }
        /*批量插入或更新*/
        if (insertList.size() > 0) {
            smLzbzhYqgwtjbtblZsDao.insertBatch(insertList);
        }
        if (updateList.size() > 0) {
            smLzbzhYqgwtjbtblZsDao.updateBatch(updateList);
        }
    }


    public String getSignature(Long requestTime) {
        return SecureUtil.sha256(AK + SK + requestTime);
    }

}
