package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/9
 * @time 10:46 PM
 */
public class Solution443 {
    public int compress(char[] chars) {

//        Arrays.sort(chars);
        int i = 0;
        int k = 0;
        while (i < chars.length) {

            int j = i + 1;
            while (j<chars.length && chars[j] == chars[i]) {
                j++;
            }

            int len = j - i;
            if (len >= 2) {
                chars[k++] = chars[i];
                char[] charArray=String.valueOf(len).toCharArray();
                for (char item:charArray){
                    chars[k++]=item;
                }
            } else {
                chars[k++] = chars[i];
            }

            i = j;
        }

        for (int tt = 0; tt < k; tt++) {
            System.out.println(chars[tt]);
        }
        return k;
    }

    public static void main(String[] args) {
        Solution443 solution443 = new Solution443();
        String      str         = "aaabbaa";
        int         length      = solution443.compress(str.toCharArray());
        System.out.println(length);
    }
}
