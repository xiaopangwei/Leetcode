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
 * @date 2021/9/17
 * @time 9:33 PM
 */
public class Solution294 {
    Map<String, Boolean> cached = new HashMap<>();

    public boolean canWin(String currentState) {
        return dfs(currentState);

    }

    private boolean dfs(String currentState) {
        if (cached.containsKey(currentState)) {
            return cached.get(currentState);
        }
        List<String> candidates = generatePossibleNextMoves(currentState);



        for (String next : candidates) {

            boolean flag = dfs(next);

            if (!flag) {
                cached.put(currentState, true);
                return true;
            }
        }
        cached.put(currentState, false);
        return false;

    }

    public List<String> generatePossibleNextMoves(String currentState) {
        List<String> ans      = new ArrayList<>();
        char[]       template = currentState.toCharArray();
        for (int i = 0; i < currentState.length() - 1; i++) {
            if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
                char[] array = template.clone();
                array[i] = '-';
                array[i + 1] = '-';
                ans.add(new String(array));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution294 solution294 = new Solution294();
        boolean     ans         = solution294.canWin("++++");
        System.out.println(ans);
    }
}
