package leetcode.p2021m12;


import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/9
 * @time 8:39 PM
 */
public class Solution1155 {
    long maxVal=1000000007;
    Map<String,Long> cached=new HashMap<>();
    public int numRollsToTarget(int d, int f, int target) {

        return dfs(0,f,target,d);
    }

    private int dfs(int idx, final int f, int target, final int d) {

        String biKey=idx+"#"+target;
        if (cached.containsKey(biKey)){
            return (int)(cached.get(biKey)%maxVal);
        }
        if (idx > d || target < 0) {
            return 0;
        }

        if (idx == d && target == 0) {
            return 1;
        }

        long ans=0;

        for (int i = 1; i <= f; i++) {
            ans+=dfs(idx + 1, f, target - i, d);
        }

        cached.put(biKey,ans%maxVal);
        return (int)(ans%maxVal);
    }

    public static void main(String[] args){
        Solution1155 solution1155=new Solution1155();
        int ans=solution1155.numRollsToTarget(30,30,500);
        System.out.println(ans);
    }
}
