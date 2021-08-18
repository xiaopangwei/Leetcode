package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 9:50 AM
 */
public class Solution552 {

    private int maxVal = 1000000007;

    long[][][] cache;

    public int checkRecord(int n) {
        cache = new long[n][3][2];
        return (int) (dfs(n, 0, 0, 0, new ArrayList<>())%maxVal);

    }

    private long dfs(final int n, int index, int late, int absent, List<String> temp) {
        if (index >= n) {
//            System.out.println(temp);
            return 1;
        }

        if (cache[index][late][absent] != 0) {
            return cache[index][late][absent];
        }
        long ans = 0;
        //P
//        temp.add("P");
        ans += dfs(n, index + 1, 0, absent, temp);
        ans=ans%maxVal;
//        temp.remove(temp.size() - 1);

        //A
//        temp.add("A");
        if (absent < 1) {
            ans += dfs(n, index + 1, 0, absent + 1, temp);
            ans=ans%maxVal;
        }
//        temp.remove(temp.size() - 1);
        //L
//        temp.add("L");
        if (late < 2) {
            ans += dfs(n, index + 1, late + 1, absent, temp);
            ans=ans%maxVal;
        }
//        temp.remove(temp.size() - 1);

        cache[index][late][absent] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Solution552 solution552 = new Solution552();
        int         n           = -1;
        n = solution552.checkRecord(3);
        System.out.println(n);
    }
}
