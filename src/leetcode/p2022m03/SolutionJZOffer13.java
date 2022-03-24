package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 8:38 PM
 */
public class SolutionJZOffer13 {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    int m;
    int n;
    int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;

        boolean[][] visited = new boolean[m][n];
        dfs(0,0,visited);
        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) {
            return;
        }

        if (getDigitSum(x) + getDigitSum(y) > k) {
            return;
        }

        visited[x][y] = true;

        for (int[] dir : directions) {
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            dfs(newX, newY, visited);
        }

    }

    private int getDigitSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += (a % 10);
            a /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
        SolutionJZOffer13 solutionJZOffer13=new SolutionJZOffer13();
        int ans=solutionJZOffer13.getDigitSum(8);
        System.out.println(ans);
    }
}
