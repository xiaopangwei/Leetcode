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
            freq.put(fruits[right], freq.getOrDefault(fruits[right],0) + 1);
            while (left < right && freq.keySet().size() > 2) {
                int t = freq.get(fruits[left]) - 1;
                if (t <= 0) {
                    freq.remove(fruits[left]);
                } else {
                    freq.put(fruits[left], t);
                }
                left++;
            }
            maxVal = Math.max(right - left + 1, maxVal);
            right++;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int         ans         = solution904.totalFruit(new int[]{1,2,1});
        System.out.println(ans);
    }
}
