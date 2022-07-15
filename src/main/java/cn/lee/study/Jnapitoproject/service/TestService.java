package cn.lee.study.Jnapitoproject.service;

import cn.lee.study.Jnapitoproject.dao.TestDao;
import cn.lee.study.Jnapitoproject.entity.TestEntity;
import cn.lee.study.Jnapitoproject.utils.HttpsUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;


public class TestService {

    public static void main(String[] args) {


        String url2 = "https://api.caiyunapi.com/v2.5/8rxNzEcnNjku3EMi/163.953688,30.728308/minutely";
        String result2 = HttpsUtil.httpsGet(url2, null, null);

        BigDecimal str = (BigDecimal)JSONObject.parseObject(result2).getJSONObject("result").getJSONObject("minutely").getJSONArray("precipitation_2h").get(0);
//        for (int i=0;i<jsonArray.size();i++) {
//            System.out.println((Integer) jsonArray.get(0));
//        }
        System.out.println(str);
    }
}

