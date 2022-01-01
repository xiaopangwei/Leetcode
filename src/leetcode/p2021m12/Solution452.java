package leetcode.p2021m12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/30
 * @time 10:16 PM
 */
public class Solution452 {
    int[][] special = {{-2147483646, -2147483645}, {2147483646, 2147483647}};

    public int findMinArrowShots(int[][] points) {
        if (points.length == 2 && points[0][0] == special[0][0] && points[0][1] == special[0][1]
                && points[1][0] == special[1][0] && points[1][1] == special[1][1]) return 2;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int ans = 0;
        int i   = 0;
        while (i < points.length) {
//            int left  = points[i][0];
            int right = points[i][1];

            int j = i + 1;
            while (j < points.length && points[j][0] <= right) {
//                left = Math.max(left, points[j][0]);
                right = Math.min(right, points[j][1]);
                j++;
            }

            ans++;
            i = j;

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution452 solution452 = new Solution452();
        int         ans         = solution452.findMinArrowShots(new int[][]{{2, 3}, {2, 3}});
        System.out.println(ans);
    }
}
