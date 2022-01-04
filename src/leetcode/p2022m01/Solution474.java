package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/2
 * @time 11:06 AM
 */
public class Solution474 {
    Map<String, Integer> cached = new HashMap<>();

    public int findMaxForm(String[] strs, int m, int n) {

        return dfs(0, strs, m, n, 0, 0);
    }

    private int dfs(int index, String[] strs, int m, int n, int count0, int count1) {
        String triKey = index + "#" + count0 + "#" + count1;
        if (cached.containsKey(triKey)) {
            return cached.get(triKey);
        }
        if (index == strs.length) {
            return 0;
        }

        int[] freq = getCountArr(strs[index]);

        int t1 = 0;
        int t2 = 0;
        if (count0 + freq[0] > m || count1 + freq[1] > n) {
            //不选
            t1 = dfs(index + 1, strs, m, n, count0, count1);
        } else {
            t1 = dfs(index + 1, strs, m, n, count0, count1);
            //选
            t2 = dfs(index + 1, strs, m, n, count0 + freq[0], count1 + freq[1]) + 1;
        }

        int ans = Math.max(t1, t2);
        cached.put(triKey, ans);
        return ans;
    }

    private int[] getCountArr(String str) {
        int[] freq = new int[2];
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                freq[0]++;
            } else {
                freq[1]++;
            }
        }
        return freq;
    }

    public static void main(String[] args) {
        Solution474 solution474 = new Solution474();
        int         count       = solution474.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
        System.out.println(count);
    }
}
