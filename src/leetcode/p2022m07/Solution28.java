package leetcode.p2022m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/21
 * @time 9:51 PM
 */
public class Solution28 {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            int j   = 0;
            int idx = i;
            while (j < needle.length()) {
                if (haystack.charAt(idx) != needle.charAt(j)) {
                    break;
                }
                j++;
                idx++;
            }

            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int        ans        = solution28.strStr("hello", "ll");
        System.out.println(ans);
    }
}
