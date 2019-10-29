package hliu.demo.test;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class testmap {

    public static void main(String args[]){
        Map<String, List<String>> stringListMap = new HashMap<>();

        List<String> list = new ArrayList<>();
        list.add("111-1");
        stringListMap.put("111",list);

        System.out.println(stringListMap);

        list = stringListMap.get("111");
        list.add("222-2");

        System.out.println(stringListMap);

        List<List<String>> list1 = new ArrayList<>();
        list1.add(list);

        list.add("333-3");

        System.out.println(stringListMap);

        System.out.println(list1);

        System.out.println("123".equals(null));


        Map map = new HashMap();
        map.put("string","i'm string");
        List<String> list2 = new ArrayList<String>();
        list2.add("i'm list");
        map.put("list",list2);

        System.out.println(map);

        List<String> imlist = (List<String>) map.get("list");

        System.out.println(imlist);

        JSONArray jsonArray = JSONUtil.createArray();
        JSONObject jsonObject = JSONUtil.createObj();
        jsonObject.put("1","1");
        JSONObject jsonObject1 = JSONUtil.createObj();
        jsonObject1.put("2","2");
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);
        jsonArray.add(JSONUtil.createArray());

        List<JSONObject> jsonObjects = jsonArray.toList(JSONObject.class);

        System.out.println(jsonObjects);

    }
}
