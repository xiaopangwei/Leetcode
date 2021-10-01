package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/30
 * @time 11:16 PM
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {

        String temp = s + s;
        int    len  = temp.length();
        String sub  = s.substring(1, len - 1);
        if (sub.contains(s)) {
            return true;
        }
        return false;
    }
}
