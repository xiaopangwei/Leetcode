package leetcode.p2022m01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/7
 * @time 10:42 PM
 */
public class MaxQueue {
    Deque<Integer> queue1 = new LinkedList<>();
    Deque<Integer> queue2 = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return queue2.peekLast();
    }

    public void push_back(int value) {
        queue1.add(value);

        while (!queue2.isEmpty() && queue2.peekLast() < value) {
            queue2.pollLast();
        }

        queue2.addLast(value);


    }

    public int pop_front() {
        if (queue1.isEmpty()) {
            return -1;
        }

        int res = queue1.pollFirst();
        if (queue2.peekFirst() == res) {
            queue2.pollFirst();
        }
        return res;
    }

    public static void main(String[] args){
        MaxQueue maxQueue=new MaxQueue();
        maxQueue.push_back(10);
        System.out.println(maxQueue.max_value());
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());
    }
}
