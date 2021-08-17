package leetcode.p2021m08;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/16
 * @time 4:44 PM
 */
public class Solution95 {


    public List<TreeNode> generateTrees(int n) {


        return generateTrees(1, n);
    }

    //[1-(i-1)] i [i+1,n]
    public List<TreeNode> generateTrees(int startIndex, int endIndex) {

        List<TreeNode> ans = new ArrayList<>();
        if (startIndex > endIndex) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(null);
            return temp;
        } else if (startIndex == endIndex) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(new TreeNode(startIndex));
            return temp;
        }
        for (int i = startIndex; i <= endIndex; i++) {

            List<TreeNode> leftList  = null;
            List<TreeNode> rightList = null;
            leftList = generateTrees(startIndex, i - 1);
            rightList = generateTrees(i + 1, endIndex);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = copy(left);
                    root.right = copy(right);
                    ans.add(root);
                }
            }
        }

        return ans;

    }

    private static TreeNode copy(TreeNode root) {
        if (root == null) return null;
        TreeNode copy = new TreeNode(root.val);
        copy.left = copy(root.left);
        copy.right = copy(root.right);
        return copy;
    }

    public static void main(String[] args) {
        Solution95     solution95 = new Solution95();
        List<TreeNode> ans        = solution95.generateTrees(3);

        for (TreeNode root : ans) {
            System.out.println(root);
        }
    }


}
