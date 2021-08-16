package leetcode.p2021m07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 5:32 PM
 */
public class Solution217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int item:nums){
            if (map.containsKey(item)){
                return true;
            }else{
                map.put(item,1);
            }
        }
        return false;
    }

    public static void main(String[] args){
        Solution217 solution217=new Solution217();
        boolean ans=solution217.containsDuplicate(new int[]{1,2,3,1});

    }
}
