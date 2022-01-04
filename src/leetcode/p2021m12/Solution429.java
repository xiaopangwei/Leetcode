package leetcode.p2021m12;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 11:00 AM
 */

public class Solution429 {

    static class Node {
        public int        val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

    public List<List<Integer>> levelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int           size  = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                level.add(temp.val);
                if (temp.children != null && !temp.children.isEmpty()) {
                    for (Node c : temp.children) {
                        if (c != null) {
                            queue.add(c);
                        }
                    }
                }
            }
            ans.add(level);
        }
        return ans;
    }


}
