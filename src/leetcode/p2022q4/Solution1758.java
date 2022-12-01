package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/29
 * @time 9:15 PM
 */
public class Solution1758 {
    public int minOperations(String s) {
        char x    = 0;
        int  cnt1 = 0;
        int  cnt2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (x != s.charAt(i)-'0') {
                cnt1++;
            } else {
                cnt2++;
            }

            x ^= 1;
        }

        return Math.min(cnt1, cnt2);
    }

    public static void main(String[] args){
        Solution1758 solution1758=new Solution1758();
        System.out.println(solution1758.minOperations("1111"));
    }
}
