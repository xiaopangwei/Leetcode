package leetcode.p2021m12;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/23
 * @time 9:25 PM
 */
public class Solution1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }

        int maxVal = 0;
        int s      = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            s += entry.getValue();
            maxVal = Math.max(maxVal, s);
            if (maxVal > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1094 solution1094 = new Solution1094();
        boolean      ans          = solution1094.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3);
        System.out.println(ans);
    }


}
