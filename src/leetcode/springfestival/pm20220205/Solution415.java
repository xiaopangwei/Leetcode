package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/5
 * @time 3:37 PM
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;


        int           carry         = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 && j >= 0) {

            int sum = num1.charAt(i) - '0' + num2.charAt(j) - '0' + carry;
            int a   = sum % 10;
            carry = sum / 10;
            stringBuilder.append(a);

            i--;
            j--;
        }

        while (i >= 0) {
            int sum = num1.charAt(i) - '0' + carry;
            int a   = sum % 10;
            carry = sum / 10;
            stringBuilder.append(a);
            i--;
        }

        while (j >= 0) {
            int sum = num2.charAt(j) - '0' + carry;
            int a   = sum % 10;
            carry = sum / 10;
            stringBuilder.append(a);
            j--;
        }

        if (carry != 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        String ans=solution415.addStrings("6", "501");
        System.out.println(ans);
    }
}
