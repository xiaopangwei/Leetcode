package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/18
 * @time 10:23 PM
 */
public class Solution567 {

    public boolean checkInclusion(String s1, String s2) {

        Map<Character, Integer> stdFreq = new HashMap<>();
        int                     len     = s1.length();
        for (int i = 0; i < len; i++) {
            char ch = s1.charAt(i);
            stdFreq.put(ch, stdFreq.getOrDefault(ch, 0) + 1);
        }
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < len; i++) {
            freq.put(s2.charAt(i), freq.getOrDefault(s2.charAt(i), 0) + 1);
        }
        if (stdFreq.equals(freq)) {
            return true;
        }

        for (int i = len; i < s2.length(); i++) {
            char rightChar = s2.charAt(i);
            char leftChar  = s2.charAt(i - len);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            int temp=freq.getOrDefault(leftChar, 0)-1;
            if (temp<=0){
                freq.remove(leftChar);
            }else {
                freq.put(leftChar, temp);
            }
            if (stdFreq.equals(freq)) {
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
