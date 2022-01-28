package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/24
 * @time 10:14 PM
 */
public class Solution20 {

    //错误的方法
    public boolean isValid(String s) {

        int zeros = 0;
        int ones  = 0;
        int twos  = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                zeros++;
            } else if (ch == '[') {
                ones++;
            } else if (ch == '{') {
                twos++;
            } else if (ch == ')') {
                if (zeros > 0) {
                    zeros--;
                } else {
                    return false;
                }
            } else if (ch == ']') {
                if (ones > 0) {
                    ones--;
                } else {
                    return false;
                }
            } else if (ch == '}') {
                if (twos > 0) {
                    twos--;
                } else {
                    return false;
                }
            }
        }


        return ones == 0 && twos == 0 && zeros == 0;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        boolean    flag       = solution20.isValid("([)]");
        System.out.println(flag);
    }
}
