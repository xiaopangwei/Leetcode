package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/21
 * @time 8:23 PM
 */
public class Solution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        //2,3,4,8,9
        List<Integer>[] dp = new ArrayList[nums.length];

        int tIndex     = -1;
        int longestLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int maxLen        = -1;
            int indexOfMaxLen = 0;
            dp[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j].size() > maxLen && dp[j].size() != 0) {
                        indexOfMaxLen = j;
                        maxLen = dp[j].size();
                    }
                }
            }

//            System.out.println(i+" "+nums[i]+" "+indexOfMaxLen+" "+maxLen);
            if (maxLen > 0) {
                List<Integer> t = dp[indexOfMaxLen];
                dp[i].addAll(t);
            }
            dp[i].add(nums[i]);

//            System.out.println(dp[i]);
            if (dp[i].size() > longestLen) {
                longestLen = dp[i].size();
                tIndex = i;
            }

        }


        return dp[tIndex];
    }

    public static void main(String[] args) {
        Solution368 solution368 = new Solution368();
        //2,3,4,9,8
        List<Integer> ans = solution368.largestDivisibleSubset(new int[]{3,17});
        System.out.println(ans);
    }
}
