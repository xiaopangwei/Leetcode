package leetcode.p2022m06.day0628;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/28
 * @time 8:33 PM
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        int                  len      = words.length * words[0].length();
        int                  sliceLen = words[0].length();
        Map<String, Integer> freq     = new HashMap<>();
        for (String item : words) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }
        List<Integer> ans  = new ArrayList<>();
        int           left = 0;
        while (left < s.length()) {
            int right = left + len - 1;
            if (right >= s.length()) {
                break;
            }
            Map<String, Integer> tempFreq = new HashMap<>();
            for (int i = left; i <= right; i += sliceLen) {
                if (i + sliceLen > s.length()) {
                    break;
                }
                String sub = s.substring(i, i + sliceLen);
                tempFreq.put(sub, tempFreq.getOrDefault(sub, 0) + 1);
            }
            if (tempFreq.equals(freq)) {
                ans.add(left);
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution30    solution30 = new Solution30();
        List<Integer> ans        = solution30.findSubstring("a", new String[]{"a"});
        System.out.println(ans);
    }
}
