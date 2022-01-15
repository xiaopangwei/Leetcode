package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 2:41 PM
 */
public class Solution22 {


    List<String> ans = new ArrayList<>();

    private List<String> generateParenthesis(int n) {

        dfs(n, n, "");
        return ans;
    }

    private void dfs(int left, int right, String str) {
        if (left < 0 || right < 0) {
            return;
        }
        if (left == 0 && right == 0) {
            ans.add(str);
            return;
        }

        if (left >= right) {
            dfs(left - 1, right, str + "(");
        } else {
            dfs(left - 1, right, str + "(");
            dfs(left, right - 1, str + ")");
        }
    }

    public static void main(String[] args) {
        Solution22   solution22 = new Solution22();
        List<String> ans        = solution22.generateParenthesis(1);
        System.out.println(ans);
    }
}
