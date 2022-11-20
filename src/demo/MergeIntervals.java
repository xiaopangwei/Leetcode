package demo;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/27
 * @time 7:17 PM
 */
public class MergeIntervals {
    public List<int[]> merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp    = result.get(result.size() - 1);
            int   lastEnd = temp[1];
            if (intervals[i][0] <= lastEnd) {
                int max = Math.max(intervals[i][1], lastEnd);
                temp[1] = max;
            } else {
                result.add(intervals[i]);
            }
        }

        return result;

    }

    static class Node {
        public int        val;
        public List<Node> neighbors;
    }

    Map<Node, Node> prevAndNewNodeMap = new HashMap<>();

    public Node cloneGraph(Node root) {
        if (root == null) {
            return null;
        }
        if (prevAndNewNodeMap.containsKey(root)) {
            return prevAndNewNodeMap.get(root);
        } else {
            Node cloned = new Node();
            cloned.val = root.val;
            prevAndNewNodeMap.put(root, cloned);
            for (Node node : root.neighbors) {
                cloned.neighbors.add(cloneGraph(node));
            }
            return cloned;
        }
    }


    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minCount = 0;
        while (!queue.isEmpty()) {
            int           size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            System.out.println(temp);
            minCount += getCount(temp);
        }
        return minCount;
    }




    private int minLCM(int a, int b) {
        long t = a * b;
        return (int) t / gcd(a, b);
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private int getCount(List<Integer> array) {
        List<Integer> sorted = new ArrayList<>(array);
        Collections.sort(sorted);
        int                   ans      = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < sorted.size(); i++) {
            indexMap.put(sorted.get(i), i);
        }
        for (int i = 0; i < sorted.size(); i++) {
            int idx = indexMap.get(array.get(i));
            if (i == idx) {
                continue;
            }
            ans++;
            int t   = array.get(i);
            int old = array.get(i);
            array.set(i, t);
            array.set(idx, old);
        }
        return ans;
    }



    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

//        Node node1 = new Node();
//        node1.val = 1;
//        Node node2 = new Node();
//        node2.val = 2;
//        Node node3 = new Node();
//        node3.val = 3;
//        node1.neighbors.add(node2);
//        node2.neighbors.add(node3);
//        node3.neighbors.add(node1);
//        Node newNode = mergeIntervals.cloneGraph(node1);
//        System.out.println(newNode);
//        List<int[]>    res            = mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}});
//        for (int[] array : res) {
//            System.out.println(Arrays.toString(array));
//        }

        TreeNode root = TreeNode.ofArray("[1,2,3,4,5,6]");

        System.out.println(mergeIntervals.minimumOperations(root));

        System.out.println(mergeIntervals.getCount(Arrays.asList(1, 5, 4, 3, 2)));
    }

}
