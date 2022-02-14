package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 9:50 PM
 */
public class Solution386 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {

        for (int i = 1; i < 10; i++) {
            dfs(i, n);
        }
        return ans;
    }

    public void dfs(int val, int n) {
        if (val > n) {
            return;
        }
        ans.add(val);
        for (int i = 0; i < 10; i++) {
            dfs(val * 10 + i, n);
        }
    }

    public static void main(String[] args) {
        Solution386   solution386 = new Solution386();
        List<Integer> ans         = solution386.lexicalOrder(2);
        System.out.println(ans);
    }
}
