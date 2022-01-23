package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/22
 * @time 10:55 PM
 */
public class Solution43 {

    public String multiply(String num1, String num2) {

        int[] res = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {

            int t = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int digit = num2.charAt(j) - '0';

                int product = t * digit;

                int idx1 = i + j;
                int idx2 = idx1 + 1;

                int lowerProduct = res[idx2] + product;

                res[idx2] = lowerProduct % 10;
                res[idx1] = (res[idx1] + lowerProduct / 10);

            }
        }

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }

        while (i < res.length) {
            stringBuilder.append(res[i]);
            i++;
        }

        if (stringBuilder.length()==0){
            return "0";
        }

        return stringBuilder.toString();
    }

    //498828660196
    //840477629533
    //9223372036854775807
    //419254329864656431168468
    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String     ans        = solution43.multiply("498828660196", "840477629533");
        System.out.println(ans);
    }
}
