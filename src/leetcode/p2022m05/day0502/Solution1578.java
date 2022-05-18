package leetcode.p2022m05.day0502;

import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 3:16 PM
 */
public class Solution1578 {

    public int minCost(String s, int[] cost) {
        int                    i   = 0;
        int                    ans = 0;
        while (i < cost.length) {
            int j = i + 1;
            int sum=cost[i];
            int maxVal=cost[i];
            while (j < cost.length && s.charAt(i) == s.charAt(j)) {
                sum+=cost[j];
                maxVal=Math.max(maxVal,cost[j]);
                j++;
            }
            int len = j - i;
            if (len > 1) {
                ans+=sum-maxVal;
            }
            i=j;
        }

        return ans;
    }

    public static void main(String[] args){
        Solution1578 solution1578=new Solution1578();
        int ans=solution1578.minCost("aabaa",new int[]{1,2,3,4,1});
        System.out.println(ans);
    }
}
