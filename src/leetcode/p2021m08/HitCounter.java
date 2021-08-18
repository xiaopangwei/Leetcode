package leetcode.p2021m08;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 10:47 PM
 */
public class HitCounter {
    /**
     * Initialize your data structure here.
     */
    private Deque<Integer> deque;

    public HitCounter() {
        deque = new LinkedList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        deque.addLast(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {

        while (!deque.isEmpty() && timestamp - deque.peekFirst() >= 300) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
