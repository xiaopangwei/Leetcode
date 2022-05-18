package leetcode.p2022m05.day0501;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 10:57 AM
 */
public class Solution1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {


        List<Integer> list1 = inOrderTraverse(root1);
        List<Integer> list2 = inOrderTraverse(root2);

        List<Integer> ans = new ArrayList<>(list1.size() + list2.size());

        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.size() && index2 < list2.size()) {
            if (list1.get(index1) <= list2.get(index2)) {
                ans.add(list1.get(index1));
                index1++;
            } else {
                ans.add(list2.get(index2));
                index2++;
            }
        }

        if (index1 < list1.size()) {
            System.arraycopy(list1, index1, ans, ans.size(),list1.size()-index1);
        }

        if (index2 < list2.size()) {
            System.arraycopy(list2, index1, ans, ans.size(),list1.size()-index1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1305 solution1305 = new Solution1305();
        TreeNode     root1        = TreeNode.ofArray("[2,1,4]");
        TreeNode     root2        = TreeNode.ofArray("[1,0,3]");
        System.out.println(solution1305.getAllElements(root1, root2));
    }

    private List<Integer> inOrderTraverse(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        List<Integer> ans = new ArrayList<>();

        TreeNode p1 = root;
        while (p1 != null || !stack.isEmpty()) {
            while (p1 != null) {
                stack.push(p1);
                p1 = p1.left;
            }

            TreeNode temp = stack.pop();
            ans.add(temp.val);
            p1 = temp.right;
        }

        return ans;
    }
}
