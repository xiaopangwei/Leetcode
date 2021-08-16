package demo.test20210120;


import java.util.HashMap;
import java.util.Map;

public class Solution746 {
    private static Map<Integer,Integer> cached =new HashMap<>();
    public int minCostClimbingStairs(int[] cost) {
        return f(cost.length,cost);
    }
    private int f(int j,int[] cost){
        if (cached.containsKey(j)){
            return cached.get(j);
        }
        if(j>=2)
        {
            int res=Math.min(f(j-1,cost)+cost[j-1],f(j-2,cost)+cost[j-2]);
            cached.put(j,res);
            return res;
        }
        else{
                cached.put(j, 0);
                return 0;
            }

        }

    public static void main(String[] args) {
        Solution746 solution746=new Solution746();
        int[] cost=new int[]{1, 100, 10,50,1,80};
        System.out.println(solution746.minCostClimbingStairs(cost));
    }
}