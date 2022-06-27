package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.CaseDao;
import cn.lee.study.Jnapitoproject.entity.Case;
import cn.lee.study.Jnapitoproject.utils.AESUtil;
import cn.lee.study.Jnapitoproject.utils.HttpsUtil;
import cn.lee.study.Jnapitoproject.utils.MD5Util;
import cn.lee.study.Jnapitoproject.utils.RSAUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

/**
 * @Acthor yzz
 * @date 2021/12/20 13:43
 * @Description说明：
 */
@Service
@Slf4j
public class CaseService {

    @Autowired
    private CaseDao caseDao;

    @Value("${caseToken}")
    public String caseToken;

    @Value("${ip}")
    public String ip;

    private static final String PUBLICKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzdSPBP/ZFVRX3NLED4jZ\n" +
            "Dy2oXuNDK0vIi7w/jAy16kQGbHdCr5wyivG9JXAhd3x+ObQjpD96L2zAuHDabehD\n" +
            "oQezu3HBbMXxD8CDB8x8pJb7W5NzZg71E4M6zqhxXLKeLjQ04qA0ea7IVNgAv2iu\n" +
            "8hhEyYdfWPecDVgbyTzx0zeK2FEklLyNUo4LsayI6rpfCSnwoW6wXwVGH52rCElr\n" +
            "qZh2nXupzAAkDG56tcdswd4gGoTN1cFoLK4ngJDz43xIgujckZpiwND6DeB0rLFi\n" +
            "1VcaqI3oFAfHcfVkWKp3lOM7ImYL7iW/LK7kksWQSKcVqCPVE302500AneGqTM9S\n" +
            "lQIDAQAB";
    private static final String APINAME = "/api/anjiancx/getAnjian?timestamp=";

    private static final String ENCODEING = "UTF-8";

    private static final String AESKEY = "1234567887654321";

    //每一个小时执行一次
    @Scheduled(cron = "0 0 * * * ?")
    @Transactional(value = "masterTransactionManager", propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void insertCaseData() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, String> parameters = new HashMap<String, String>();
        Map<String, String> request = new HashMap<String, String>();
        String timestamp = URLEncoder.encode(String.valueOf(System.currentTimeMillis() / 1000), ENCODEING);

        String urlSign = MD5Util.md5Encrypt32Lower(APINAME + timestamp);

        parameters.put("token", caseToken);
        parameters.put("date", sdf.format(new Date()));

        String bodySign = MD5Util.md5Encrypt32Lower(JSON.toJSONString(parameters));

        String sign = RSAUtils.encryptByPublicKey(urlSign + bodySign, PUBLICKEY);
        String data = AESUtil.aes256ECBPkcs7PaddingEncrypt(JSON.toJSONString(parameters), AESKEY);
        String key = RSAUtils.encryptByPublicKey(AESKEY, PUBLICKEY);

        request.put("data", data);
        request.put("key", key);
        String url = ip + APINAME + timestamp + "&sign=" + sign;
        log.info("开始执行查询案件接口信息，URL=" + url);
        log.info("开始执行查询案件接口信息，DATA=" + JSON.toJSONString(request));
        String result = HttpsUtil.doPostJson(url, JSON.toJSONString(request));
        JSONObject response = JSON.parseObject(result);
        if (response.getInteger("code") == 200) {
            if (response.get("data") != null) {
                log.info("开始执行解析数据并插入数据库");
                JSONArray jsonArray = response.getJSONArray("data");
                jsonArray.stream().forEach(jo -> insertCase((JSONObject) jo));
            }
        }
    }

    /**
     * 把返回数据插入数据库
     *
     * @param jo
     */
    private void insertCase(JSONObject jo) {
        Case bean = new Case();
        bean.setId(jo.getLong("id"));
        bean.setSn(jo.getLong("sn"));
        bean.setSsz(jo.getString("ssz"));
        bean.setSsc(jo.getString("ssc"));
        bean.setLng(jo.getString("lng"));
        bean.setLat(jo.getString("lat"));
        bean.setWtly(jo.getString("wtly"));

        bean.setAjlx(jo.getString("ajlx"));
        bean.setWtlx(jo.getLong("wtlx"));
        bean.setDlmc(jo.getLong("dlmc"));
        bean.setXlmc(jo.getLong("xlmc"));
        bean.setWtdj(jo.getString("wtdj"));

        bean.setCldj(jo.getString("cldj"));

        bean.setSssq(jo.getString("sssq"));
        bean.setDzms(jo.getString("dzms"));

        bean.setSjbm(jo.getString("sjbm"));
        bean.setWtms(jo.getString("wtms"));

        bean.setPyyj(jo.getString("pyyj"));
        bean.setDsr(jo.getString("dsr"));
        bean.setState(jo.getLong("state"));
        bean.setLxdh(jo.getString("lxdh"));
        bean.setFssj(jo.getString("fssj"));

        bean.setPyr(jo.getString("pyr"));

        bean.setContent(jo.getString("content"));

        bean.setBeizhu(jo.getString("beizhu"));
        bean.setCreate_by(jo.getString("create_by"));
        bean.setCreate_time(jo.getLong("create_time"));
        bean.setUpdate_by(jo.getString("update_by"));
        bean.setUpdate_time(jo.getLong("update_time"));
        bean.setDel(jo.getInteger("del"));

        bean.setSswg(jo.getString("sswg"));
        bean.setSlsj(jo.getString("slsj"));
        bean.setAj_type(jo.getInteger("aj_type"));

        bean.setWgy(jo.getString("wgy"));
        bean.setJzsj(jo.getLong("jzsj"));
        bean.setDqsx(jo.getInteger("dqsx"));
        bean.setIs_duban(jo.getInteger("is_duban"));
        bean.setIs_cuiban(jo.getInteger("is_cuiban"));

        bean.setCbyj(jo.getString("cbyj"));
        bean.setIs_dbread(jo.getInteger("is_dbread"));

        bean.setDbyj(jo.getString("dbyj"));
        bean.setZhenname(jo.getString("zhenname"));
        bean.setCunname(jo.getString("cunname"));
        bean.setWtlx_str(jo.getString("wtlx_str"));
        bean.setDlmc_str(jo.getString("dlmc_str"));
        bean.setXlmc_str(jo.getString("xlmc_str"));
        bean.setName(jo.getString("name"));
        bean.setPhone(jo.getString("phone"));
        JSONArray jsonArrayImg = jo.getJSONArray("img");
        StringJoiner sjImg = new StringJoiner(",");
        jsonArrayImg.stream().forEach(j -> setImg((JSONObject) j, sjImg));
        bean.setImg(sjImg.toString());
        JSONArray jsonArrayImg2 = jo.getJSONArray("img2");
        StringJoiner sjImg2 = new StringJoiner(",");
        jsonArrayImg2.stream().forEach(j -> setImg((JSONObject) j, sjImg2));
        bean.setImg2(sjImg2.toString());
        caseDao.insertCase(bean);
        log.info("案例数据插入数据库成功");
    }

    private void setImg(JSONObject jo, StringJoiner sj) {
        sj.add(ip + jo.getString("filepath"));
    }
}
