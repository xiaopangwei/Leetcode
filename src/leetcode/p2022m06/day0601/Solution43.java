package leetcode.p2022m06.day0601;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 7:00 PM
 */
public class Solution43 {
    public String multiply(String num1, String num2) {
        int   m   = num1.length();
        int   n   = num2.length();
        int   len = m + n;
        int[] ans = new int[len];


        //125 * 34
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int low  = i + j + 1;
                int high = i + j;
                int prod = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + ans[low];
                ans[low] = prod % 10;
                ans[high] += prod / 10;
            }
        }
//        System.out.println(Arrays.toString(ans));

        int i = 0;
        while (i < ans.length && ans[i] ==0) {
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while (i < ans.length) {
            sb.append((char)(ans[i] + '0'));
            i++;
        }

        if (sb.length()==0){
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution43 solution43 = new Solution43();
        String ans=solution43.multiply("123", "456");
        System.out.println(ans);
    }
}
