package leetcode.p2021m12;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/27
 * @time 9:39 PM
 */
public class Solution501 {
    List<Integer> ans         = new ArrayList<>();
    int           maxFreq     = 0;
    int           currentFreq = 0;

    int val = -1;


    public int[] findMode(TreeNode root) {
        dfs(root);

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }

        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        dfs(root.left);
        if (val == root.val) {
            currentFreq++;
        } else {
            currentFreq = 1;
            val = root.val;
        }

        if (currentFreq > maxFreq) {
            ans.clear();
            ans.add(val);
            maxFreq = currentFreq;
        } else if (currentFreq == maxFreq) {
            ans.add(val);
        }


        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode r    = new TreeNode(2);
        TreeNode l    = new TreeNode(1);
        root.left = l;
        root.right = r;


        TreeNode t1 = new TreeNode(3);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(3);
        t1.left = l1;
        t1.right = r1;

        r.right = t1;
        r.left = new TreeNode(2);


        Solution501 solution501 = new Solution501();
        int[]       ans         = solution501.findMode(root);
        System.out.println(Arrays.toString(ans));


    }
}
