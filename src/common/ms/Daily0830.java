package common.ms;

import common.TreeNode;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/30
 * @time 10:27 PM
 */
public class Daily0830 {
    public int minIncrementForUnique(int[] nums) {
        //1 1 2 2 3 7
        //1 2 3 4 5 7

        Arrays.sort(nums);
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                ans += nums[i - 1] + 1 - nums[i];
                nums[i] = nums[i - 1] + 1;
            }
        }
        return ans;
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        int left  = depth(root.left);
        int right = depth(root.right);
        if (left==right){
            return root;
        }
        else if (left<right){
            return lcaDeepestLeaves(root.right);
        }else{
            return lcaDeepestLeaves(root.left);
        }
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left  = depth(root.left);
        int right = depth(root.right);
        int v     = Math.max(left, right) + 1;
        return v;
    }


    public static void main(String[] args) {
        Daily0830 daily0830 = new Daily0830();
        int       ans       = daily0830.minIncrementForUnique(new int[]{1, 1, 2, 2, 3, 7});
        System.out.println(ans);
    }
}
