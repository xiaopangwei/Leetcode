package leetcode.p2021m08;

import common.TreeNode;

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
    //  a
    //b   c
    public String serialize(TreeNode root) {

        List<String> data = new ArrayList<>();
        serialize(root, data);
        return "[" + String.join(",", data) + "]";

    }

    public void serialize(TreeNode root, List<String> data) {
        if (root == null) {
            data.add("null");
            return;
        }
        data.add(String.valueOf(root.val));
        serialize(root.left, data);
        serialize(root.right, data);
    }

    public TreeNode deserialize(String data) {

        String       sub  = data.substring(1, data.length() - 1);
        String[]     arr  = sub.split(",");
        List<String> list = new ArrayList<>();
        for (String item : arr) {
            list.add(item);
        }
        return deserialize(list);
    }

    public TreeNode deserialize(List<String> data) {

        String val = data.get(0);
        data.remove(0);
        if ("null".equals(val)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = deserialize(data);
            root.right = deserialize(data);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeCodec treeCodec = new TreeCodec();
        TreeNode  root      = TreeNode.ofArray("[1,2,3,null,null,4,5]");
//        TreeNode root = null;
        String   res  = treeCodec.serialize(root);
        System.out.println(res);
        TreeNode ans=treeCodec.deserialize(res);
        System.out.println(ans);
    }
}
