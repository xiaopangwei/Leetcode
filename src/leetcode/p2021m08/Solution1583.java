package leetcode.p2021m08;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 11:07 AM
 */
public class Solution1583 {
    private int[][] scores;

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        scores = new int[n][n];
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {

                int idx  = preferences[i][j];
                int temp = n - j;
                scores[i][idx] = temp;

            }
        }

        Set<Integer> sets    = new HashSet<>();
        int          pairLen = pairs.length;
        for (int i = 0; i < pairLen; i++) {
            for (int j = i + 1; j < pairLen; j++) {
                int[] a = pairs[i];
                int[] b = pairs[j];
                if (check(a[0], a[1], b[0], b[1])) {
                    sets.add(a[0]);
                }
                if (check(a[0], a[1], b[1], b[0])) {
                    sets.add(a[0]);
                }
                if (check(a[1], a[0], b[0], b[1])) {
                    sets.add(a[1]);
                }
                if (check(a[1], a[0], b[1], b[0])) {
                    sets.add(a[1]);
                }


                if (check(b[0], b[1], a[0], a[1])) {
                    sets.add(b[0]);
                }
                if (check(b[0], b[1], a[1], a[0])) {
                    sets.add(b[0]);
                }
                if (check(b[1], b[0], a[0], a[1])) {
                    sets.add(b[1]);
                }
                if (check(b[1], b[0], a[1], a[0])) {
                    sets.add(b[1]);
                }
            }
        }

        return sets.size();
    }

    private boolean check(int x, int y, int u, int v) {
        return (getScore(x, u) > getScore(x, y)) && (getScore(u, x) > getScore(u, v));
    }

    private int getScore(int a, int b) {
//        System.out.println("score " + a + "," + b + " " + scores[a][b]);
        return scores[a][b];
    }

    public static void main(String[] args) {
        Solution1583 solution1583 = new Solution1583();
        int[][]      array        = new int[][]{{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}};
        System.out.println(solution1583.unhappyFriends(4, array, new int[][]{{0, 1}, {2, 3}}));
    }
}
