package leetcode.p2021m10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/20
 * @time 8:50 PM
 */
public class Solution403 {
    Map<Integer, Integer> map = new HashMap<>();

    Map<String, Boolean> cached = new HashMap<>();

    public boolean canCross(int[] stones) {
        if (stones[0] + 1 != stones[1]) {
            return false;
        }
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], i);
        }
        List<Integer> data = new ArrayList<>();

        boolean ans = dfs(0, stones, 1, 0, data);
        return ans;
    }

    private boolean dfs(int index, final int[] stone, int prev, int times, List<Integer> temp) {

        String key = index + "#" + prev;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (index == stone.length - 1) {
            return true;
        }

        if (index >= stone.length) {
            return false;
        }

        if (times == 0) {
            if (index + 1 < stone.length && stone[index] + 1 == stone[index + 1]) {

                boolean t = dfs(index + 1, stone, prev, times + 1, temp);
                cached.put(key, t);
                return t;
            } else {
                cached.put(key, false);
                return false;
            }
        } else {

            int[] steps = new int[]{prev - 1, prev, prev + 1};
            for (int i = 0; i < steps.length; i++) {
                if (steps[i] == 0) {
                    continue;
                }
                int newPos = steps[i] + stone[index];
                if (map.containsKey(newPos) && map.get(newPos) > index) {
                    temp.add(steps[i]);
                    boolean flag = dfs(map.get(newPos), stone, steps[i], times + 1, temp);
                    if (flag) {
                        temp.remove(temp.size() - 1);
                        cached.put(key, true);
                        return true;
                    } else {
                        temp.remove(temp.size() - 1);
                    }


                }

            }
        }
        cached.put(key, false);
        return false;

    }

    public static void main(String[] args) {
        Solution403 solution403 = new Solution403();
        boolean     ans         = solution403.canCross(new int[]{0,1,2,3,4,8,9,11});
        System.out.println(ans);
    }
}
