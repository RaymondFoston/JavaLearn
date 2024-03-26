package com.example.practice;



import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Map<String,String> stringStringMap = new HashMap();
        stringStringMap.put("foo","1");
        stringStringMap.put("Key",null);
        stringStringMap.put("bar","2");
        stringStringMap.put("Foo_bar","3");
        stringStringMap.put("foovar","4");
//        stringStringMap.put(null,"glod");
//        stringStringMap.put("abc","fill");
//        stringStringMap.put("absc","fill");
        stringStringMap.put("","d");
        stringStringMap.put("t","");
        stringStringMap = FilterSort.filtrate(stringStringMap,"abc");
        for(String key:stringStringMap.keySet()){
            System.out.println(key+": "+stringStringMap.get(key));
        }
        String stringMap = FilterSort.sortJoint(stringStringMap);
        System.out.println(stringMap);

        // write your code here
//        Integer a = 9;
//        System.out.println(a.getClass());
//        System.out.println(a.compareTo((Integer) 9));
//        Random random = new Random();
//        System.out.println(0x3452);
//        System.out.println(random.nextInt(0x43));
//        String s = "";
//        System.out.println(s == null );
//        Object []a = new String[10];
//        StringBuilder builder = new StringBuilder();
//        for(int i=0;i<a.length;i++) {
//            builder.append(a[i].toString());
//        }
//        String s;
//        System.out.println("s"+s);
//        Thread D= new Thread();
//        D.getClass().getMethods();
        String[] ao=new String[10];
        ao[2]="123";
        System.out.println(ao[0]);




    }
}
