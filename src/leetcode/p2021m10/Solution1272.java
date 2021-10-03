package leetcode.p2021m10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 10:37 PM
 */
public class Solution1272 {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {

        List<List<Integer>> ans = new ArrayList<>();
        int                 s   = toBeRemoved[0];
        int                 e   = toBeRemoved[1];
        for (int i = 0; i < intervals.length; i++) {

            int left  = intervals[i][0];
            int right = intervals[i][1];

            if (right < s || left > e) {
                add(ans, left, right);
//                ans.add(Arrays.asList(left, right));
            } else {
                int maxLeft  = Math.max(left, s);
                int minRight = Math.min(right, e);

                if (maxLeft == s && minRight == e) {
//                    ans.add(Arrays.asList(left, s));
//                    ans.add(Arrays.asList(e, right));
                    add(ans, left, s);
                    add(ans, e, right);
                } else if (maxLeft == s && minRight == right) {
//                    ans.add(Arrays.asList(left, maxLeft));
                    add(ans,left,maxLeft);
                } else if (maxLeft == left && minRight == e) {
//                    ans.add(Arrays.asList(e, right));
                    add(ans,e,right);
                }
            }

        }

        return ans;
    }

    private void add(List<List<Integer>> list, int l, int h) {
        if (l == h) {
            return;
        }
        list.add(Arrays.asList(l, h));
    }

    public static void main(String[] args) {
        Solution1272        solution1272 = new Solution1272();
        List<List<Integer>> ans          = solution1272.removeInterval(new int[][]{{0,100}}, new int[]{0,50});
        System.out.println(ans);

    }
}
