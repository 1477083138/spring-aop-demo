package hliu.demo.test.test1.test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import hliu.demo.test.test1.bean.Person;
import hliu.demo.test.test1.util.BeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @describe 测试Json类型与实体类之间的转换
 * @author liuhao
 * */
public class testPerson {

    public static void main(String args[]){

        JSONObject personJson = JSONUtil.createObj();
        List<String> oldName = null;

        personJson.put("id","111111");
        personJson.put("name","liuhao");
        personJson.put("age",1);
        personJson.put("sex",null);
        personJson.put("oldName",oldName);


        Map map = personJson.toBean(Map.class);

        Person person =(Person) BeanUtil.jsonToBean(map,new Person());

        System.out.println(person.toString());

        person.setAge(12);
        System.out.println(person.toString());

        Person person1 = personJson.toBean(Person.class);

        System.out.println(person1);
    }
}
