package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 11:35 AM
 */
public class Solution1221 {
    public int balancedStringSplit(String s) {
        int i     = 0;
        int temp  = 0;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'L') {
                temp++;
            } else {
                temp--;
            }

            if (temp == 0) {
                count++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1221 solution1221 = new Solution1221();
        String       src          = "RLRRRLLRLL";
        int          ans          = solution1221.balancedStringSplit(src);
        System.out.println(ans);
    }
}
