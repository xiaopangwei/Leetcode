package leetcode.p2022m06.day0628;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/28
 * @time 10:06 PM
 */
public class Solution525 {
    public int findMaxLength(int[] nums) {
        int[]                 prefixSum = new int[nums.length + 1];
        Map<Integer, Integer> pos       = new HashMap<>();
        pos.put(0, 0);
        int maxLen = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            int t = nums[i - 1] == 0 ? -1 : 1;
            prefixSum[i] = prefixSum[i - 1] + t;
            if (!pos.containsKey(prefixSum[i])) {
                pos.put(prefixSum[i], i);
            } else {
                int prevPos = pos.get(prefixSum[i]);
                maxLen = Math.max(i - prevPos, maxLen);
            }
        }
        return maxLen;
    }
    public static void main(String[] args){
        int[] array=new int[]{0};
        Solution525 solution525=new Solution525();
        int maxLength=solution525.findMaxLength(array);
        System.out.println(maxLength);
    }
}
