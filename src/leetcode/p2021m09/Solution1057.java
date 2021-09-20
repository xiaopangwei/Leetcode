package leetcode.p2021m09;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 10:31 AM
 */
public class Solution1057 {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int                   bikeNums         = bikes.length;
        int                   workerNums       = workers.length;
        Map<Integer, Integer> workerAndBikeMap = new TreeMap<>();
        //worker,biker,dist
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                } else if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
        for (int i = 0; i < workerNums; i++) {
            int x = workers[i][0];
            int y = workers[i][1];

            for (int j = 0; j < bikeNums; j++) {
                int m = bikes[j][0];
                int n = bikes[j][1];

                int dist = getDist(x, y, m, n);

                pq.add(new int[]{i, j, dist});
            }
        }

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            if (workerAndBikeMap.containsKey(temp[0]) || workerAndBikeMap.containsValue(temp[1])) {
                continue;
            }

            workerAndBikeMap.put(temp[0], temp[1]);

        }


        int[] res = new int[workerAndBikeMap.size()];
        int   k   = 0;
        for (Map.Entry<Integer, Integer> entry : workerAndBikeMap.entrySet()) {
            res[k++] = entry.getValue();
        }

        return res;
    }

    private int getDist(int x, int y, int m, int n) {
        return Math.abs(x - m) + Math.abs(y - n);
    }

    public static void main(String[] args) {
        Solution1057 solution1057 = new Solution1057();
//        workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//        [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
        int[] ans = solution1057.assignBikes(new int[][]{{0, 0}, {1, 1}, {2, 0}},
                new int[][]{{1, 0}, {2, 2}, {2, 1}});
        System.out.println(Arrays.toString(ans));
    }
}
