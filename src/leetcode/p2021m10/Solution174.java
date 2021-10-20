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
 * @time 9:38 PM
 */
public class Solution174 {
    int ans = Integer.MAX_VALUE;

    Map<String,Integer> cached=new HashMap<>();
    int[][] directions = new int[][]{{1, 0}, {0, 1}};

    public int calculateMinimumHP(int[][] dungeon) {

        int   m     = dungeon.length;
        int   n     = dungeon[0].length;
        int[] start = new int[]{0, 0};
        int[] end   = new int[]{m - 1, n - 1};

        if (m==1 && n==1){
            if (dungeon[0][0]>0){
                return 1;
            }else{
                return Math.abs(dungeon[0][0])+1;
            }
        }

        int ans = dfs(dungeon, start, end, 0, dungeon[0][0], dungeon[0][0], new ArrayList<>());
        if (ans > 0) {
            return 1;
        } else {
            return Math.abs(ans) + 1;
        }
    }

    private int dfs(final int[][] dungeon, int[] start, int[] target, int depth, int prefixSum, int minCurrentPrefixSum, List<int[]> temp) {

        String key=start[0]+"#"+start[1]+"#"+prefixSum+"#"+minCurrentPrefixSum;
        if (cached.containsKey(key)){
            return cached.get(key);
        }
        if (start[0] == target[0] && start[1] == target[1]) {
            return Math.min(minCurrentPrefixSum, prefixSum);
        }
//        System.out.println(Arrays.toString(start));
        int t = Integer.MAX_VALUE;
        for (int i = 0; i < directions.length; i++) {
            int newX = directions[i][0] + start[0];
            int newY = directions[i][1] + start[1];

            if (newX < 0 || newY < 0 || newX >= dungeon.length || newY >= dungeon[0].length) {
                continue;
            }

            int newPrefixSum           = prefixSum + dungeon[newX][newY];
            int newMinCurrentPrefixSum = Math.min(newPrefixSum, minCurrentPrefixSum);

            temp.add(new int[]{start[0], start[1]});
            int res = dfs(dungeon, new int[]{newX, newY}, target, depth + 1, newPrefixSum, newMinCurrentPrefixSum, temp);
            if (res > 0) {
                return res;
            } else {
                t = -Math.min(Math.abs(res), Math.abs(t));
            }
            temp.remove(temp.size() - 1);

        }
        cached.put(key,t);
        return t;
    }

    public static void main(String[] args) {

        int[][]     arr         = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        Solution174 solution174 = new Solution174();
        int         ans         = solution174.calculateMinimumHP(arr);
        System.out.println(ans);
    }

}
