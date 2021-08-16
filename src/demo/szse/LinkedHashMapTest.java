package demo.szse;

import java.util.*;

public class LinkedHashMapTest {

    public static void main(String[] args) {


        float x=(float) 0.75;
        Map<String,Integer> map=new LinkedHashMap<String,Integer>
                (10,  x,true);
        map.put("123",456);
        map.put("234",567);
        map.put("034",345);
        map.put("345",678);
        map.put("456",789);
        map.put("256",789);




        Set<Map.Entry<String,Integer>> set = map.entrySet();
        for (Map.Entry<String,Integer> entry:set){
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }

        System.out.println(map.get("123"));


        System.out.println(map.get("345"));


        Set<Map.Entry<String,Integer>> set1 = map.entrySet();
        for (Map.Entry<String,Integer> entry:set1){
            System.out.println(entry.getKey()+"==>"+entry.getValue());
        }

    }
}
