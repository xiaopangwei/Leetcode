package leetcode.p2021m08;

import common.CustomTrie;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 3:56 PM
 */
public class Solution212 {
    private CustomTrie root;

    static final int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        root = new CustomTrie("");
        for (String line : words) {
            CustomTrie.insert(root, line);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (root.nextNodeMap.containsKey(ch)) {
                    CustomTrie t = root.nextNodeMap.get(ch);
                    dfs(board, i, j, t, visited);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] board, int x, int y, CustomTrie prefix, boolean[][] visited) {

//        System.out.println(x + " " + y + " " + board[x][y]);
        if (prefix.terminated) {
            if (!ans.contains(prefix.prefix)) {
                ans.add(prefix.prefix);
            }
        }
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {

            int newX = x + DIRECTIONS[i][0];
            int newY = y + DIRECTIONS[i][1];
            if (isValid(board, newX, newY) && isUnVisited(visited, newX, newY) &&
                    prefix.nextNodeMap.containsKey(board[newX][newY])) {
                dfs(board, newX, newY, prefix.nextNodeMap.get(board[newX][newY]), visited);
            }
        }


        visited[x][y] = false;
    }

    private boolean isValid(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }

    private boolean isUnVisited(boolean[][] visited, int x, int y) {
        return !visited[x][y];
    }


    public static void main(String[] args) {
        char[][]     array       = new char[][]{{'a', 'b'}, {'c', 'd'}};
        String[]     target      = new String[]{"abcb"};
        Solution212  solution212 = new Solution212();
        List<String> ans         = solution212.findWords(array, target);
        System.out.println(ans);
    }
}
