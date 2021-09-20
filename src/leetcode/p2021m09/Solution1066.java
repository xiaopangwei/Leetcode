package leetcode.p2021m09;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/20
 * @time 12:40 PM
 */
public class Solution1066 {


    static class BiKey {
        public int       indexOfWorker;
        public boolean[] visited;

        public BiKey(int indexOfWorker, boolean[] visited) {
            this.indexOfWorker = indexOfWorker;
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            BiKey biKey = (BiKey) o;

            if (indexOfWorker != biKey.indexOfWorker) return false;
            return Arrays.equals(visited, biKey.visited);
        }

        @Override
        public int hashCode() {
            int result = indexOfWorker;
            result = 31 * result + Arrays.hashCode(visited);
            return result;
        }
    }

    Map<BiKey, Integer> cached = new HashMap<>();

    public int assignBikes(int[][] workers, int[][] bikes) {

        boolean[] visited = new boolean[bikes.length];
        return dfs(0, workers, bikes, visited);

    }

    private int dfs(int indexOfWorker, final int[][] workers, final int[][] bikes,
                    boolean[] bikesVisited) {

        BiKey biKey = new BiKey(indexOfWorker, bikesVisited);
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }
        if (indexOfWorker == workers.length) {

            return 0;
        }
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if (!bikesVisited[i]) {
                bikesVisited[i] = true;
                int[] worker = workers[indexOfWorker];
                int   tmp    = getDist(worker[0], worker[1], bikes[i][0], bikes[i][1]);
                int   res    = dfs(indexOfWorker + 1, workers, bikes, bikesVisited) + tmp;
                sum = Math.min(sum, res);
                bikesVisited[i] = false;
            }
        }

        cached.put(biKey, sum);
        return sum;

    }

    private int getDist(int x, int y, int m, int n) {
        return Math.abs(x - m) + Math.abs(y - n);
    }

    public static void main(String[] args) {
//        workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//        int[][]      worker       = new int[][]{{0, 0}, {1, 1}, {2, 0}};
//        int[][]      bikes        = new int[][]{{1, 0}, {2, 2}, {2, 1}};

//        [[0,0],[2,1]], bikes = [[1,2],[3,3]]
        int[][]      worker       = new int[][]{{0, 0}, {2, 1}};
        int[][]      bikes        = new int[][]{{1, 2}, {3, 3}};
        Solution1066 solution1066 = new Solution1066();
        int          ans          = solution1066.assignBikes(worker, bikes);
        System.out.println(ans);


    }
}
