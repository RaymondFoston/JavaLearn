package com.personal.practice;

import java.util.*;

public class FilterSort {

    /**
     * 过滤方法，过滤符合条件的键值对
     * @param stringStringMap
     * @param filterValue
     * @return 过滤后的Map集合
     */
    public static Map<String, String> filtrate(Map<String, String> stringStringMap, String filterValue){
        Map<String, String> remain = new HashMap<String, String>();

        Iterator<Map.Entry<String ,String>> iterator = stringStringMap.entrySet().iterator();
        for (Map.Entry<String ,String> entry: stringStringMap.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            if (key.equals(filterValue)||key.equals("")||value==null||value.equals("")){
                continue;
            }
            remain.put(key,value);
        }
        return remain;
    }

    /**
     * 排序方法，对map进行anscii排序，连接为一个字符串
     * @param stringStringMap
     * @return String变量
     */
    public static String sortJoint(Map<String, String> stringStringMap){
        Map<String, String> ssMap = new HashMap<String, String>();
        ssMap=stringStringMap;
        Set<String> stringSet = ssMap.keySet();
        List<String> stringList = new ArrayList(stringSet);
        Collections.sort(stringList,String.CASE_INSENSITIVE_ORDER);
        StringBuilder stringMap = new StringBuilder();
        for (int i=0;i<stringList.size();i++){
            String key=stringList.get(i);
            stringMap.append(key).append("=").append(ssMap.get(key));
            if (i<stringList.size()-1){
                stringMap.append("&");
            }
        }
        return stringMap.toString().toLowerCase();
    }

}
