package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 10:42 PM
 */
public class Solution44 {
    public boolean isMatch(String s, String p) {
        return dfs(s, 0, p, 0);
    }

    private boolean dfs(String src, int sIndex, String pattern, int pIndex) {
        if (sIndex == src.length()) {
            return pIndex == pattern.length()
                    || (pattern.charAt(pIndex) == '*'
                    && dfs(src, sIndex, pattern, pIndex + 1));
        }

        if (pIndex == pattern.length()) {
            return false;
        }


        char ch = pattern.charAt(pIndex);
        if (ch == '?') {
            return dfs(src, sIndex + 1, pattern, pIndex + 1);
        } else if (ch == '*') {
            return dfs(src, sIndex, pattern, pIndex + 1) ||
                    dfs(src, sIndex + 1, pattern, pIndex);
        } else {
            if (src.charAt(sIndex) == ch) {
                return dfs(src, sIndex + 1, pattern, pIndex + 1);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution44 solution44 = new Solution44();

        boolean ans = solution44.isMatch("adceb", "*a?*b");


        System.out.println(ans);
    }
}
