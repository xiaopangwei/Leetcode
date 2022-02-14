package leetcode.p2022m02;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/13
 * @time 9:20 PM
 */
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> list = new ArrayList<>();
        serialize(root, list);
        return String.join(",", list);
    }

    public void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            return;
        }
        list.add(String.valueOf(root.val));
        serialize(root.left, list);
        serialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[]      array = data.split(",");
        List<Integer> list  = new ArrayList<>();
        for (String item : array) {
            list.add(Integer.parseInt(item));
        }
        return deserialize0(list, 0, array.length - 1);
    }

    public TreeNode deserialize0(List<Integer> data, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(data.get(start));
        }
        int      rootVal = data.get(start);
        TreeNode root    = new TreeNode(rootVal);
        int      index   = end + 1;
        for (int i = start + 1; i <= end; i++) {
            if (data.get(i) > rootVal) {
                index = i;
                break;
            }
        }
        root.left = deserialize0(data, start + 1, index - 1);

        root.right = deserialize0(data, index, end);

        return root;
    }

    public static void main(String[] args) {
        Codec  codec = new Codec();
        String data  = codec.serialize(TreeNodeBuilder.build("[2]"));
        System.out.println(data);
        TreeNode root = codec.deserialize(data);
        System.out.println(root);
    }

}
