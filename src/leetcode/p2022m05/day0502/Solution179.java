package leetcode.p2022m05.day0502;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 2:42 PM
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int item:nums){
            list.add(String.valueOf(item));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                long t1=Long.parseLong(o1+o2);
                long t2=Long.parseLong(o2+o1);
                return (int)(t2-t1);
            }
        });


        StringBuilder sb=new StringBuilder();
        for (int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        String temp=sb.toString();

        int count=0;
        for (int i=0;i<temp.length();i++){
            if (temp.charAt(i)!='0'){
                break;
            }else{
                count++;
            }
        }

        String t=temp.substring(count);
        if (t.isEmpty()){
            return "0";
        }else{
            return t;
        }
    }

    public static void main(String[] args){
        Solution179 solution179=new Solution179();
        String ans=solution179.largestNumber(new int[]{3,30,34,5,9});
        System.out.println(ans);
    }
}
