package hliu.demo.test.test1.util;

import cn.hutool.json.JSONObject;

import java.lang.reflect.Field;
import java.util.Map;

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
}
