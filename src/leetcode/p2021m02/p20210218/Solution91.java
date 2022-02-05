package leetcode.p2021m02.p20210218;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution91 {


    private Map<Integer, Integer> cached = new HashMap<>();

    public int numDecodings(String s) {

        return dfs(s.toCharArray(), 0);
    }

    private int dfs(char[] array, int start) {
        int key = start;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (start >= array.length) {
            cached.put(key, 1);
            return 1;
        }

        if (array[start] == '0') {
            cached.put(start, 0);
            return 0;
        }


        int ans = dfs(array, start + 1);

        if (start + 2 <= array.length) {
            char ch = array[start];
            if (ch == '1' ||
                    (ch == '2' && array[start + 1] <= '6' && array[start + 1] >= '0')) {
                ans += dfs(array, start + 2);
            }
        }
        cached.put(start, ans);
        return ans;
    }


    public static void main(String[] args) {
        Solution91 solution38 = new Solution91();
//        System.out.println(solution38.numDecodings("2"));
//        System.out.println(solution38.numDecodings("02"));
//        System.out.println(solution38.numDecodings("12"));
        System.out.println(solution38.numDecodings(
                "1212121"));

//        System.out.println(solution38.numDecodingsStand("22623"));

    }


}
