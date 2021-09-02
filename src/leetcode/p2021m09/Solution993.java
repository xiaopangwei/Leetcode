package leetcode.p2021m09;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/1
 * @time 10:59 PM
 */
public class Solution993 {
    static class BiKey {
        public TreeNode node;
        public int      depth;
        public int      parent;

        public BiKey(TreeNode node, int depth, int parent) {
            this.node = node;
            this.depth = depth;
            this.parent = parent;
        }


    }

    public boolean isCousins(TreeNode root, int x, int y) {

        Queue<BiKey> queue = new LinkedList<>();
        int          d1    = -1, d2 = -1, parentId1 = -1, parentId2 = -1;

        queue.add(new BiKey(root, 0, -1));
        while (!queue.isEmpty()) {
            BiKey temp = queue.poll();
//            System.out.println(temp.node.val);
            int depth = temp.depth;
            if (temp.node.val == x) {
                d1 = depth + 1;
                parentId1 = temp.parent;
            } else if (temp.node.val == y) {
                d2 = depth + 1;
                parentId2 = temp.parent;
            }
            if (temp.node.left != null) {
                queue.add(new BiKey(temp.node.left, depth + 1, temp.node.val));
            }

            if (temp.node.right != null) {
                queue.add(new BiKey(temp.node.right, depth + 1, temp.node.val));
            }
        }

        if (d1 == d2 && parentId1 != parentId2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution993 solution993 = new Solution993();
        TreeNode    root        = TreeNode.ofArray("[1,2,3,null,4,null,5]");
        boolean     ans         = solution993.isCousins(root, 5, 4);
        System.out.println(ans);
    }
}
