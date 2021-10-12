package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/10
 * @time 2:39 PM
 */
public class Solution392 {
    public boolean isSubsequence(String s, String t) {

        int j = 0;
        for (int i = 0; i < s.length(); i++) {


            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }
            if (j == t.length()) {
                return false;
            }

            j++;
        }

        return true;
    }

    public static void main(String[] args) {

        Solution392 solution392=new Solution392();
        boolean ans=solution392.isSubsequence("abh","ahbgdc");
        System.out.println(ans);
    }
}
