package leetcode.p2022m05.day0502;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 4:22 PM
 */
public class Solution403 {

    int[] delta = new int[]{-1, 0, 1};
    Map<String,Boolean> cached=new HashMap<>();

    public boolean canCross(int[] stones) {
        List<Integer> stoneList = new ArrayList<>();
        for (int item : stones) {
            stoneList.add(item);
        }
        return dfs(stoneList, 0, 0);
    }

    private boolean dfs(List<Integer> stones, int lastStep, int pos) {
        String biKey=lastStep+"#"+pos;
        if (cached.containsKey(biKey)){
            return cached.get(biKey);
        }
        if (pos > stones.get(stones.size() - 1)) {
            return false;
        }
        if (pos == stones.get(stones.size() - 1)) {
            return true;
        }
        if (!stones.contains(pos)) {
            return false;
        }
        for (int item : delta) {
            int newPos = pos + lastStep + item;
            if (newPos <= pos || newPos < 0 || newPos>stones.get(stones.size()-1)) {
                continue;
            }
//            selected.add(newPos);
            if (dfs(stones, lastStep + item, newPos)) {
                cached.put(biKey,true);
                return true;
            }
//            selected.remove(selected.size() - 1);
        }
        cached.put(biKey,false);
        return false;
    }

    public static void main(String[] args) {
        Solution403 solution403 = new Solution403();
        boolean     ans         = solution403.canCross(new int[]{0,1,2,3,4,8,9,11});
        System.out.println(ans);
    }
}
