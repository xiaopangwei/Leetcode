package leetcode.p2021m07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 4:26 PM
 */
class MedianFinder {

    private int n=0;

    PriorityQueue<Integer> minHeap;

    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
    }

    public void addNum(int num) {

        n++;
        if (maxHeap.isEmpty()){
            maxHeap.add(num);
        }else{
            if (num>maxHeap.peek()){
                minHeap.add(num);
                if (minHeap.size()-maxHeap.size()>=1){
                    maxHeap.add(minHeap.poll());
                }
            }else{
                maxHeap.add(num);
                if (maxHeap.size()-minHeap.size()>1){
                    minHeap.add(maxHeap.poll());
                }
            }
        }
    }

    public double findMedian() {

        if (n%2==0){
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args){
        MedianFinder medianFinder=new MedianFinder();

        int[] array=new int[]{1,2,3,4,5,6};
        for(int item:array) {
            medianFinder.addNum(item);
            System.out.println(medianFinder.findMedian());
        }
    }
}