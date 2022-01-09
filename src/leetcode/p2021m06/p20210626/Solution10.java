package leetcode.p2021m06.p20210626;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 5:21 PM
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        return dfs(s, p);
    }


    private boolean dfs(String src, String pattern) {
        if (pattern.isEmpty()) {
            return src.isEmpty();
        }

        //是否第一个字符匹配
        boolean t1 = src.length() > 0 && pattern.length() > 0 &&
                (src.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.');

        //pattern是否后面含有跟一个*
        boolean t2 = pattern.length() > 1 && pattern.charAt(1) == '*';


        if (t1) {
            boolean b1 = dfs(src.substring(1), pattern.substring(1));
            if (b1) {
                return true;
            } else {
                if (t2) {
                    return dfs(src, pattern.substring(2)) || dfs(src.substring(1), pattern);
                } else {
                    return false;
                }
            }
        } else {
            if (t2) {
                return dfs(src, pattern.substring(2));
            } else {
                return false;
            }
        }

    }

    public static void main(String[] args) {
        Solution10 solution10 = new Solution10();



        boolean    ans        = solution10.isMatch("aaa", "a*");
        System.out.println(ans);
    }
}
