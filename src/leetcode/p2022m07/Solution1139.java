package leetcode.p2022m07;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/1
 * @time 8:39 PM
 */
public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {

        int     m     = grid.length;
        int     n     = grid[0].length;
        int[][] rowDp = new int[m][n];
        int[][] colDp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0 && grid[i][j] == 1) {
                    rowDp[i][j] = rowDp[i - 1][j] + 1;
                } else if (grid[i][j] == 1) {
                    rowDp[i][j] = 1;
                }

                if (j - 1 >= 0 && grid[i][j] == 1) {
                    colDp[i][j] = colDp[i][j - 1] + 1;
                } else if (grid[i][j] == 1) {
                    colDp[i][j] = 1;
                }
            }
        }


        int maxLen = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(colDp[i][j], rowDp[i][j]);
                //a[i][j]
                for (int k = min; k >= 1; k--) {
                    int t1 = colDp[i - k + 1][j];
                    int t2 = rowDp[i][j - k + 1];
                    if (t1 >= k && t2 >= k) {
                        maxLen = Math.max(maxLen, k);
                        break;
                    }
                }
            }
        }

        return maxLen * maxLen;
    }

    public int findLength(int[] nums1, int[] nums2) {
        int     m      = nums1.length;
        int     n      = nums2.length;
        int[][] dp     = new int[m + 1][n + 1];
        int     maxLen = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen;
    }


    int[][]              directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    Map<String, Boolean> cached     = new HashMap<>();

    public boolean exist(char[][] board, String word) {
        int         m       = board.length;
        int         n       = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(1, word, board, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }


    private String convert(boolean[][] visited) {

        StringBuilder sb = new StringBuilder();
        for (boolean[] b : visited) {
            int base = 1;
            int temp = 0;
            for (boolean c : b) {
                if (c) {
                    temp += base;
                }
                base <<= 1;
            }
            sb.append(String.valueOf(temp));
            sb.append("$");
        }

        return sb.toString();
    }

    private boolean dfs(int index, final String word, final char[][] board, int x, int y, boolean[][] visited) {


        if (index >= word.length()) {
            return true;
        }
        String biKey = index + "#" + x + "#" + y + "#" + convert(visited);
        if (cached.containsKey(biKey)) {
            return cached.get(biKey);
        }

        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length) {
                continue;
            }
            if (visited[newX][newY] || word.charAt(index) != board[newX][newY]) {
                continue;
            }

            visited[newX][newY] = true;

            if (dfs(index + 1, word, board, newX, newY, visited)) {
                cached.put(biKey, true);
                return true;
            }
            visited[newX][newY] = false;
        }
        cached.put(biKey, false);
        return false;
    }


    public static void main(String[] args) {
        Solution1139 solution1139 = new Solution1139();

//        int          ans          = solution1139.largest1BorderedSquare(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
//        int ans = solution1139.findLength(new int[]{0, 0, 0, 0, 0}, new int[]{0, 0, 0, 0, 0});
        char[][] array = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(solution1139.exist(array, "ABCESEEEFS"));
    }
}
