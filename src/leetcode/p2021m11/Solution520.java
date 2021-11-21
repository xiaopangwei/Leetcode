package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 1:58 PM
 */
public class Solution520 {
    public boolean detectCapitalUse(String word) {

        if (word.length() == 1) {
            return true;
        }

        boolean flag = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        if (flag) {
            boolean a = word.charAt(1) >= 'A' && word.charAt(1) <= 'Z';
            for (int i = 2; i < word.length(); i++) {
                char    ch = word.charAt(i);
                boolean f  = (ch >= 'A' && ch <= 'Z');
                if (f != a) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                char    ch = word.charAt(i);
                boolean f  = (ch >= 'a' && ch <= 'z');
                if (!f) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution520 solution520 = new Solution520();
        boolean     ans         = solution520.detectCapitalUse("Flag");
        System.out.println(ans);
    }
}
