package leetcode.p20210210;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue=new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i:nums){
            if (queue.size()<k){
                queue.add(i);
            }
            else if (i>queue.peek()){
                queue.remove();
                queue.add(i);
            }
        }
        return queue.peek();
    }
    public static void main(String[] args){
        Solution215 solution215=new Solution215();
        int[] array=new int[]{3,2,4,1,7,7,10};
        System.out.println(solution215.findKthLargest(array,3));
    }
}
