package leetcode.p2021m12;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/14
 * @time 10:18 PM
 */
public class Solution888 {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int left  = 0;
        int right = 0;
        for (int item : aliceSizes) {
            left += item;
        }


        Set<Integer> bobSets = new HashSet<>();

        for (int item : bobSizes) {
            right += item;
            bobSets.add(item);
        }

        int half = (left + right) / 2;

        int delta = Math.abs(half - left);
        if (left < half) {

            for (int item : aliceSizes) {
                if (bobSets.contains(item + delta)) {
                    return new int[]{item, item + delta};
                }
            }
        } else {
            for (int item : aliceSizes) {
                if (bobSets.contains(item - delta)) {
                    return new int[]{item, item - delta};
                }
            }
        }


        return null;


    }
}
