package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/7
 * @time 8:48 PM
 */
public class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int   length = isConnected.length;
        int[] parent = new int[length];
        int[] rank   = new int[length];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isConnected[i][j] == 1) {
                    merge(rank, parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (parent[i] == i) {
                count++;
            }
        }
        return count;
    }

    private void merge(int[] rank, int[] parent, int x, int y) {
        int parentX = getParent(parent, x);
        int parentY = getParent(parent, y);
        if (rank[parentX] == rank[parentY]) {
            rank[parentX] = parentY;
            rank[parentY]++;
        } else if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
        }
    }

    private int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        int temp = getParent(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }

    public static void main(String[] args) {
        Solution547 solution547 = new Solution547();
        int         ans         = solution547.findCircleNum(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
        System.out.println(ans);
    }
}
