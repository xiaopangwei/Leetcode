package leetcode.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 2:58 PM
 */
public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m=matrix.length;
        int n=matrix[0].length;


        int startX=0;
        int startY=n-1;

        while (startX<m && startY>=0){
            if (matrix[startX][startY]==target){
                return true;
            }
            else if (matrix[startX][startY]<target){
                startX++;
            }else{
                startY--;
            }
        }

        return false;

    }


    public static void main(String[] args){
        int[][] matrix=new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        Solution240 solution240=new Solution240();
        System.out.println(solution240.searchMatrix(matrix,59));

    }


}
