package leetcode.p2022m05.day0510;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/10
 * @time 10:01 PM
 */
public class Solution435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        int maxOverlapedCount = 0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                return o1[1] - o2[1];

            }
        });


        int end   = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

    public static void main(String[] args) {

    }
}
