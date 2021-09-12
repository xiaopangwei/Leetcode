package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/11
 * @time 3:31 PM
 */
public class Solution1578 {
    public int minCost(String s, int[] cost) {

        int i = 0;
        int j = 1;

        int minCost = 0;

        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                if (cost[i] <= cost[j]) {
                    minCost += cost[i];
                    i = j;
                    j++;
                } else {
                    minCost += cost[j];
                    j++;
                }
            } else {
                i = j;
                j++;
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        Solution1578 solution1578 = new Solution1578();
        int          ans          = solution1578.minCost("aabaa", new int[]{1, 2, 3,4,1});
        System.out.println(ans);
    }
}
