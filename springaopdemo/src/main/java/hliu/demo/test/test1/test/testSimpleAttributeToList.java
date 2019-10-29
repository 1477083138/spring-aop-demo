package hliu.demo.test.test1.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import hliu.demo.test.test1.bean.Person;
import hliu.demo.test.test1.util.BeanUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:liuhao
 * */
public class testSimpleAttributeToList {
    public static void main(String args[]){
        Person person = new Person();
        person.setId("1111");
        person.setAge(24);
        person.setName("liuhao");
        //person.setSex("male");
        List<Map<String,Object>> mapList = BeanUtil.simpleAttributeToList(person);
        //System.out.println(mapList);

        Map<String,Object> map = new HashMap<>();
        map.put("id",person.getId());
        map.put("age",person.getAge());
        map.put("name",person.getName());
        map.put("sex",person.getSex());
        map.put("oldName",person.getOldName());
        //System.out.println(map);
        List<Map<String,Object>> mapList1 = BeanUtil.simpleAttributeToList(map);
        //System.out.println(mapList1);

        String s = JSON.toJSONString(person);

        System.out.println(s);


        Person person1 = JSON.parseObject(s,Person.class);
        System.out.println(person1.toString());

        String s1 = JSON.toJSONString(person1);
        System.out.println(s1);

        Map map1 = JSON.parseObject(s1,Map.class);

        System.out.println(map1);
    }
}
