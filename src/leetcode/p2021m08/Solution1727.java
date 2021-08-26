package leetcode.p2021m08;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/25
 * @time 11:01 AM
 */
public class Solution1727 {
    public int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int maxArea = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }


        for (int i=0;i<m;i++){
            int[] height=matrix[i].clone();
            Arrays.sort(height);

            for (int j=n-1;j>=0;j--){
                int area=(n-j)*height[j];
                maxArea=Math.max(maxArea,area);
            }
        }


        return maxArea;
    }


    public static void main(String[] args) {
        Solution1727 solution1727 = new Solution1727();
        int          ans          = solution1727.largestSubmatrix(new int[][]{{0, 0, 1}, {1, 1, 1}, {1, 0, 1}});
        System.out.println(ans);
    }
}
