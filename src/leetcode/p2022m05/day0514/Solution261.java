package leetcode.p2022m05.day0514;

import common.uaf.UnionAndFind;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/14
 * @time 5:05 PM
 */
public class Solution261 {
    public boolean validTree(int n, int[][] edges) {
        UnionAndFind unionAndFind = new UnionAndFind(5);
        for (int i = 0; i < edges.length; i++) {
            int p1 = unionAndFind.find(edges[i][0]);
            int p2 = unionAndFind.find(edges[i][1]);
            if (p1 == p2) {
                return false;
            } else {
                unionAndFind.union(p1, p2);
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (unionAndFind.find(i) == i) {
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution261 solution261=new Solution261();
        System.out.println(solution261.validTree(5,new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));
    }
}
