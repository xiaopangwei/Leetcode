package leetcode.p2022m05.day0509;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 9:06 PM
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        int min = newInterval[0];
        int max = newInterval[1];
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            min = Math.min(min, Math.min(intervals[i][0], newInterval[0]));
            max = Math.max(max, Math.max(intervals[i][1], newInterval[1]));
            i++;
        }

        if (min != Integer.MAX_VALUE && max != Integer.MIN_VALUE) {
            res.add(new int[]{min, max});
        }

        while (i < intervals.length) {
            res.add(intervals[i++]);
        }


        int[][] ans = new int[res.size()][2];
        for (int t = 0; t < res.size(); t++) {
            ans[t] = res.get(t);
        }
        return ans;

    }

}

