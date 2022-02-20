package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 9:01 PM
 */
public class Solution79 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    boolean[][] visited;
    char[][]    board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        int index = 0;
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];

                if (ch == word.charAt(index)) {
                    boolean flag = dfs(index, i, j, word);
                    if (flag) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int index, int x, int y, final String word) {

        if (index == word.length() - 1) {
            return true;
        }

        visited[x][y] = true;
        for (int i = 0; i < directions.length; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (isValid(board, newX, newY) &&
                    !visited[newX][newY] &&
                    board[newX][newY] == word.charAt(index + 1)) {
                if (dfs(index + 1, newX, newY, word)) {
                    return true;
                }
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        boolean flag = solution79.exist(new char[][]{{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB");
        System.out.println(flag);
    }
}
