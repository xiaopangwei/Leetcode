package leetcode.p2021m12;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/22
 * @time 10:47 PM
 */
public class Solution1306 {
    public boolean canReach(int[] arr, int start) {
        boolean[] visited = new boolean[arr.length];
        return dfs(arr, start, visited);

    }

    private boolean dfs(int[] arr, int start, boolean[] visited) {
        if (arr[start] == 0) {
            return true;
        }

        int     newX1 = start + arr[start];
        boolean flag  = false;
        if (newX1>=0 && newX1 < arr.length && !visited[newX1]) {
            visited[newX1] = true;

            flag = dfs(arr, newX1,visited);
            visited[newX1] = false;

            if (flag) {
                return true;
            }
        }
        int newX2 = start - arr[start];
        if (newX2 >= 0 && newX2 < arr.length && !visited[newX2]) {
            visited[newX2] = true;

            flag = dfs(arr, newX2,visited);
            visited[newX2] = false;

            if (flag) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution1306 solution1306 = new Solution1306();
        boolean      flag         = solution1306.canReach(new int[]{3,0,2,1,2}, 2);
        System.out.println(flag);
    }
}
