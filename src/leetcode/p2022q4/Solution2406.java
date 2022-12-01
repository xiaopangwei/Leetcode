package leetcode.p2022q4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/1
 * @time 10:01 PM
 */
public class Solution2406 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

//        for (int[] t:intervals){
//            System.out.println(Arrays.toString(t));
//        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] interval : intervals) {
            if (pq.isEmpty()) {
                pq.add(interval[1]);
            }else{
                if (pq.peek()<interval[0]){
                    pq.poll();
                }
                pq.add(interval[1]);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][]      array        = new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        Solution2406 solution2406 = new Solution2406();
        System.out.println(solution2406.minGroups(array));
    }
}
