package cn.lee.study.Jnapitoproject.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.spi.json.JsonProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Acthor Tao.Lee @date 2021/11/18 13:05
 * @Description JsonUtils工具类
 */
public class JsonUtils {
    /**
     * 定义jackson对象
     */
    public static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 忽略JSON中没有的字段，防止反序列化对象的时候报找不到属性字段的异常
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 如果json字符串中含有新行时，加上这个
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        // 空值转换异常
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
    }

    /**
     * 将对象转换成json字符串。
     * <p>
     * Title: pojoToJson
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param data
     * @return
     */
    public static String objectToJson(Object data) {
        try {
            return MAPPER.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String objectToJsonWithType(Object data, TypeReference typeReference){
        try {
            return MAPPER.writerFor(typeReference).writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @return
     */
    public static <T> T jsonToPojo(String jsonData, Class<T> beanType) {
        try {
            return MAPPER.readValue(jsonData, beanType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将json数据转换成pojo对象list
     * <p>
     * Title: jsonToList
     * </p>
     * <p>
     * Description:
     * </p>
     *
     * @param jsonData
     * @param beanType
     * @return
     */
    public static <T> List<T> jsonToList(String jsonData, Class<T> beanType) {
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return MAPPER.readValue(jsonData, javaType);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>json字符串转Map</p>
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> parseMap(String jsonStr) throws IOException {
        return MAPPER.readValue(jsonStr, Map.class);
    }

    public static List<String> parseList(String jsonStr) throws IOException {
        return MAPPER.readValue(jsonStr, new TypeReference<List<String>>() {});
    }

    /**
     * 根据数据源类型和字段类型返回自定义字段类型
     * @param dsType
     * @param fieldType
     * @return
     */
    public static String getFieldType(String dsType, String fieldType){
        List<String> mysqlNumber = new ArrayList<String>();
        mysqlNumber.add("TINYINT");
        mysqlNumber.add("SMALLINT");
        mysqlNumber.add("MEDIUMINT");
        mysqlNumber.add("INTEGER");
        mysqlNumber.add("INT");
        mysqlNumber.add("BIGINT");
        mysqlNumber.add("FLOAT");
        mysqlNumber.add("DOUBLE");
        mysqlNumber.add("DECIMAL");
        List<String> mysqlString = new ArrayList<String>();
        mysqlString.add("CHAR");
        mysqlString.add("VARCHAR");
        mysqlString.add("TINYBLOB");
        mysqlString.add("TINYTEXT");
        mysqlString.add("BLOB");
        mysqlString.add("TEXT");
        mysqlString.add("MEDIUMBLOB");
        mysqlString.add("MEDIUMTEXT");
        mysqlString.add("LONGBLOB");
        mysqlString.add("LONGTEXT");
        List<String> mysqlDatetime = new ArrayList<String>();
        mysqlString.add("DATE");
        mysqlString.add("TIME");
        mysqlString.add("YEAR");
        mysqlString.add("DATETIME");
        mysqlString.add("TIMESTAMP");
        List<String> mysqlBoolean = new ArrayList<String>();
        mysqlBoolean.add("TINYINT");
        List<String> hiveNumber = new ArrayList<String>();
        hiveNumber.add("TINYINT");
        hiveNumber.add("SMALLINT");
        hiveNumber.add("INT");
        hiveNumber.add("BIGINT");
        hiveNumber.add("FLOAT");
        hiveNumber.add("DOUBLE");
        hiveNumber.add("DECIMAL");
        List<String> hiveString = new ArrayList<String>();
        hiveString.add("CHAR");
        hiveString.add("VARCHAR");
        hiveString.add("STRING");
        List<String> hiveDatetime = new ArrayList<String>();
        hiveString.add("DATE");
        hiveString.add("INTERVAL");
        hiveString.add("TIMESTAMP");
        List<String> hiveBoolean = new ArrayList<String>();
        hiveBoolean.add("BOOLEAN");
        String type = fieldType.toUpperCase();
        String targetType = "";
        if("1".equals(dsType)){
            if(hiveNumber.contains(type)){
                targetType = "number";
            }
            if(hiveString.contains(type)){
                targetType = "string";
            }
            if(hiveDatetime.contains(type)){
                targetType = "datetime";
            }
            if(hiveBoolean.contains(type)){
                targetType = "boolean";
            }
        }else if("2".equals(dsType)){
            if(mysqlNumber.contains(type)){
                targetType = "number";
            }
            if(mysqlString.contains(type)){
                targetType = "string";
            }
            if(mysqlDatetime.contains(type)){
                targetType = "datetime";
            }
            if(mysqlBoolean.contains(type)){
                targetType = "boolean";
            }
        }
        return targetType;
    }

    //JsonPath解析，路径不存在忽略异常，返回空
    public static Object getObject(String result, String path){
        Configuration configuration = Configuration.defaultConfiguration();
        configuration = configuration.addOptions(//
                Option.DEFAULT_PATH_LEAF_TO_NULL, //如果路径不存在则返回null,而不要抛出PathNotFoundException
                Option.SUPPRESS_EXCEPTIONS        //抑制异常的抛出，当设置了Option.ALWAYS_RETURN_LIST时返回[],否则返回null
        );
        // 如果项目中存在gson则此处可以new 一个GsonJsonProvider，那么返回对象
        // configuration.jsonProvider(new GsonJsonProvider());
        JsonProvider jsonProvider = configuration.jsonProvider();
        /**
         * 此处预先解析json,默认请情下JsonPath.read方法每掉一次都会重新解析json，此处预先解析好就不用每次都进行解析
         */
        Object document = jsonProvider.parse(result);
        Object obj = JsonPath.using(configuration).parse(document).read(path);
        return obj;
    }

}
