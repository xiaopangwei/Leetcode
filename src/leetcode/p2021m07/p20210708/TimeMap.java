package leetcode.p2021m07.p20210708;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 4:06 PM
 */
public class TimeMap {

    static class CompondValue{
        public String key;
        public String value;
        public int timestamp;

        public CompondValue(String k,String v,int timestamp){
            this.key=k;
            this.value=v;
            this.timestamp=timestamp;
        }

        @Override
        public int hashCode() {
            return key.hashCode()*11+value.hashCode()*7;
        }
    }
    private Map<String,List<CompondValue>> map =new HashMap<>();
    /** Initialize your data structure here. */
    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        CompondValue compondValue=new CompondValue(key,value,timestamp);
        if (!map.containsKey(key)){
            List<CompondValue> list=new ArrayList<>();
            map.put(key,list);
        }

        map.get(key).add(compondValue);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)){
            return "";
        }
        List<CompondValue> list=map.get(key);
        if (list.isEmpty()){
            return "";
        }
        int left=0;
        int right=list.size()-1;
        if (!list.isEmpty() && list.get(list.size()-1).timestamp<timestamp){
            return list.get(list.size()-1).value;
        }
        while (left<=right){
            int mid=(left+right)/2;
            CompondValue temp=list.get(mid);
            if (temp.timestamp==timestamp){
                return temp.value;
            }else if (temp.timestamp>timestamp){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        if (left>=1 && left<list.size()){
            return list.get(left-1).value;
        }
        return "";
    }

    public static void main(String[] args){
        TimeMap timeMap=new TimeMap();
        timeMap.set("a","bar",1);
        timeMap.set("x","b",3);
        System.out.println(timeMap.get("b",3));
        timeMap.set("boo","bar2",4);
        System.out.println(timeMap.get("foo",4));
        System.out.println(timeMap.get("foo",5));

    }
}
