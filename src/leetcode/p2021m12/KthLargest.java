package leetcode.p2021m12;

import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 5:08 PM
 */
public class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int item : nums) {
            if (pq.isEmpty() || pq.size()<k) {
                pq.add(item);
            } else {
                if (pq.peek() < item) {
                    if (pq.size() == k) {
                        pq.poll();
                    }
                    pq.add(item);
                }
            }
        }
    }

    public int add(int val) {
        if (pq.isEmpty()||pq.size()<k) {
            pq.add(val);
            return pq.peek();
        } else {
            if (pq.peek() < val) {
                if (pq.size() == k) {
                    pq.poll();
                    pq.add(val);
                } else {
                    pq.add(val);
                }
                return pq.peek();
            } else {
                if (pq.size() < k) {
                    pq.add(val);
                }
                return pq.peek();
            }
        }
    }

    public static void main(String[] args) {
        KthLargest largest = new KthLargest(3, new int[]{5,-1});
        int[]      array   = new int[]{2, 1, -1, 3, 4};
        for (int item : array) {
            System.out.println(largest.add(item));
        }
    }
}
