package leetcode.p2022q4;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/9
 * @time 8:36 PM
 */
public class PRAC20221009 {
    int ans = 0;

    public int findTilt(TreeNode root) {
        int[] t = dfs(root);
        return ans;
    }


    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] a = dfs(root.left);
        int[] b = dfs(root.right);

        int s1 = a[0] + a[1];
        if (root.left != null) {
            s1 += root.left.val;
        }

        int s2 = b[0] + b[1];
        if (root.right != null) {
            s2 += root.right.val;
        }
        ans += Math.abs(s1 - s2);
        return new int[]{s1, s2};
    }



    static class FreqStack {

        Map<Integer, Integer> freq  = new HashMap<>();
        int                   index = 0;
        public PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                }
                return o2[2] - o1[2];
            }
        });

        public FreqStack() {

        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
            int f = freq.get(val);
            pq.add(new int[]{val, f, index++});
        }

        public int pop() {
            int[] target=pq.poll();
            int ans=target[0];
            freq.put(ans,freq.getOrDefault(ans,0)-1);
            return ans;
        }
    }


    public static void main(String[] args) {
//        TreeNode     root         = TreeNode.ofArray("[21,7,14,1,1,2,2,3,3]");
//        PRAC20221009 prac20221009 = new PRAC20221009();
//        System.out.println(prac20221009.findTilt(root));

        PRAC20221009.FreqStack freqStack = new PRAC20221009.FreqStack();
        freqStack.push(5);//堆栈为 [5]
        freqStack.push(7);//堆栈是 [5,7]
        freqStack.push(5);//堆栈是 [5,7,5]
        freqStack.push(7);//堆栈是 [5,7,5,7]
        freqStack.push(4);//堆栈是 [5,7,5,7,4]
        freqStack.push(5);//堆栈是 [5,7,5,7,4,5]
        int a = freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        int b = freqStack.pop();//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        int c = freqStack.pop();//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        int d = freqStack.pop();//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成 [5,7]。
        System.out.println("a:" + a + " b:" + b + " c:" + c + " d:" + d);
    }

}
