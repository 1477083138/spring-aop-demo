package hliu.demo.test.test1.test;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import hliu.demo.test.test1.bean.Person;
import hliu.demo.test.test1.util.BeanUtil;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:liuhao
 * */
public class testSimpleAttributeToList {
    public static void main(String args[]){
        Person person = new Person();
        person.setId("1111");
        person.setAge(24);
        person.setName("liuhao");
        person.setSex("male");
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




        System.out.println(JSONUtil.toJsonStr(complexAttributeToList("2123123","343434")));

        JSONObject jsonObject = JSONUtil.parseObj(person);
        Person person2 = jsonObject.toBean(Person.class);
        System.out.println(person2);

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map2 = new HashMap<>();
        map2.put("uuid","1111111");
        Map<String,Object> map3 = new HashMap<>();
        map3.put("uuid","2222222");
        list.add(map2);
        list.add(map3);
        String [] test =  list.stream().map(p->p.get("uuid").toString()).toArray(String[]::new);

        System.out.println(JSONUtil.toJsonStr(test));


        List<Person> personList = new ArrayList<>();
        personList.add(person);
        personList.add(person1);

        String[] test1 = personList.stream().map(pp->pp.getId()).toArray(String[]::new);

        System.out.println(JSONUtil.toJsonStr(test1));

        Map map4 = convert(person,Map.class);
        Person person3 = convert(map4,Person.class);
        System.out.println(map4);
        System.out.println(person3);

        jsonObject.put("userName","liuhaoaaa");
        System.out.println(jsonObject);
        System.out.println(convert(jsonObject,Person.class));

        List<String> list1 = new ArrayList<>();
        list1.add("11111");
        list1.add("222222");
        list1.add("333333");

        String s2 = stringListToString(list1);
        System.out.println(s2);

    }

    private static <T> T convert(Object object,Class<T> clazz){
        return JSON.parseObject(JSON.toJSONString(object),clazz);
    }

    public static List<Map<String, Object>> simpleAttributeToList(final Map<String, Object> simpleAttribute,
                                                                  final boolean flag) {

        final List<Map<String, Object>> list = new ArrayList<>();
        final Set<Map.Entry<String, Object>> entrySet = simpleAttribute.entrySet();
        for (final Map.Entry<String, Object> m : entrySet) {
            final Map<String, Object> map = new HashMap<>();
            if (!flag || Optional.ofNullable(m.getValue()).filter((data) -> {
                if (data instanceof String) {
                    return !StringUtils.isEmpty(data);
                } else if (data instanceof Collection) {
                    return !((Collection) data).isEmpty();
                }
                return true;
            }).isPresent()) {
                map.put("name", m.getKey());
                map.put("value", m.getValue());
                list.add(map);
            }
        }
        return list;
    }

    /**
     * 构造cmdb资源配置存储complexAttribute信息
     *
     * @return complexAttribute信息
     */
    public static List<Map<String,Object>> complexAttributeToList(String minorType,String relativeUuid ){

        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("minorType",minorType);
        map.put("relativeUuid",relativeUuid.split(","));
        list.add(map);
        return list;
    }

    /**
     * 将字符串列表转换为拼接字符
     *
     * @param stringList   物理负载均衡器资源编码标识
     * @return ‘，’拼接的字符串
     * */
    public static  String stringListToString(List<String> stringList){
        return null == stringList ? null : stringList.stream().collect(Collectors.joining(","));
    }
}
