package leetcode.p2021m09;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/16
 * @time 8:35 PM
 */
public class Solution266 {
    public boolean canPermutePalindrome(String s) {

        int length = s.length();
        if (length <= 1) {
            return true;
        }
        Map<Character, Integer> freq  = new HashMap<>();
        char[]                  array = s.toCharArray();
        for (char item : array) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution266 solution266 = new Solution266();
        boolean     ans         = solution266.canPermutePalindrome("ab");
        System.out.println(ans);
    }
}
