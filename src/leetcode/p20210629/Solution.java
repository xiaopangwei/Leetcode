package leetcode.p20210629;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 10:56 AM
 */
public class Solution {
    // 安卓系统手势解锁
    public int numberOfPatterns(int m, int n) {
        int ans = 0;
        boolean[][] visited = new boolean[3][3];
        List<String> data=new ArrayList<>();
        ans += dfs(visited, m, n, 0, 0, 0,data) << 2;
        ans += dfs(visited, m, n, 0, 1, 0,data) << 2;
        ans += dfs(visited, m, n, 1, 1, 0,data);
        return ans;
    }

    private int dfs(boolean[][] visited, int m, int n, int i, int j, int count, List<String> data) {
        int ans = 0;
        count++;
        System.out.println(i+" "+j);
        if (count >= m) {ans++;System.out.println("res:"+data);}
        if (count >= n) {System.out.println("res:"+data);return ans;}
        visited[i][j] = true;
        data.add(i+","+j);
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (canReach(visited, i, j, r, c)) {
//                    System.out.println("(r,c)"+r+" "+c+" (i,j)"+i+" "+j);
                    ans += dfs(visited, m, n, r, c, count,data);
                }
            }
        }
        visited[i][j] = false;
        data.remove(data.size()-1);
        return ans;
    }

    private boolean canReach(boolean[][] visited, int x1, int y1, int x2, int y2) {
        if (visited[x2][y2]) return false;
        int x = Math.abs(x1 - x2);
        int y = Math.abs(y1 - y2);
        if (x <= 1 && y <= 1) return true;
        if (x != 1 && y != 1) return visited[(x1 + x2) >>> 1][(y1 + y2) >>> 1];
        return true;
    }

    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.numberOfPatterns(2,2));
//        System.out.println(solution.numberOfPatterns(2,2));

    }
}
