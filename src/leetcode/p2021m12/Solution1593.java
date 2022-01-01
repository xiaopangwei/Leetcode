package leetcode.p2021m12;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/29
 * @time 9:44 PM
 */
public class Solution1593 {
    int maxVal = 0;

    public int maxUniqueSplit(String s) {

        dfs(s, new HashSet<>());
        return maxVal;
    }

    private void dfs(String s, Set<String> sets) {
        if (s.length() == 0) {
            maxVal = Math.max(maxVal, sets.size());
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String left = s.substring(0, i);
            if (!sets.add(left)) {
                continue;
            }
            String right = s.substring(i, s.length());
            dfs(right, sets);
            sets.remove(left);
        }
    }

    public static void main(String[] args) {
        Solution1593 solution1593 = new Solution1593();
        int          ans          = solution1593.maxUniqueSplit("aa");
        System.out.println(ans);

    }
}
