package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/27
 * @time 7:22 PM
 */
public class Solution904 {
    public int totalFruit(int[] fruits) {

        if (fruits.length <= 2) {
            return fruits.length;
        }
        int                   left   = 0;
        int                   right  = 0;
        Map<Integer, Integer> freq   = new HashMap<>();
        int                   maxVal = 0;
        while (right < fruits.length) {
            if (freq.containsKey(fruits[right])) {
                freq.put(fruits[right], freq.get(fruits[right]) + 1);
                right++;
            } else {
                if (freq.keySet().size() >= 2) {
                    while (left < right && freq.keySet().size() >= 2) {
                        int t = freq.getOrDefault(fruits[left], 0);
                        if (t > 1) {
                            freq.put(fruits[left], t - 1);
                        } else {
                            freq.remove(fruits[left]);
                        }
                        left++;
                    }

                }
                int t = freq.getOrDefault(fruits[right], 0) + 1;
                freq.put(fruits[right], t);
                right++;

            }
            maxVal = Math.max(right - left, maxVal);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int         ans         = solution904.totalFruit(new int[]{1, 2, 3, 2, 2});
        System.out.println(ans);
    }
}
