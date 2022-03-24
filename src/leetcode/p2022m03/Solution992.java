package leetcode.p2022m03;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 10:48 AM
 */
public class Solution992 {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int temp = 0;
        if (k - 1 <= 0) {
            temp = 0;
        } else {
            temp = mostCount(nums, k - 1);
        }
        return mostCount(nums, k) - temp;
    }

    private int mostCount(int[] nums, int k) {
        int                   count = 0;
        int                   left  = 0;
        int                   right = 0;
        Map<Integer, Integer> freq  = new HashMap<>();
        while (right < nums.length) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.keySet().size() <= k) {
//                System.out.println(left + " " + right);
                count += (right - left + 1);
            } else if (freq.keySet().size() > k) {
                while (left < right && freq.keySet().size() > k) {
                    int f = freq.get(nums[left]) - 1;
                    if (f > 0) {
                        freq.put(nums[left], f);
                    } else {
                        freq.remove(nums[left]);
                    }
                    left++;
                }
//                System.out.println(left + " " + right);
                count += (right - left + 1);
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution992 solution992 = new Solution992();
        int         ans         = solution992.subarraysWithKDistinct(new int[]{1,2,1,3,4}, 3);
        System.out.println(ans);
    }
}
