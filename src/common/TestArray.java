package common;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/18
 * @time 3:00 PM
 */
public class TestArray {


    public TreeNode rebuildByPostAndPreOrder(int[] preOrder, int start1, int end1, int[] postOrder, int start2, int end2) {
        if (start1 > end1) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(preOrder[start1]);
        }

        int t     = preOrder[start1 + 1];
        int index = -1;
        for (int i = start2; i < end2; i++) {
            if (t == postOrder[i]) {
                index = i;
                break;
            }
        }

        TreeNode root     = new TreeNode(preOrder[start1]);
        int      leftLen  = index - start2 + 1;
        int      rightLen = end1 - start1 - leftLen;

        root.left = rebuildByPostAndPreOrder(preOrder, start1 + 1, start1 + leftLen, postOrder, start2, start2 + leftLen - 1);
        root.right = rebuildByPostAndPreOrder(preOrder, start1 + leftLen + 1, start1 + 1 + leftLen + rightLen - 1,
                postOrder, index + 1, index+1+rightLen-1);
        return root;

    }

    public static void main(String[] args) {
        int[]     preorder  = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[]     postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TestArray testArray = new TestArray();
        TreeNode  root      = testArray.rebuildByPostAndPreOrder(preorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
        System.out.println(root);

    }
}
