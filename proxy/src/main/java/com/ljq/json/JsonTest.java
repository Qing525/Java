package com.ljq.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lijq
 * @date : 2020/2/24 15:45
 */
public class JsonTest {

    public static void main(String[] args) {
   /*     List<String> stringList = new ArrayList<>();
        stringList.add("aaa");
        stringList.add("bbb");
        stringList.add("ccc");
        stringList.add("ddd");
        String s = JSON.toJSONString(stringList);
        System.out.println(s);
        List<String> strings = JSON.parseArray(s, String.class);
        System.out.println(strings);*/

        Map<String,Integer> map = new HashMap<>();
        map.put("zhangsan", 18);
        map.put("lisi", 28);
        map.put("wangwu", 38);
        String s = JSON.toJSONString(map);
        System.out.println(s);
        Object parse = JSONObject.parseObject(s, HashMap.class);
    }
}
