package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/18
 * @time 1:14 PM
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = 1; len <= s.length() / 2; len++) {

            if (s.length() % len != 0) {
                continue;
            }
            for (int i = 0; i < len; i++) {

                boolean flag = true;
                int     j    = i + len;

                int index = i;
                while (j < s.length()) {
                    System.out.println(index+" "+j);
                    if (s.charAt(index) == s.charAt(j)) {
                        j++;
                        index++;
                    } else {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return true;
                } else {
                    break;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Solution459 solution459 = new Solution459();
        boolean     ans         = solution459.repeatedSubstringPattern("abcabcabcabc");
        System.out.println(ans);
    }
}
