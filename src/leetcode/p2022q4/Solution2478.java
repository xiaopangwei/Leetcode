package leetcode.p2022q4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/21
 * @time 9:02 PM
 */
public class Solution2478 {
    int k;
    int minLen;
    int mod = 1000000007;

    List<Integer> primeList = Arrays.asList(2, 3, 5, 7);

    public int beautifulPartitions(String s, int k, int minLength) {
        this.k = k;
        this.minLen = minLength;
        if (k == 1) {
            if (s.length() >= minLength &&
                    primeList.contains(s.charAt(0) - '0') &&
                    !primeList.contains(s.charAt(s.length() - 1) - '0')) {
                return 1;
            }
            return 0;
        }
        return (int) dfs(s, 0, new ArrayList<>());
    }

    private long dfs(String s, int startIndex, List<String> list) {

        if (startIndex >= s.length() && list.size() == k) {
            System.out.println(list);
            return 1;
        }
        if (list.size() > k || startIndex >= s.length()) {
            return 0;
        }
        long ans = 0;
        for (int i = minLen; i < s.length(); i++) {
            int endIndex = startIndex + i - 1;
            if (endIndex >= s.length()) {
                continue;
            }
            if (!primeList.contains(s.charAt(startIndex) - '0')) {
                continue;
            }
            if (primeList.contains(s.charAt(endIndex) - '0')) {
                continue;
            }
            list.add(s.substring(startIndex, endIndex + 1));
            ans += dfs(s, endIndex + 1, list);
            ans %= mod;
            list.remove(list.size() - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2478 solution2478 = new Solution2478();

        System.out.println(solution2478.beautifulPartitions("242538614532395749146912679859", 1, 6));
    }
}
