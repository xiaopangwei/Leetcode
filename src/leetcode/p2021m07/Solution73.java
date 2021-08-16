package leetcode.p2021m07;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 3:39 PM
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {

        Set<Integer>  rows =new HashSet<>();
        Set<Integer>  cols =new HashSet<>();
        for (int i=0;i<matrix.length;i++){
            for ( int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

       for (int row:rows){
            for (int j=0;j<matrix[0].length;j++){
                matrix[row][j]=0;
            }
       }

        for (int col:cols){
            for (int i=0;i<matrix.length;i++){
                matrix[i][col]=0;
            }
        }
    }
}
