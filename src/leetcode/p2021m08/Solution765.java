package leetcode.p2021m08;

import common.uaf.UnionAndFind;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 1:28 PM
 */
public class Solution765 {
    public int minSwapsCouples(int[] row) {
        int          len = row.length;
        int          n   = len / 2;
        UnionAndFind uaf = new UnionAndFind(n);

        for (int i = 0; i < row.length; i += 2) {
            int first  = row[i] / 2;
            int second = row[i + 1] / 2;
            uaf.union(first, second);
        }

        int connectedComponentCount=0;
        for (int i=0;i<uaf.parent.length;i++){
            if (uaf.parent[i]==i){
                connectedComponentCount++;
            }
        }

        return n-connectedComponentCount;
    }

    public static void main(String[] args) {
        Solution765 solution765=new Solution765();
        int ans=solution765.minSwapsCouples(new int[]{3, 2, 0, 1});
        System.out.println(ans);
    }
}
