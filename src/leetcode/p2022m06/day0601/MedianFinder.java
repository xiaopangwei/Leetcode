package leetcode.p2022m06.day0601;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 11:22 PM
 */
public class MedianFinder {

    PriorityQueue<Integer> minPq = new PriorityQueue<>();
    PriorityQueue<Integer> maxPq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (maxPq.isEmpty()) {
            maxPq.add(num);
            return;
        }
        if (num > maxPq.peek()) {
            minPq.add(num);
        } else {
            maxPq.add(num);
        }
        if (maxPq.size() - minPq.size() > 1) {
            minPq.add(maxPq.poll());
        }
        if (minPq.size() - maxPq.size() >= 1) {
            maxPq.add(minPq.poll());
        }
    }

    public double findMedian() {
        int size = minPq.size() + maxPq.size();
        if (size % 2 == 0) {
            return (maxPq.peek() + minPq.peek()) * 0.5;
        } else {
            return maxPq.peek();
        }
    }

    public static void main(String[] args){
        MedianFinder medianFinder=new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
