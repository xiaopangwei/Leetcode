package leetcode.p2022m05.day0501;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 3:18 PM
 */
public class Solution1239 {
    Map<String, Boolean> cached = new HashMap<>();

    int maxLen = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, new StringBuilder());
        return maxLen;
    }

    private void dfs(List<String> arr, int index, StringBuilder builder) {
        if (index == arr.size()) {
            return;
        }
        int prevLen = builder.length();
        builder.append(arr.get(index));
        //有两种方法，取或者不取
        if (match(builder)) {
            maxLen = Math.max(maxLen, builder.length());
            dfs(arr, index + 1, builder);
        }
        builder.setLength(prevLen);
        dfs(arr, index + 1, builder);

    }

    private boolean match(StringBuilder builder) {
        if (cached.containsKey(builder.toString())) {
            return cached.get(builder.toString());
        }
        int[] freq = new int[26];
        int   len  = builder.length();
        for (int i = 0; i < len; i++) {
            char c = builder.charAt(i);
            if (freq[c - 'a'] >= 1) {
                return false;
            } else {
                freq[c - 'a']++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1239 solution1239 = new Solution1239();
        int          ans          = solution1239.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
        System.out.println(ans);

    }
}
