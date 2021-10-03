package leetcode.p2021m10;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:33 AM
 */
public class Solution272 {
    static class BiKey {
        TreeNode node;
        double   gap;

        public BiKey(TreeNode node, double gap) {
            this.node = node;
            this.gap = gap;
        }

    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        PriorityQueue<BiKey> pq = new PriorityQueue<>(new Comparator<BiKey>() {
            @Override
            public int compare(BiKey o1, BiKey o2) {
                if (o1.gap < o2.gap) {
                    return 1;
                } else if (o1.gap > o2.gap) {
                    return -1;
                }
                return 0;
            }
        });
        dfs(root, pq, k, target);

        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().node.val);
        }
        return list;
    }


    private void dfs(TreeNode root, final PriorityQueue<BiKey> pq,
                     final int k, final double target) {


        if (root == null) {
            return;
        }
        double gap = Math.abs(root.val - target);
        System.out.println(root.val + " " + gap);
//        if (!pq.isEmpty()) {
//            System.out.println("PEEK "+pq.peek().gap + " " + pq.peek().node.val+" "+pq.size());
//        }
        if (pq.size() < k) {
            pq.add(new BiKey(root, gap));
            dfs(root.left, pq, k, target);
            dfs(root.right, pq, k, target);
        }

//        else {
//            if (gap < pq.peek().gap) {
//                pq.poll();
//                pq.add(new BiKey(root, gap));
//                dfs(root.left, pq, k, target);
//                dfs(root.right, pq, k, target);
//            } else {
//                if (root.val > target) {
//                    dfs(root.left, pq, k, target);
//                } else {
//                    dfs(root.right, pq, k, target);
//                }
//            }
//        }

    }

    public static void main(String[] args) {
        Solution272 solution272 = new Solution272();
        TreeNode    root        = new TreeNode(4);
        TreeNode    node2       = new TreeNode(2);
        TreeNode    node5       = new TreeNode(5);
        TreeNode    node1       = new TreeNode(1);
        TreeNode    node3       = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        root.left = node2;
        root.right = node5;
        List<Integer> ans = solution272.closestKValues(root, 3.714286, 2);
        System.out.println(ans);
    }


}
