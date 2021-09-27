package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/25
 * @time 11:15 PM
 */
public class Solution249 {
    public List<List<String>> groupStrings(String[] strings) {

        Map<String, List<String>> map = new HashMap<>();
        for (String item : strings) {
            String k = getKey(item);
            if (!map.containsKey(k)) {
                map.put(k, new ArrayList<>());
            }
            map.get(k).add(item);
        }

        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public String getKey(String key) {
        if (key.length() == 1) {
            return "0#1";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < key.length(); i++) {
            int delta = (key.charAt(i) - key.charAt(i - 1) + 26) % 26;
            builder.append(String.valueOf(delta));
            builder.append("#");
        }

        builder.append(String.valueOf(key.length()));

        return builder.toString();

    }

    public static void main(String[] args) {
        String[]           array       = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        Solution249        solution249 = new Solution249();
        List<List<String>> ans         = solution249.groupStrings(array);
        System.out.println(ans);
    }
}
