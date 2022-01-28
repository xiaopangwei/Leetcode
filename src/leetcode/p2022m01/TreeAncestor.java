package leetcode.p2022m01;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/27
 * @time 7:45 PM
 */
public class TreeAncestor {
    int[]   parent;
    int     n;
    int[][] ancester;

    public TreeAncestor(int n, int[] parent) {
        this.n = n;
        this.parent = parent;

        ancester = new int[n][20];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ancester[i], -1);
        }
        for (int i = 0; i < n; i++) {
            ancester[i][0] = parent[i];
        }

        for (int j = 1; (1 << j) < n; j++) {
            for (int i = 0; i < n; i++) {
                if (ancester[i][j - 1] != -1) {
                    ancester[i][j] = ancester[ancester[i][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        if (k == 0 || node == -1) {
            return node;
        }
        int t = (int) (Math.log(k));
        return getKthAncestor(ancester[node][t], k - (1 << t));

    }


    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        int          ans          = treeAncestor.getKthAncestor(5, 2);
        System.out.println(ans);
    }
}
