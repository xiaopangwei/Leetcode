package leetcode.p2022q4;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/28
 * @time 8:22 PM
 */
public class Solution813 {
    int[] nums;
    Map<String, Double> cached = new HashMap<>();

    public double largestSumOfAverages(int[] nums, int k) {
        this.nums = nums;
        return dfs(0, k);
    }

    private double dfs(int index, int k) {
        String biKey = index + "#" + k;
        if (k == 1) {
            int sum = 0;
            for (int i = index; i < nums.length; i++) {
                sum += nums[i];
            }
            return (double) sum / (nums.length - index);
        }
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        double s      = 0;
        double maxVal = 0;
        for (int i = index; i < nums.length && nums.length - i >= k; i++) {
            s += nums[i];
            double temp = (s * 1.0) / (i - index + 1);
            double next = dfs(i + 1, k - 1);
            maxVal = Math.max(maxVal, temp + next);
        }

        cached.put(biKey, maxVal);
        return maxVal;
    }

    private double dfs(int A[], int index, int K) {
        if (K == 0) {
            return 0.0;
        }
        if (K == 1) {// k=1时直接返回整个数组的均值
            int sum = 0;
            for (int i = index; i < A.length; i++) {
                sum += A[i];
            }
            return (double) sum / (A.length - index);
        }
        double sum = 0.0;
        double res = 0.0;
        for (int i = index; i <= A.length - K; i++) {
            sum += A[i];//枚举每个分离点
            double avage = sum / (i - index + 1);
            double temp  = dfs(A, i + 1, K - 1);//下一个组的均值
            res = Math.max(res, avage + temp);//取最大
        }
        return (double) res;
    }


    public static void main(String[] args) {
        Solution813 solution813 = new Solution813();
        System.out.println(solution813.largestSumOfAverages(new int[]{9, 1, 2, 3, 9}, 3));
    }
}
