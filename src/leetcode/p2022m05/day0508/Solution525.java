package leetcode.p2022m05.day0508;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 9:27 PM
 */
public class Solution525 {
    public int findMaxLength(int[] nums) {

        int                   maxLen    = 0;
        int                   sum       = 0;
        Map<Integer, Integer> sumMap    = new HashMap<>();
        int[]                 prefixSum = new int[nums.length];

        sumMap.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
            sum += nums[i];
            if (sumMap.containsKey(sum)) {
                int temp = i - sumMap.get(sum);
                maxLen = Math.max(temp, maxLen);
            } else {
                sumMap.put(sum, i);
            }

        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution525 solution525 = new Solution525();
        int ans = solution525.findMaxLength(new int[]{
                0, 0, 1, 0, 0, 0, 1, 1});
        System.out.println(ans);
    }
}
