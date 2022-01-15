package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/11
 * @time 9:05 PM
 */
public class Solution1312 {
    Map<String, Integer> cached = new HashMap<>();

    public int minInsertions(String s) {

        int ans = 0;
//        ans = dfs(s.toCharArray(), 0, s.length() - 1);
        String t = help(s);
        System.out.println(t);
        return ans;
    }

    private int dfs(char[] array, int left, int right) {
        String key = left + "#" + right;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (left >= right) {
            return 0;
        }
        if (right - left == 1 && array[left] == array[right]) {
            return 0;
        }
        if (array[left] == array[right]) {
            return dfs(array, left + 1, right - 1);
        } else {
            int t1  = dfs(array, left + 1, right);
            int t2  = dfs(array, left, right - 1);
            int min = Math.min(t1, t2) + 1;
            cached.put(key, min);
            return min;
        }
    }


    private String help(String src) {
        if (src.length() <= 1) {
            return src;
        }
        char first = src.charAt(0);
        char last  = src.charAt(src.length() - 1);
        if (first == last) {
            return first + help(src.substring(1, src.length() - 1)) + last;
        } else {
            String t1 = first + help(src.substring(1, src.length())) + first;
            String t2 = last + help(src.substring(0, src.length() - 1)) + last;
            if (t1.length() > t2.length()) {
                return t2;
            } else {
                return t1;
            }
        }
    }

    public static void main(String[] args) {
        Solution1312 solution1312 = new Solution1312();
        int          temp         = solution1312.minInsertions("leetcode");
        System.out.println(temp);

    }
}
