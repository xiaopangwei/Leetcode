package leetcode.p2021m08;

import common.TreeNode;
import common.TreeNodeBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/28
 * @time 9:56 PM
 */
public class TreeCodec {
    public String serialize(TreeNode root) {
        List<String> ans = new ArrayList<>();
        serialize(root, ans);
        return "[" + String.join(",", ans) + "]";
    }

    private void serialize(TreeNode root, List<String> list) {
        if (root == null) {
            list.add("null");
            return;
        }
        list.add(String.valueOf(root.val));
        serialize(root.left, list);
        serialize(root.right, list);
    }

    public TreeNode deserialize(String data) {
        String[]     array = data.substring(1, data.length() - 1).split(",");
        List<String> list  = new ArrayList<>();
        for (String item : array) {
            list.add(item);
        }
        return deserialize1(list);
    }

    private TreeNode deserialize1(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String rootVal = list.remove(0);
        if ("null".equals(rootVal)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        root.left = deserialize1(list);
        root.right = deserialize1(list);
        return root;
    }

    public static void main(String[] args) {
        TreeCodec treeCodec = new TreeCodec();
        TreeNode  root      = TreeNodeBuilder.build("[1,null,2,3,4]");
//        TreeNode root = null;
        String res = treeCodec.serialize(root);
        System.out.println(res);
        TreeNode ans = treeCodec.deserialize(res);
        System.out.println(ans);
    }
}
