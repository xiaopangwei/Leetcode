package leetcode.p20210218;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution38 {

    private Map<Integer,String> cached=new HashMap<>();

    public String countAndSay(int n) {
        return countAndSay(n,n);
    }

    private String countAndSay(int n,int index) {
        if (cached.containsKey(index)){
            return cached.get(index);
        }
        if (index==1){
            return "1";
        }
        String str1=countAndSay(n,index-1);

        char[] arr=str1.toCharArray();
        String result=getFreqStr(arr);
        if (!cached.containsKey(index)){
            cached.put(index,result);
        }
        return result;

    }

    private String getFreqStr(char[] arr){
        int currentIndex=0;
        Map<Integer,Integer> freq=new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[currentIndex]) {
                freq.put(currentIndex, freq.getOrDefault(currentIndex,0) + 1);
            } else {
                currentIndex=i;
                freq.put(currentIndex, freq.getOrDefault(currentIndex,0) + 1);
            }
        }

        StringBuilder stringBuilder=new StringBuilder();
        for (Map.Entry<Integer,Integer> entry:freq.entrySet()){
            stringBuilder.append(entry.getValue());
            stringBuilder.append(arr[entry.getKey()]);

        }

        return stringBuilder.toString();
    }


    public static void main(String[] args){
        Solution38 solution38=new Solution38();
        System.out.println(solution38.countAndSay(4));

    }


}
