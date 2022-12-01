package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/29
 * @time 9:32 PM
 */
public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int curr           = 0;
        int maxCost        = 0;
        int maxCostOfIndex = 0;

        for (int[] log : logs) {
            int cost = log[1] - curr;
            if (cost > maxCost) {
                maxCost = cost;
                maxCostOfIndex = log[0];
            }
            curr = log[1];
        }
        return maxCostOfIndex;
    }

    public static void main(String[] args){
        Solution2432 solution2432=new Solution2432();
        System.out.println(solution2432.hardestWorker(10,new int[][]{{0,3},{2,5},{0,9},{1,15}}));
    }
}
