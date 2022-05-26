package leetcode.p2022m05.day0513;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/13
 * @time 11:06 PM
 */
public class Solution1044 {

    int factor = 31;

    public String longestDupSubstring(String s) {
        int left  = 0;
        int right = s.length() - 1;

        String ans = "";
        while (left <= right) {
            int    mid  = left + (right - left) / 2;
            String temp = check(s, mid);
            if (temp == null) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = temp;
            }
        }
        return ans;
    }


    public String check(String s, int len) {
        System.out.println(len);
        Set<Long> set  = new HashSet<>();
        int       i    = 0;
        long      h    = 0;
        long      base = 1;
        while (i < len) {
            h = h * factor + s.charAt(i);
            base *= factor;
            i++;
        }
        set.add(h);
        while (i < s.length()) {
            h = h * factor + s.charAt(i);
            h -= base * (s.charAt(i - len));
            if (set.contains(h)) {
                return s.substring(i - len + 1, i + 1);
            }
            set.add(h);
            i++;
        }
        return null;
    }

    public static void main(String[] args) {
//        Solution1044 solution1044 = new Solution1044();
//        String       ans          = solution1044.longestDupSubstring("aa");


        String temp = "bae";

        int  i      = 0;
        long h      = 0;
        long base   = 1;
        int  factor = 31;
        while (i < temp.length()) {
            h = h * factor + temp.charAt(i);
            base *= factor;
            i++;
        }
        System.out.println(h);
        System.out.println(base);
    }
}
