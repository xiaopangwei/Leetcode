package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 9:59 AM
 */
public class Solution46 {
    public int numberOfArithmeticSlices(int[] nums) {


        if (nums.length < 3) {
            return 0;
        }

        Map<Long, List<Integer>> posMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!posMap.containsKey((long) nums[i])) {
                posMap.put((long) nums[i], new ArrayList<>());
            }
            posMap.get((long) nums[i]).add(i);
        }

        int      len = nums.length;
        long[][] dp  = new long[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = 0;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {

                long target = 2 * ((long) nums[i]) - (long) nums[j];

                List<Integer> positionList = posMap.get(target);
                if (positionList != null) {
                    for (int k = 0; k < positionList.size(); k++) {
                        int pos = positionList.get(k);
                        if (pos < i) {
                            dp[i][j] += (dp[pos][i] + 1);
                        }
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j > i) {
                    count += dp[i][j];
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        int        cnt        = solution46.numberOfArithmeticSlices(new int[]{2,4,6,8,10});
        System.out.println(cnt);
    }
}
