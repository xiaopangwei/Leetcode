package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 2:31 PM
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        int                     n    = s1.length();
        for (int i = 0; i < n; i++) {
            char ch1 = s1.charAt(i);
            freq.put(ch1, freq.getOrDefault(ch1, 0) + 1);
            char ch2 = s2.charAt(i);
            tMap.put(ch2, tMap.getOrDefault(ch2, 0) + 1);
        }

        if (freq.equals(tMap)) {
            return true;
        }

        int right = n;


        while (right < s2.length()) {

            char t1 = s2.charAt(right);
            tMap.put(t1, tMap.getOrDefault(t1, 0) + 1);
            right++;


            int  left = right-1 - n;
            char t2   = s2.charAt(left);
            int  f    = tMap.get(t2) - 1;
            if (f > 0) {
                tMap.put(t2, f);
            } else {
                tMap.remove(t2);
            }


            if (freq.equals(tMap)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        boolean     ans         = solution567.checkInclusion("adc", "dcda");
        System.out.println(ans);
    }
}
