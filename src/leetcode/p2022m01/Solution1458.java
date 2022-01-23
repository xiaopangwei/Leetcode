package leetcode.p2022m01;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/23
 * @time 7:51 PM
 */
public class Solution1458 {
    int[] num1;
    int[] num2;

    Map<String, Integer> cached = new HashMap<>();

    public int maxDotProduct(int[] nums1, int[] nums2) {
        this.num1 = nums1;
        this.num2 = nums2;

        return dfs(0, 0);
    }

    private int dfs(int idx1, int idx2) {
        String key = idx1 + "#" + idx2;
        if (cached.containsKey(key)) {
            return cached.get(key);
        }
        if (idx1 >= num1.length || idx2 >= num2.length) {
            return -100001;
        }

        int t = num1[idx1] * num2[idx2];

        int a = dfs(idx1 + 1, idx2 + 1);
        int b = t;
        int c = dfs(idx1 + 1, idx2 + 1) + t;

        int t1 = Math.max(a, Math.max(b, c));
        int t2 = dfs(idx1, idx2 + 1);
        int t3 = dfs(idx1 + 1, idx2);

        int ans = Math.max(t1, Math.max(t2, t3));
        cached.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        //nums1 = [2,1,-2,5], nums2 = [3,0,-6]
        //[-1,-1], nums2 = [1,1]
        int[] num1 = new int[]{-1};
        int[] num2 = new int[]{2};
//[3,-2], nums2 = [2,-6,7]
//        int[]        num1         = new int[]{-1, -1};
//        int[]        num2         = new int[]{1, 1};
        Solution1458 solution1458 = new Solution1458();
        int          ans          = solution1458.maxDotProduct(num1, num2);
        System.out.println(ans);
    }
}
