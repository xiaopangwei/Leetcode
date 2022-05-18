package leetcode.p2022m05.day0514;

import common.uaf.UnionAndFind;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 5:10 PM
 */
public class Solution323 {
    public int countComponents(int n, int[][] edges) {
        UnionAndFind unionAndFind = new UnionAndFind(n);
        for (int[] e : edges) {
            int p1 = unionAndFind.find(e[0]);
            int p2 = unionAndFind.find(e[1]);
            if (p1 != p2) {
                unionAndFind.union(p1, p2);
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (unionAndFind.find(i) == i) {
                cnt++;
            }
        }
        return cnt;
    }
}
