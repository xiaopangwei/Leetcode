package leetcode.p2022m01;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 3:48 PM
 */
public class HeapSort {

    public int[] sort(int[] num){
        MyHeap myHeap=new MyHeap(num);
        int[] ans=new int[num.length];
        int index=0;
        for (int i=0;i<num.length;i++){
            ans[index++]=myHeap.remove();
        }
        return ans;
    }

    public static void main(String[] args){
        HeapSort heapSort=new HeapSort();
        int[] ans=heapSort.sort(new int[]{1, 6, 5, 4, 8, 12, 10});
        System.out.println(Arrays.toString(ans));
    }
}
