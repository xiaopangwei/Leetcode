package leetcode.p2021m08;

import example.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/3
 * @time 10:04 AM
 */
public class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        dfs(root, parent);
        return getNext(p, parent);

    }

    private TreeNode getNext(TreeNode node, final Map<TreeNode, TreeNode> parent) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            TreeNode p    = node.right;
            TreeNode last = p;
            while (p != null) {
                last = p;
                p = p.left;
            }
            return last;
        } else if (parent.containsKey(node)) {
            TreeNode temp = null;
            while (true) {
                if (!parent.containsKey(node)) {
                    return null;
                }
                temp = parent.get(node);
//                System.out.println(temp.val);
                if (temp.left == node) {
                    return temp;
                } else {
                    node = temp;
                }
            }
        }
        return null;
    }

    private void dfs(TreeNode root, Map<TreeNode, TreeNode> parent) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            parent.put(root.left, root);
        }
        if (root.right != null) {
            parent.put(root.right, root);
        }
        dfs(root.left, parent);
        dfs(root.right, parent);
    }


    public static void main(String[] args) {
        Solution285 solution285 = new Solution285();
        TreeNode    treeNode    = TreeNode.ofArray("[41,37,44,24,39,42,48,1,35,38,40,null,43,46,49,0,2,30,36,null,null,null,null,null,null,45,47,null,null,null,null,null,4,29,32,null,null,null,null,null,null,3,9,26,null,31,34,null,null,7,11,25,27,null,null,33,null,6,8,10,16,null,null,null,28,null,null,5,null,null,null,null,null,15,19,null,null,null,null,12,null,18,20,null,13,17,null,null,22,null,14,null,null,21,23]");
//        int         start       = 40;
//        int         end         = start;
        for (int i = 40; i <= 40; i++) {
            TreeNode temp = TreeNode.search(treeNode, i);
            TreeNode ans  = solution285.inorderSuccessor(treeNode, temp);
            if (ans == null) {
                System.out.println("NULL");
            } else {
                System.out.println(ans.val);
            }
        }
    }
}
