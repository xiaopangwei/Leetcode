package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/3
 * @time 3:26 PM
 */
public class Solution1796 {
    public int secondHighest(String s) {
        int firstHighest  = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                continue;
            }
            int temp = s.charAt(i) - '0';
            if (temp > firstHighest) {
                secondHighest = firstHighest;
                firstHighest = temp;
            } else if (temp > secondHighest && temp<firstHighest) {
                secondHighest = temp;
            }
        }
        if (secondHighest == Integer.MIN_VALUE) {
            return -1;
        }
        return secondHighest;
    }

    public static void main(String[] args) {
        Solution1796 solution1796 = new Solution1796();
        System.out.println(solution1796.secondHighest("abc1111"));
    }
}
