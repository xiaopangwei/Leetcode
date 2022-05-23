package leetcode.p2022m05.day0501;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 5:12 PM
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        for (int i = 0; i < matrix.length; i++) {
            pq.add(new int[]{i, 0, matrix[i][0]});
        }

        int count = 0;
        while (count < k - 1) {
            int[] temp = pq.poll();
            count++;
            if (temp[1] + 1 < matrix[temp[0]].length) {
                pq.add(new int[]{temp[0], temp[1] + 1, matrix[temp[0]][temp[1]+1]});

            }
        }
        return pq.poll()[2];
    }

    public static void main(String[] args) {
        Solution378 solution378 = new Solution378();
        //[[1,5,9],[10,11,13],[12,13,15]]
        int ans = solution378.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8);
        System.out.println(ans);
    }
}
