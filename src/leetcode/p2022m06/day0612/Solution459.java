package leetcode.p2022m06.day0612;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 8:59 PM
 */
public class Solution459 {
    public boolean repeatedSubstringPattern(String s) {
        Set<String> sets = new HashSet<>();
        for (int i = 1; i < s.length(); i++) {
            if (s.length() % i != 0) {
                continue;
            }
            sets.clear();
            for (int j = 0; j < s.length(); j += i) {
                String temp = s.substring(j, j + i);
                sets.add(temp);
            }

            if (sets.size() == 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution459 solution459 = new Solution459();
        boolean     ans         = solution459.repeatedSubstringPattern("aba");
        System.out.println(ans);
    }
}
