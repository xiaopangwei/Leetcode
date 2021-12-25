package leetcode.p2021m12;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 4:00 PM
 */
public class Solution877 {
    Map<String,Integer> cached=new HashMap<>();
    public boolean stoneGame(int[] piles) {

        int ans=dfs(piles,0,piles.length-1);
        if (ans>0){
            return true;
        }else{
            return false;
        }
    }

    private int dfs(int[] piles, int left, int right) {
        String key=left+"#"+right;
        if (cached.containsKey(key)){
            return cached.get(key);

        }
        if (left == right) {
            return piles[left];
        }

        int d1   = piles[left] - dfs(piles, left + 1, right);
        int d2   = piles[right] - dfs(piles, left, right - 1);
        int t= Math.max(d1, d2);
        cached.put(key,t);
        return t;
    }

    public static void main(String[] args){
        Solution877 solution877=new Solution877();
        boolean ans=solution877.stoneGame(new int[]{3,7,2,3});
        System.out.println(ans);
    }
}
