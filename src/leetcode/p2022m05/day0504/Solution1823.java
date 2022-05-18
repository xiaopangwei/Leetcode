package leetcode.p2022m05.day0504;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/4
 * @time 7:39 PM
 */
public class Solution1823 {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < k - 1; j++) {
                queue.add(queue.poll());
            }
            queue.poll();
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Solution1823 solution1823 = new Solution1823();
        System.out.println(solution1823.findTheWinner(6, 5));
    }
}
