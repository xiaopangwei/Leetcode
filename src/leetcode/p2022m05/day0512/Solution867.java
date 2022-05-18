package leetcode.p2022m05.day0512;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:35 PM
 */
public class Solution867 {
    public int[][] transpose(int[][] matrix) {

        int[][] copy = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {

                copy[i][j] = matrix[j][i];

            }
        }
        return copy;
    }
}
