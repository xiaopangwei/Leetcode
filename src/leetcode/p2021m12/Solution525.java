package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/22
 * @time 10:09 PM
 */
public class Solution525 {
    public int findMaxLength(int[] nums) {

        int                   sum            = 0;
        int                   maxVal         = 0;
        Map<Integer, Integer> sumAndIndexMap = new HashMap<>();
        sumAndIndexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            int t = 1;
            if (nums[i] == 0) {
                t = -1;
            }

            sum += t;
            if (!sumAndIndexMap.containsKey(sum)) {
                sumAndIndexMap.put(sum, i);
            } else {
                int index = sumAndIndexMap.get(sum);
                maxVal = Math.max(maxVal, i - index);
            }
        }


        return maxVal;
    }

    public static void main(String[] args) {
        Solution525 solution525 = new Solution525();
        int         len         = solution525.findMaxLength(new int[]{0, 1});
        System.out.println(len);
    }
}
