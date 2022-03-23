package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/19
 * @time 8:14 PM
 */
public class Solution305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[]         rank       = new int[m * n];
        int[][]       directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[]     visited    = new boolean[m * n];
        int           count      = 0;
        List<Integer> ans        = new ArrayList<>();
        for (int i = 0; i < positions.length; i++) {
            int flattenIndex = positions[i][0] * n + positions[i][1];
            if (!visited[flattenIndex]) {
                visited[flattenIndex] = true;
                count++;
            }

            for (int[] dir : directions) {
                int newX = positions[i][0] + dir[0];
                int newY = positions[i][1] + dir[1];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                    continue;
                }
                int newIndex = newX * n + newY;
                if (visited[newIndex] && find(parent, flattenIndex) != find(parent, newIndex)) {
                    union(parent, rank, flattenIndex, newIndex);
                    count--;
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private int find(int[] parent, int index) {
        if (index == parent[index]) {
            return index;
        }
        int temp = find(parent, parent[index]);
        parent[index] = temp;
        return temp;
    }

    private boolean union(int[] parent, int[] rank, int index1, int index2) {
        int p1 = find(parent, index1);
        int p2 = find(parent, index2);
        if (p1 != p2) {
            if (rank[p1] == rank[p2]) {
                parent[p1] = p2;
                rank[p2]++;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
            }

            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution305 solution305 = new Solution305();
        //[[0,0],[0,1],[1,2],[2,1]]
        List<Integer> ans = solution305.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}});
        System.out.println(ans);
    }
}
