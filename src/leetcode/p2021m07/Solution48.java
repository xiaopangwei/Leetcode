package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 3:20 PM
 */
public class Solution48 {
    public void rotate(int[][] matrix) {

        final int len=matrix.length;
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++)
            {
                if (j>i){
                    swap(matrix,i,j,j,i);
                }
            }
        }

        for (int i=0;i<len;i++){
            for (int j=0;j<len/2;j++)
            {

               swap(matrix,i,j,i,len-1-j);

            }
        }


//        for (int i=0;i<len;i++){
//
//            System.out.println(Arrays.toString(matrix[i]));
//        }

    }

    private void swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int temp=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=temp;
    }

    public static void main(String[] args){
        Solution48 solution48=new Solution48();
        solution48.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
