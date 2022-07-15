//package cn.lee.study.Jnapitoproject.utils;
//
//import com.alibaba.fastjson.JSONException;
//import com.alibaba.fastjson.JSONObject;
//
///**
// * @Author LeeTao
// * @Date 2022/7/11 17:22
// * @Dxplanation
// */
//public class JsonUtilString {
//
//    public static String getString(String data, String result){
//
//        JSONObject jsonObject = null;
//        try {
//            jsonObject = new JSONObject(data);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return jsonObject.optString(result, null);
//    }
//
//}