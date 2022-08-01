package leetcode.p2022m06.day0628;

import common.TreeNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/5
 * @time 10:35 PM
 */
public class Solution968 {
    int ans = 0;

    public int minCameraCover(TreeNode root) {

        int status = dfs(root);
        if (status == 0) {
            ans++;
        }
        return ans;
    }

    //0 没被监控
    //1 被监控有摄像头
    //2 被监控，没有摄像头
    private int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }
        int lStatus = dfs(root.left);
        int rStatus = dfs(root.right);

        if (lStatus == 2 && rStatus == 2) {
            return 0;
        }

        if (rStatus == 0 || lStatus == 0) {
            ans++;
            return 1;
        }

        if (lStatus == 1 || rStatus == 1) {
            return 2;
        }
        return -1;
    }
}
