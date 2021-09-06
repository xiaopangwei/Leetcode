package leetcode.p2021m09;

import common.uaf.UnionAndFind;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/6
 * @time 5:26 PM
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {

        UnionAndFind unionAndFind = new UnionAndFind(n);

        if (edges.length > 0) {
            unionAndFind.union(edges[0][0], edges[0][1]);
        }
        for (int i = 1; i < edges.length; i++) {
            int p1 = unionAndFind.find(edges[i][0]);
            int p2 = unionAndFind.find(edges[i][1]);

            if (p1 == p2) {
                return false;
            }

            unionAndFind.union(edges[i][0], edges[i][1]);
        }

//        System.out.println(Arrays.toString(unionAndFind.parent));
        if (n > 0) {
            int temp = unionAndFind.find(0);
            for (int i = 1; i < n; i++) {
                if (temp != unionAndFind.find(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution261 solution261 = new Solution261();

        boolean ans = solution261.validTree(1, new int[][]{});

        System.out.println(ans);
    }
}
