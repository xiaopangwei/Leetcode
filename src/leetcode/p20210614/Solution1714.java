package leetcode.p20210614;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 3:10 PM
 */
public class Solution1714 {
    public int[] smallestK(int[] arr, int k) {
        if (k==0||arr.length==0){
            return new int[0];
        }
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int item:arr){
            if (heap.size()<k){
                heap.add(item);
            }else{
                if (item>=heap.peek()){
                    continue;
                }else{
                    int max=heap.poll();
                    heap.add(item);
                }
            }
        }

        int[] ans=new int[k];
        for (int i=0;i<k;i++){
            ans[i]=heap.poll();
        }
        return ans;
    }

    public static void main(String[] args){
        Solution1714 solution1714=new Solution1714();
        int[] res=solution1714.smallestK(new int[]{1,2,3},0);
        System.out.println(Arrays.toString(res));
    }
}
