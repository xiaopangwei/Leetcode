package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/15
 * @time 4:50 PM
 */
public class Solution186 {
    public void reverseWords(char[] s) {
        //reverse
        reverse(s, 0, s.length - 1);

        int idx = 0;

        while (idx < s.length) {
            int sIndex = idx;
            while (sIndex < s.length && s[sIndex] != ' ') {
                sIndex++;
            }
            reverse(s, idx, sIndex - 1);
            idx = sIndex + 1;
        }

    }

    public void reverse(char[] s, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution186 solution186=new Solution186();
        char[] array=new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        solution186.reverseWords(array);
        System.out.println(Arrays.toString(array));
    }
}
