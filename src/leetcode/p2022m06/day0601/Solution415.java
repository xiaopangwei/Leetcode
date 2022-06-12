package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 7:26 PM
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int           i     = num1.length() - 1;
        int           j     = num2.length() - 1;
        int           carry = 0;
        StringBuilder sb    = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int s = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            carry = s / 10;
            sb.append((char) (s % 10 + '0'));
            i--;
            j--;
        }
        while (i >= 0) {
            int s = num1.charAt(i) - '0' + carry;
            carry = s / 10;
            sb.append((char) (s % 10 + '0'));
            i--;
        }
        while (j >= 0) {
            int s = num2.charAt(j) - '0' + carry;
            carry = s / 10;
            sb.append((char) (s % 10 + '0'));
            j--;
        }

        if (carry != 0) {
            sb.append((char) (carry + '0'));
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args){
        Solution415 solution415=new Solution415();
        String ans=solution415.addStrings("999","999");
        System.out.println(ans);
    }
}
