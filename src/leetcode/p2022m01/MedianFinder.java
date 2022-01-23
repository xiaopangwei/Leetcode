package leetcode.p2022m01;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/19
 * @time 11:04 PM
 */
public class MedianFinder {

    PriorityQueue<Integer> maxPq;
    PriorityQueue<Integer> minPq;


    public MedianFinder() {
        maxPq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        minPq = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxPq.isEmpty()) {
            maxPq.add(num);
        } else if (num > maxPq.peek()) {
            minPq.add(num);
        } else {
            maxPq.add(num);
        }

        int maxSize = maxPq.size();
        int minSize = minPq.size();

        if (maxSize - minSize > 1) {
            minPq.add(maxPq.poll());
        } else if (minSize - maxSize >= 1) {
            maxPq.add(minPq.poll());
        } else {

        }
    }

    public double findMedian() {
        if (maxPq.size() == minPq.size()) {
            return (maxPq.peek() + minPq.peek()) * 1.0 / 2;
        } else {
            return maxPq.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        int[]        array        = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            medianFinder.addNum(array[i]);
            System.out.println(medianFinder.findMedian());
        }
    }
}
