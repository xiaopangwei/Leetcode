package leetcode.p2022m02;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 3:21 PM
 */
public class Solution474 {
    Map<String, Integer> cached = new HashMap<>();

    public int findMaxForm(String[] strs, int m, int n) {
        Map<Integer, int[]> freq = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            freq.put(i, statFreq(strs[i]));
        }
        return dfs(freq, 0, m, n, 0, 0);
    }

    private int dfs(Map<Integer, int[]> freq, int index, int m, int n, int count0, int count1) {
        String key = index + "#" + count0 + "#" + count1;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index == freq.size()) {
            return 0;
        }
        int[] temp = freq.get(index);
        int   ans  = dfs(freq, index + 1, m, n, count0, count1);
        if (count0 + temp[0] <= m && count1 + temp[1] <= n) {
            ans = Math.max(dfs(freq, index + 1, m, n, count0 + temp[0], count1 + temp[1])+1, ans);
        }
        cached.put(key, ans);
        return ans;
    }

    private int[] statFreq(String s) {
        int[] ans = new int[2];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            ans[ch - '0']++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution474 solution474 = new Solution474();
        int         ans         = solution474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        System.out.println(ans);

    }
}
