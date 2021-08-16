package leetcode.p20210629;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 1:58 PM
 */
public class Solution594 {
    public int findLHS(int[] nums) {

        Map<Integer,Integer> freq=new TreeMap<>();
        for (int item:nums){
            freq.put(item,freq.getOrDefault(item,0)+1);
        }

        int maxVal=-1;
        for (Integer key:freq.keySet()){
            if (freq.containsKey(key+1)){
                maxVal=Math.max(maxVal,freq.get(key)+freq.get(key+1));
            }else{
                maxVal=Math.max(maxVal,0);
            }
        }
        return maxVal;
    }

    public static void main(String[] args){
        Solution594 solution594=new Solution594();
        System.out.println(solution594.findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(solution594.findLHS(new int[]{1,2,3,4}));
        System.out.println(solution594.findLHS(new int[]{1,2,1,1}));
    }
}
