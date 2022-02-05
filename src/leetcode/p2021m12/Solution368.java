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

        int pIndex  = 0;
        int largest = 1;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new ArrayList<>();
        }

        for (int i = 0; i < nums.length; i++) {
            int maxLen = 0;
            int index  = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j].size() > maxLen) {
                        maxLen = dp[j].size();
                        index = j;
                    }
                }
            }

            if (maxLen>0) {
                dp[i].addAll(dp[index]);
            }

            dp[i].add(nums[i]);
            if (dp[i].size() > largest) {
                largest = dp[i].size();
                pIndex = i;
            }
        }

        return dp[pIndex];
    }

    public static void main(String[] args) {
        Solution368 solution368 = new Solution368();
        //2,3,4,9,8
        List<Integer> ans = solution368.largestDivisibleSubset(new int[]{1,2,3});
        System.out.println(ans);
    }
}
