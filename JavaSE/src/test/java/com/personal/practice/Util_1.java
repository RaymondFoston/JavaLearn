package com.personal.practice;

import java.util.*;

public class Util_1 {
    private Map<String, String> ssMap;


    /**
     * 过滤某个key值对的方法
     *
     * @param stringStringMap
     * @param filterValuei
     * @return
     */
    public Map<String, String> filtrate(Map<String, String> stringStringMap, String filterValuei) {
        //去除空值
        int mapLength = stringStringMap.size(),i=0;
        while(i<mapLength){
            for(String key:stringStringMap.keySet()){
                if(stringStringMap.get(key)==null||stringStringMap.get(key).equals("")||key==null||key.equals("")||key.equals(filterValuei)){
                    stringStringMap.remove(key);
                    break;
                }
            }
            i++;
            mapLength--;
        }
        return stringStringMap;
    }

    public static Map<String, String> filtrate3(Map<String, String> stringStringMap, String filterValue){
        Map<String, String> remain = new HashMap<String, String>();
        Iterator<String> iterator = stringStringMap.keySet().iterator();
        while (iterator.hasNext()){
            String key = iterator.next();
            if(key.equals(filterValue)||key.equals("") ||stringStringMap.get(key)==null || stringStringMap.get(key).equals("")){
                continue;
            }

            remain.put(key,stringStringMap.get(key));
        }
        return remain;
    }
    public static Map<String, String> filtrate4(Map<String, String> stringStringMap, String filterValue){
        Map<String, String> remain = new HashMap<String, String>();
//            Iterator<String> iterator = ssMap.keySet().iterator();
        Iterator<Map.Entry<String ,String>> iterator = stringStringMap.entrySet().iterator();
//        for (Iterator<Map.Entry<String, String>> it = iterator; it.hasNext(); ) {
//            Map.Entry<String, String> entry = it.next();
//        }

        while (iterator.hasNext()){
            Map.Entry<String ,String> entry=iterator.next();
//            String key = entry.getKey();
//            String value = entry.getValue();
//            if (key.equals(filterValue)||key.equals("")||value==null||value.equals("")){
//                continue;
//            }
////            System.out.println(value);
//            remain.put(key,value);
        }
        return remain;
    }



    public Map<String, String> sort_joint(Map<String, String> stringStringMap){
        TreeMap<String, String> sortmap=new TreeMap<String, String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
//                return o2.hashCode()-(o1.hashCode());
            }
        });
        sortmap.putAll(stringStringMap);
//        for(String key:sortmap.keySet()){
//            System.out.println(key+": "+sortmap.get(key));
//        }
        return sortmap;
    }

    public String sort_joint2(Map<String, String> stringStringMap){
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.putAll(stringStringMap);
        String[] sortkeys = stringStringMap.keySet().toArray(new String[]{});
        Arrays.sort(sortkeys);
        StringBuilder stringMap = new StringBuilder();
        int num=sortkeys.length,i=1;
        for (String s:sortkeys) {
            for (String key : stringStringMap.keySet()) {
                if (s.equals(key)) {
                    stringMap.append(s).append("=").append(stringStringMap.get(key));
                }
            }
            if (num>i){
                stringMap.append("&");
                i++;
            }

        }
        return stringMap.toString();

    }






}
