package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/5
 * @time 8:04 PM
 */
public class Solution253 {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], map.getOrDefault(intervals[i][0], 0) + 1);
            map.put(intervals[i][1], map.getOrDefault(intervals[i][1], 0) - 1);
        }

        int curr   = 0;
        int maxVal = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            curr += entry.getValue();
            maxVal = Math.max(maxVal, curr);
        }
        return intervals.length - maxVal;
    }

}
