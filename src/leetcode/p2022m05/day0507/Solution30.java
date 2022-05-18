package leetcode.p2022m05.day0507;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 10:39 PM
 */
public class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : words) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int           len   = words[0].length();
        int           total = len * words.length;
        List<Integer> ans   = new ArrayList<>();
        int           start = 0;
        while (start < s.length()) {
            Map<String, Integer> hit  = new HashMap<>();
            boolean              flag = true;
            for (int i = 0; i < total; i += len) {
                if (start + i + len > s.length()) {
                    continue;
                }
                String temp = s.substring(start + i, start + i + len);
                if (!map.containsKey(temp)) {
                    flag = false;
                    break;
                } else {
                    hit.put(temp, hit.getOrDefault(temp, 0) + 1);
                }
            }
            if (!flag) {
                start++;
            } else {
                if (hit.equals(map)) {
                    ans.add(start);
                }
                start++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution30    solution30 = new Solution30();
        List<Integer> list       = solution30.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"});
        System.out.println(list);
    }
}
