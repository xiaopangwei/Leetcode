package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 11:25 AM
 */
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left  = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int   mid      = (left + right) / 2;
            int[] idxArray = unFlat(matrix, mid);

            int x = idxArray[0];
            int y = idxArray[1];

            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    private int[] unFlat(final int[][] matrix, int index) {
        int n = matrix[0].length;
        return new int[]{index / n, index - (index / n) * n};
    }

    public static void main(String[] args){
        Solution74 solution74=new Solution74();
        boolean ans=solution74.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},13);
        System.out.println(ans);
    }
}
