package leetcode.p2022m05.day0509;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/9
 * @time 8:07 PM
 */
public class Solution67 {
    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        int           i  = a.length() - 1;
        int           j  = b.length() - 1;

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int s = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
            if (s % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = s / 2;

            i--;
            j--;
        }

        while (i >= 0) {
            int s = (a.charAt(i) - '0') + carry;
            if (s % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = s / 2;
            i--;
        }

        while (j >= 0) {
            int s = (b.charAt(j) - '0') + carry;
            if (s % 2 == 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            carry = s / 2;
            j--;
        }

        if (carry != 0) {
            sb.append("1");
        }

        StringBuilder newStr = sb.reverse();

        int t = 0;
        while (t < newStr.length() && newStr.charAt(t) == '0') {
            t++;
        }

        if (t == newStr.length()) {
            return "0";
        } else {
            return newStr.substring(t);
        }
    }

    public static void main(String[] args){
        Solution67 solution67=new Solution67();
        String ans=solution67.addBinary("1","111");
        System.out.println(ans);
    }
}
