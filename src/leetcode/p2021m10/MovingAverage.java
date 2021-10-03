package leetcode.p2021m10;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/1
 * @time 11:39 PM
 */
public class MovingAverage {
    int            windowSum = 0;
    int            size      = 0;
    Deque<Integer> deque     = new LinkedList<>();

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {

        if (deque.size() < this.size) {
            windowSum += val;
            deque.addLast(val);
            return windowSum * 1.0 / deque.size();
        } else {
            int first = deque.pollFirst();
            windowSum -= first;
            deque.addLast(val);
            windowSum += val;
            return windowSum * 1.0 / this.size;
        }
    }

    public static void main(String[] args) {
        MovingAverage average = new MovingAverage(3);
        System.out.println(average.next(1));
        System.out.println(average.next(10));
        System.out.println(average.next(3));
        System.out.println(average.next(5));
    }
}
