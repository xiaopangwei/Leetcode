package leetcode.p2021m10;

import common.uaf.UnionAndFind;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 9:33 AM
 */
public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        int[][]       directions   = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        UnionAndFind  unionAndFind = new UnionAndFind(m * n);
        boolean[][]   visited      = new boolean[m][n];
        List<Integer> ans          = new ArrayList<>();
        int           count        = 0;
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];


            if (!visited[x][y]) {

                visited[x][y] = true;
                count++;
                int flattenIndex = x * m + y;

                for (int t = 0; t < directions.length; t++) {
                    int newX = directions[t][0] + x;
                    int newY = directions[t][1] + y;
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                        continue;
                    }

                    if (!visited[newX][newY]) {
                        continue;
                    }

                    int newIndex = newX * m + newY;
                    System.out.println(newIndex+" "+flattenIndex);
                    if (unionAndFind.find(newIndex) != unionAndFind.find(flattenIndex)) {
                        unionAndFind.union(newIndex, flattenIndex);
                        count--;
                    }
                }
            }

            ans.add(count);


        }
        return ans;
    }

    public static void main(String[] args) {
        Solution305   solution305 = new Solution305();
        List<Integer> ans         = solution305.numIslands2(8, 4, new int[][]{{0,0},{7,1},{6,1},{3,3},{4,1}});
        System.out.println(ans);

    }
}
