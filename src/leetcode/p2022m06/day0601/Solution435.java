package leetcode.p2022m06.day0601;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 9:04 PM
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];

            }
        });

        int maxEnd = intervals[0][1];
        int count  = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < maxEnd) {
                continue;
            }
            count++;
            maxEnd = intervals[i][1];
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution435 solution435 = new Solution435();
        int         count       = solution435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});
        System.out.println(count);
    }

}
