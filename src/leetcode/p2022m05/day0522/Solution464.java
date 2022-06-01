package leetcode.p2022m05.day0522;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/22
 * @time 10:09 AM
 */
public class Solution464 {
    Map<Integer, Boolean> cached = new HashMap<>();
    boolean[] visited;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int t = maxChoosableInteger * (1 + maxChoosableInteger) / 2;
        if (t < desiredTotal) {
            return false;
        }
        visited = new boolean[maxChoosableInteger + 1];
        return dfs(maxChoosableInteger, desiredTotal, 0);
    }


    //先手稳赢的意思是指存在先手选择一个数后，后手一定会输。
    private boolean dfs(final int maxChoosableInteger, final int desiredTotal, int sum) {
        int biKey = convert(visited);
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }

        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (visited[i]) {
                continue;
            }
            if (sum + i >= desiredTotal) {
                cached.put(biKey, true);
                return true;
            }
            visited[i] = true;
            boolean flag = dfs(maxChoosableInteger, desiredTotal, sum + i);
            if (!flag) {
                //TODO
                visited[i]=false;
                cached.put(biKey, true);
                return true;
            }
            visited[i] = false;
        }
        cached.put(biKey, false);
        return false;
    }


    public int convert(boolean[] visited) {
        int num = 0;
        int cnt = 1;
        for (int i = visited.length - 1; i >= 0; i--) {
            if (visited[i]) {
                num += cnt;
            }
            cnt <<= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution464 solution464 = new Solution464();
        int         num         = solution464.convert(new boolean[]{true, false, false, true});
        System.out.println(num);
        boolean ans = solution464.canIWin(10, 0);
        System.out.println(ans);
    }

}
