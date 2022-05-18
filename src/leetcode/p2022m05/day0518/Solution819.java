package leetcode.p2022m05.day0518;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/18
 * @time 8:00 PM
 */
public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        List<String> bannedList = new ArrayList<>();
        for (String item : banned) {
            bannedList.add(item);
        }
        Map<String, Integer> freq    = new HashMap<>();
        int                  i       = 0;
        int                  maxFreq = Integer.MIN_VALUE;
        String               s       = null;
        while (i < paragraph.length()) {
            char ch = paragraph.charAt(i);
            //!?',;.
            if (!isAlpha(ch)) {
                i++;
                continue;
            }
            int j = i + 1;
            while (j < paragraph.length() && isAlpha(paragraph.charAt(j))) {
                j++;
            }
            String temp = paragraph.substring(i, j).toLowerCase();
            int    t    = freq.getOrDefault(temp, 0) + 1;
            freq.put(temp, t);

            if (t > maxFreq && !bannedList.contains(temp)) {
                s = temp;
                maxFreq = t;
            }
            i = j;
        }
        return s;
    }

    private boolean isAlpha(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution819 solution819 = new Solution819();
        String      s           = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String      ans         = solution819.mostCommonWord(s, new String[]{"ball"});
        System.out.println(ans);

    }
}
