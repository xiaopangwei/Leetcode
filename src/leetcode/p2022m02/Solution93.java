package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 2:26 PM
 */
public class Solution93 {
    private List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, new ArrayList<>());
        return ans;
    }
    public void dfs(String s, int startIndex, List<String> temp) {
        if (startIndex == s.length() || temp.size() == 4) {
            if (startIndex == s.length() && temp.size() == 4) {
                ans.add(String.join(".", temp));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int j = startIndex + i - 1;
            if (j >= s.length()) {
                continue;
            }
            String sub = s.substring(startIndex, j + 1);
            if (sub.length() >= 2 && sub.charAt(0) == '0') {
                continue;
            }
            int val = Integer.valueOf(sub);
            if (val > 255) {
                continue;
            }
            temp.add(sub);
            dfs(s, j + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution93   solution93 = new Solution93();
        List<String> ans        = solution93.restoreIpAddresses("101023");
        System.out.println(ans);
    }
}
