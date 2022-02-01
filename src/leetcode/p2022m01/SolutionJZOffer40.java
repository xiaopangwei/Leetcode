package leetcode.p2022m01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/29
 * @time 11:07 AM
 */
public class SolutionJZOffer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.add(arr[i]);
            } else {
                if (arr[i] < pq.peek()) {
                    pq.poll();
                    pq.add(arr[i]);
                }
            }
        }
        int[] ans   = new int[k];
        int   index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll();
        }
        return ans;
    }

    public static void main(String[] args){
        SolutionJZOffer40 solutionJZOffer40=new SolutionJZOffer40();
        int[] num=solutionJZOffer40.getLeastNumbers(new int[]{0,0,1,2,4,2,2,3,1,4},8);
        System.out.println(Arrays.toString(num));

    }
}
