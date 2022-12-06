package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 10:47 PM
 */
public class Solution2374 {
    public int edgeScore(int[] edges) {
        int[] score = new int[edges.length];
        int   max   = 0;
        for (int i = 0; i < edges.length; i++) {
            score[edges[i]] += i;
            max = Math.max(max, score[edges[i]]);
        }

        for (int i = 0; i < score.length; i++) {
            if (max == score[i]) {
                return i;
            }
        }
        return -1;
    }
}
