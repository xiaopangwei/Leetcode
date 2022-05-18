package leetcode.p2022m05.day0511;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 7:51 PM
 */
public class Codec {
    public String serialize(TreeNode root) {

        List<String> list = new ArrayList<>();
        preOrder(root, list);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(String.join(",", list));
        sb.append("]");
        return sb.toString();
    }

    private void preOrder(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }

        list.add(String.valueOf(root.val));
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() <= 2) {
            return null;
        }
        String   temp     = data.substring(1, data.length() - 1);
        String[] strArray = temp.split(",");
        int[]    array    = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            array[i] = Integer.parseInt(strArray[i]);
        }

        return rebuild(array, 0, array.length - 1);
    }

    private TreeNode rebuild(int[] array, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(array[left]);
        }
        TreeNode root               = new TreeNode(array[left]);
        int      rightSubStartIndex = -1;
        for (int i = left + 1; i <= right; i++) {
            if (array[i] > array[left]) {
                rightSubStartIndex = i;
                break;
            }
        }

        if (rightSubStartIndex != -1) {
            root.left = rebuild(array, left + 1, rightSubStartIndex - 1);
            root.right = rebuild(array, rightSubStartIndex, right);
        } else {
            root.left = rebuild(array, left + 1, right);
            root.right = null;
        }
        return root;
    }

    public static void main(String[] args) {
        Codec    codec = new Codec();
        TreeNode root  = TreeNodeBuilder.build("[2,1,3]");
        String   ans   = codec.serialize(root);
        TreeNode node  = codec.deserialize(ans);
        System.out.println(node);
    }
}
