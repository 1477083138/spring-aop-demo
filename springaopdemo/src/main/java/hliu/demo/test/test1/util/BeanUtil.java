package hliu.demo.test.test1.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.lang.reflect.Field;
import java.util.*;

/**
 * @description 实体类转换工具
 * @author liuhao
 * */
public class BeanUtil {

    public static Object jsonToBean(Map map, Object t){
        Class clazz = t.getClass();
        Field [] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            try{
                if(map.keySet().contains(field.getName())){
                    field.set(t,map.get(field.getName()));
                }
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }
        }
        return t;
    }

    /**
     * 构造cmdb资源配置存储simpleAttribute信息
     *
     * @return simpleAttribute信息
     */
    public static List<Map<String,Object>> simpleAttributeToList(Object obj){

        List<Map<String,Object>> list = new ArrayList<>();
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            try {
                if(null != field.get(obj)) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", field.getName());
                    map.put("value", field.get(obj));
                    list.add(map);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 构造cmdb资源配置存储simpleAttribute信息
     *
     * @return simpleAttribute信息
     */
    public static List<Map<String,Object>> simpleAttributeToList(Map<String,Object> simpleAttribute){

        List<Map<String,Object>> list = new ArrayList<>();
        Set<Map.Entry<String,Object>> entrySet = simpleAttribute.entrySet();
        for(Map.Entry<String,Object> m:entrySet){
            if( null !=m.getValue()) {
                Map<String, Object> map = new HashMap<>();
                map.put("name", m.getKey());
                map.put("value", m.getValue());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * cmdb响应体是否为空
     *
     * @param object  cmdb返回响应体
     * @return
     * */
    public static boolean isNullResponse(Object object){

        return null == object ? false : null == JSONUtil.parseObj(object).get("list")
                    ? false : JSONUtil.parseArray(JSONUtil.parseObj(object).get("list")).isEmpty();
        //return ((JSONArray)jsonObject.get("list")).isEmpty() || "null".equals(jsonObject.get("list").toString());
    }

}
