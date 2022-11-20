package leetcode.p2022q4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/10/9
 * @time 8:36 PM
 */
public class PRAC20221017 {


    int[][] vec;

    private int outIndex = 0;
    private int inIndex  = 0;

    public PRAC20221017(int[][] vec) {
        this.vec = vec;
    }

    public int next() {
        if (inIndex == vec[outIndex].length) {
            inIndex = 0;
            int t = vec[++outIndex][0];
            inIndex++;
            return t;
        } else {
            return vec[outIndex][inIndex++];
        }
    }

    public boolean hasNext() {
        if (outIndex > vec.length - 1) {
            return true;
        }
        if (outIndex == vec.length - 1 && inIndex == vec[outIndex].length) {
            return false;
        }

        int j = outIndex + 1;
        while (j < vec.length) {
            if (vec[j].length == 0) {
                j++;
            } else {
                break;
            }
        }

        outIndex = j;
        return true;
    }


    public int shortestPath(int[][] grid, int k) {
        int t = dfs(grid, 0, 0, k, 0, new HashSet<>());
        if (t == Integer.MAX_VALUE) {
            return -1;
        }
        return t;
    }

    int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private Map<String,Integer> cached=new HashMap<>();

    private int dfs(int[][] grid, int x, int y, int k, int count, Set<String> visited) {
        String biKey=x+"#"+y+"#"+k;
        if (cached.containsKey(biKey)){
            return cached.get(biKey);
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return 0;
        }
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                continue;
            }
            String temp = newX + "#" + newY;
            if (visited.contains(temp)) {
                continue;
            }
            visited.add(temp);
            if (grid[newX][newY] == 0) {
                int t = dfs(grid, newX, newY, k, count, visited);
                if (t != Integer.MAX_VALUE) {
                    t++;
                }
                dist = Math.min(dist, t);
            } else {
                if (count < k) {
                    int t = dfs(grid, newX, newY, k, count + 1, visited);
                    if (t != Integer.MAX_VALUE) {
                        t++;
                    }
                    dist = Math.min(dist, t);
                }
            }

            visited.remove(temp);
        }
        cached.put(biKey,dist);
        return dist;
    }


    public static void main(String[] args) {

        int[][]      array        = new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
        PRAC20221017 prac20221017 = new PRAC20221017(null);
        System.out.println(prac20221017.shortestPath(array, 1));
//        System.out.println(prac20221017.next());
//        System.out.println(prac20221017.next());
//        System.out.println(prac20221017.next());
//        System.out.println(prac20221017.next());
//        System.out.println(prac20221017.hasNext());
    }

}
