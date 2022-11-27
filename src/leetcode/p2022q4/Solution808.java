package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/21
 * @time 9:53 PM
 */
public class Solution808 {
    double[][] cached = new double[200][200];

    public double soupServings(int n) {
        return dfs((n) / 25, (n) / 25);
    }

    private double dfs(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1;
        }
        if (b <= 0) {
            return 0;
        }

        if (cached[a][b] != 0) {
            return cached[a][b];
        }

        double t = 0.25 * (dfs(a - 4, b) + dfs(a - 3, b - 1) + dfs(a - 2, b - 2) + dfs(a - 1, b - 3));
        cached[a][b] = t;
        return t;
    }

    public static void main(String[] args) {
        Solution808 solution808 = new Solution808();
        System.out.println(solution808.soupServings(100));
    }
}
