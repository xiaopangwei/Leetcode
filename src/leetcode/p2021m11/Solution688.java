package leetcode.p2021m11;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/22
 * @time 10:23 PM
 */
public class Solution688 {
    Map<String, Double> cached     = new HashMap<>();
    int[][]              directions = new int[][]{{-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

    public double knightProbability(int n, int k, int row, int column) {
        double m     = Math.pow(8, k);
        double    total = dfs(row, column, n, k);
        return total * 1.0 / m;
    }

    private double dfs(int startX, int startY, int n, int k) {
        String key = startX + "#" + startY + "#" + k;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (startX < 0 || startY < 0 || startX >= n || startY >= n) {
            return 0;
        }
        if (k == 0) {
            return 1;
        }
        double ans = 0;
        for (int i = 0; i < directions.length; i++) {
            int newX = startX + directions[i][0];
            int newY = startY + directions[i][1];
            ans += dfs(newX, newY, n, k - 1);
        }

        cached.put(key, ans);
        return ans;
    }
    public static void main(String[] args){
        Solution688 solution688=new Solution688();
        double a=solution688.knightProbability(8,30,6,4);
        System.out.println(a);
    }
}
