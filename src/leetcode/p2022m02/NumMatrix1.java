package leetcode.p2022m02;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/8
 * @time 9:39 PM
 */
public class NumMatrix1 {
    int[][] prefixSum;

    public NumMatrix1(int[][] matrix) {
        int cols = matrix[0].length + 1;
        prefixSum = new int[matrix.length][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < cols; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int ans = 0;
        //[i,j] prefix[j+1]-prefix[i]
        for (int i = row1; i <= row2; i++) {
            ans += (prefixSum[i][col2 + 1] - prefixSum[i][col1]);
        }
        return ans;
    }
}
