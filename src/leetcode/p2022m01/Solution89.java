package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/11
 * @time 9:05 PM
 */
public class Solution89 {
    public List<Integer> grayCode(int n) {

        int           length = 1 << n;
        List<Integer> ans    = new ArrayList<>(length);

        boolean[] visited = new boolean[length];
        dfs(ans, visited, 0, n);
        return ans;
    }

    private void dfs(List<Integer> list, boolean[] visited, int val, final int n) {
        if (list.size() == 1 << n) {
            return;
        }

        list.add(val);
        visited[val] = true;
        for (int i = 0; i < n; i++) {
            int t    = 1 << i;
            ////这里改变cur的某一位，用异或
            int newT = t ^ val;

            if (!visited[newT]) {
                System.out.println(val+" "+"newT "+newT);
                dfs(list, visited, newT, n);
            }
        }

        visited[val] = false;

    }

    public static void main(String[] args) {
        Solution89 solution89 = new Solution89();
//        System.out.println(6 ^ 1);
//        System.out.println(6 ^ 2);
//        System.out.println(6 ^ 4);
        List<Integer> ans = solution89.grayCode(3);
        System.out.println(ans);


        System.out.println(3<<2);
    }
}
