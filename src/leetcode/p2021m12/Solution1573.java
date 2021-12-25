package leetcode.p2021m12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/20
 * @time 8:49 PM
 */
public class Solution1573 {
    public int numWays(String s) {

        long            count = 0;
        Map<Long, Long> map   = new HashMap<>();
        long             len   = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                count++;
                map.put(count, (long) i);
            }

        }
        if (count % 3 != 0) {
            return 0;
        }


        if (count == 0) {
            long a=len - 1;
            return (int)(a%1000000007 * ((a - 1)%1000000007) / 2) % 1000000007;
        }

        long avg = count / 3;
        long a   = map.get(avg + 1) - map.get(avg);

        long b = map.get(count - avg + 1) - map.get(count - avg);


        return (int) (a * b % (1000000007));
    }

    private int dfs(String s, int index, final int ones, List<String> list) {
        if (s.length() == 0 && index == 3) {
            System.out.println(list);
            return 1;
        }
        if (s.length() == 0 || index == 3) {
            return 0;
        }
        int len   = s.length();
        int count = 0;
        int cnt   = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
                if (cnt == ones) {
                    String temp = s.substring(i + 1);
                    list.add(s.substring(0, i + 1));
                    int t = dfs(temp, index + 1, ones, list);
                    list.remove(list.size() - 1);
                    count += t;
                }
            } else {
                if (cnt == ones) {
                    String temp = s.substring(i + 1);
                    list.add(s.substring(0, i + 1));
                    int t = dfs(temp, index + 1, ones, list);
                    list.remove(list.size() - 1);
                    count += t;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution1573 solution1573 = new Solution1573();
        int          ans          = solution1573.numWays("10101");
        System.out.println(ans);
    }
}
