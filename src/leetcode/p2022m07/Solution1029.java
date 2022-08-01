package leetcode.p2022m07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 4:57 PM
 */
public class Solution1029 {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int t1 = o1[0] - o1[1];
                int t2 = o2[0] - o2[1];
                return t1 - t2;
            }
        });

        for (int i = 0; i < costs.length; i++) {
            pq.add(costs[i]);
        }


        int ans = 0;
        int i   = 0;
        while (i < costs.length / 2) {
            ans += pq.poll()[0];
            i++;
        }
        while (!pq.isEmpty()) {
            ans += pq.poll()[1];
        }
        return ans;
    }

    public static void main(String[] args){
        int[][] array=new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        Solution1029 solution1029=new Solution1029();
        int ans=solution1029.twoCitySchedCost(array);
        System.out.println(ans);
    }
}
