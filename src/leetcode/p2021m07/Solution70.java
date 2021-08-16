package leetcode.p2021m07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 5:59 PM
 */
public class Solution70 {
    Map<Integer,Integer> cache=new HashMap<>();
    public int climbStairs(int n) {
       cache.put(1,1);
       cache.put(2,2);
       return  help(n);
    }

    private int help(int n){
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }

        int a=0;
        if (cache.containsKey(n-1)){
            a=cache.get(n-1);
        }else{
            a=climbStairs(n-1);
            cache.put(n-1,a);
        }

        int b=0;
        if (cache.containsKey(n-2)){
            b=cache.get(n-2);
        }else{
            b=climbStairs(n-2);
            cache.put(n-2,b);
        }

        int sum=a+b;
        if (!cache.containsKey(n)){
            cache.put(n,sum);
        }
        return sum;
    }


    public static void main(String[] args){
        Solution70 solution70=new Solution70();
        System.out.println(solution70.climbStairs(4));
    }
}
