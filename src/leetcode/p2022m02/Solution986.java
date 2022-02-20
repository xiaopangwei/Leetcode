package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/17
 * @time 8:53 PM
 */
public class Solution986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> ans = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int start1 = firstList[i][0];
            int start2 = secondList[j][0];
            int end1   = firstList[i][1];
            int end2   = secondList[j][1];

            int maxLeft  = Math.max(start1, start2);
            int minRight = Math.min(end1, end2);

            if (maxLeft <= minRight) {
                ans.add(new int[]{maxLeft, minRight});
            }

            if (end1 < end2) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        Solution986 solution986 = new Solution986();
        int[][] ans = solution986.intervalIntersection(new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});

        for (int i = 0; i < ans.length; i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
    }
}
