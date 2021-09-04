package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/2
 * @time 5:54 PM
 */
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] total = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            System.arraycopy(intervals[i], 0, total[i], 0, 2);
        }
        total[total.length - 1][0] = newInterval[0];
        total[total.length - 1][1] = newInterval[1];

        Arrays.sort(total, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        List<int[]> ans = new ArrayList<>();
        ans.add(new int[]{total[0][0], total[0][1]});


        for (int i = 1; i < total.length; i++) {
            int[] last = ans.get(ans.size() - 1);
            if (total[i][0] > last[1]) {
                ans.add(new int[]{total[i][0], total[i][1]});
            } else {
                if (total[i][1] > last[1]) {
                    last[1] = total[i][1];
                }
            }
        }

        int[][] res = new int[ans.size()][2];
        int     k   = 0;
        for (int[] item : ans) {
            res[k++] = item;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution57 solution57 = new Solution57();

        int[][] ans = solution57.insert(new int[][]{{1, 3},{6, 9}}, new int[]{2,5});

        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }

    }
}
