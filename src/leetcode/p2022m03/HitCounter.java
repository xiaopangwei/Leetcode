package leetcode.p2022m03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/7
 * @time 9:35 PM
 */
public class HitCounter {
    Deque<Integer> deque;

    public HitCounter() {
        deque = new LinkedList<>();
    }

    public void hit(int timestamp) {
        deque.add(timestamp);
    }

    public int getHits(int timestamp) {
        while (!deque.isEmpty() && deque.pollFirst() <= timestamp - 300) {
            deque.pollFirst();
        }
        return deque.size();
    }
}
