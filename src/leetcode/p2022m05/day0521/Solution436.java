package leetcode.p2022m05.day0521;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/21
 * @time 10:27 AM
 */
public class Solution436 {
    public int[] findRightInterval(int[][] intervals) {

        int[] ans = new int[intervals.length];
        Arrays.fill(ans, -1);

        int[][] temp = new int[intervals.length][3];

        for (int i = 0; i < intervals.length; i++) {
            temp[i][0] = intervals[i][0];
            temp[i][1] = intervals[i][1];
            temp[i][2] = i;
        }

        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int target = intervals[i][1];
            int left   = 0;
            int right  = intervals.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid][0] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

                if (left >= 0 && left < intervals.length && temp[left][0] >= target) {
                    ans[i] = temp[left][2];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution436 solution436 = new Solution436();
        int[]       ans         = solution436.findRightInterval(new int[][]{{3, 4}, {2, 3}, {1, 2}});
        System.out.println(Arrays.toString(ans));
    }
}
