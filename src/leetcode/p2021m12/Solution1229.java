package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/20
 * @time 10:14 PM
 */
public class Solution1229 {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(slots1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Arrays.sort(slots2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });


        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < slots1.length && idx2 < slots2.length) {
            int s1 = slots1[idx1][0];
            int e1 = slots1[idx1][1];

            int s2 = slots2[idx2][0];
            int e2 = slots2[idx2][1];

            int sMax = Math.max(s1, s2);
            int eMin = Math.min(e1, e2);

            if (eMin - sMax >= duration) {
                ans.add(sMax);
                ans.add(sMax + duration);
                return ans;
            } else {
                if (e1 > e2) {
                    idx2++;
                } else if (e1 < e2) {
                    idx1++;
                } else {
                    idx1++;
                    idx2++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1229  solution1229 = new Solution1229();
        List<Integer> ans          = solution1229.minAvailableDuration(new int[][]{{10, 50}, {60, 120}, {140, 210}}, new int[][]{{0, 15}, {60, 70}}, 8);
        System.out.println(ans);
    }
}
