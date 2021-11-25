package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/24
 * @time 8:50 PM
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        int i = 0;
        int j = 0;

        int m = firstList.length;
        int n = secondList.length;

        List<int[]> data = new ArrayList<>();

        while (i < m && j < n) {
            int start1 = firstList[i][0];
            int end1   = firstList[i][1];

            int start2 = secondList[j][0];
            int end2   = secondList[j][1];

            int maxStart = Math.max(start1, start2);
            int minEnd   = Math.min(end1, end2);

            if (maxStart <= minEnd) {
                data.add(new int[]{maxStart, minEnd});
            }

            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        int[][] res = new int[data.size()][2];
        for (int t = 0; t < res.length; t++) {
            res[t][0] = data.get(t)[0];
            res[t][1] = data.get(t)[1];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution986 solution986 = new Solution986();
        int[][]     ans         = solution986.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}}, new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
