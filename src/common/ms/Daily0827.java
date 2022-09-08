package common.ms;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/27
 * @time 2:47 PM
 */
public class Daily0827 {
    public int consecutiveNumbersSum(int n) {
        int m    = 2 * n;
        int root = (int) Math.sqrt(m);
        int ans  = 0;
        for (int k = 1; k <= root; k++) {
            if (m % k == 0 && ((2 * n / k - k) & 1) == 1) {
                ans++;
            }
        }
        return ans;
    }

    public List<Integer> majorityElement(int[] nums) {
        int major1 = nums[0];
        int major2 = nums[0];
        int cnt1   = 0;
        int cnt2   = 0;
        for (int item : nums) {
            if (item == major1) {
                cnt1++;
            } else if (item == major2) {
                cnt2++;
            } else if (cnt1 == 0) {
                major1 = item;
                cnt1 = 1;

            } else if (cnt2 == 0) {
                major2 = item;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int cnt = 0;
        for (int item : nums) {
            if (item == major1) {
                cnt++;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (cnt > nums.length / 3) {
            list.add(major1);
        }

        if (major1 != major2) {
            cnt = 0;
            for (int item : nums) {
                if (item == major2) {
                    cnt++;
                }
            }
            if (cnt > nums.length / 3) {
                list.add(major2);
            }
        }
        return list;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null && targetSum == 0) {
            return true;
        }
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, final int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            int s = currentSum + root.val;
            if (s == targetSum) {
                return true;
            }
        }

        return dfs(root.left, targetSum, currentSum + root.val) || dfs(root.right, targetSum, currentSum + root.val);
    }

    public static void main(String[] args) {
        Daily0827 daily0827 = new Daily0827();
        System.out.println(daily0827.consecutiveNumbersSum(9));
//        System.out.println(daily0827.majorityElement(new int[]{1, 1, 0, 2}));
    }
}
