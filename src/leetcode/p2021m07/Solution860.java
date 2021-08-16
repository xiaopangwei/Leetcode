package leetcode.p2021m07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 4:29 PM
 */
public class Solution860 {
    public boolean lemonadeChange(int[] bills) {

        Map<Integer,Integer> times=new HashMap<>();

        for (int bill:bills){
            if (bill==5){
                times.put(5,times.getOrDefault(bill,0)+1);
            }else if (bill==10){
                int temp=times.getOrDefault(5,0);
                if (temp>=1){
                    times.put(10,times.getOrDefault(10,0)+1);
                    times.put(5,times.getOrDefault(5,0)-1);
                }else{
                    return false;
                }
            }else {
                int temp5=times.getOrDefault(5,0);
                int temp10=times.getOrDefault(10,0);
                if (temp10>=1 && temp5>=1){
                    times.put(10,times.getOrDefault(10,0)-1);
                    times.put(5,times.getOrDefault(5,0)-1);
                    times.put(20,times.getOrDefault(20,0)+1);
                }else if (temp5>=3){
                    times.put(5,times.getOrDefault(5,0)-3);
                    times.put(20,times.getOrDefault(20,0)+1);
                }else{
                    return false;
                }

            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution860 solution860=new Solution860();
        System.out.println(solution860.lemonadeChange(new int[]{5,5,10,10,20}));
    }
}
