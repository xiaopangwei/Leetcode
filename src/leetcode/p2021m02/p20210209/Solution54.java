package leetcode.p2021m02.p20210209;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int[][] visited=new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++) {
            for (int j = 0;j < matrix[0].length; j++) {
                visited[i][j]=0;
            }
        }
        innerSpiralOrder(matrix,visited,0,ans);
        return ans;
    }



    public int[] getIndex(int[][] matrix,int[][] visited,int idx,boolean rowOrCols,boolean reverse){

        if (rowOrCols) {
            if (!reverse) {
                int max=-1;
                for (int i = 0; i < matrix[idx].length; i++) {
                    if (visited[idx][i] == 0) {
                        max = Math.max(max, i);
                    }
                }
                return new int[]{idx,max};
            }
            else{
                int min=Integer.MAX_VALUE;
                for (int i = matrix[idx].length-1; i>=0; i--) {
                    if (visited[idx][i] == 0) {
                        min = Math.min(min, i);
                    }
                }
                return new int[]{idx,min};
            }

        }
        else{
            if (!reverse) {
                int max=-1;
                for (int i = 0; i < matrix.length; i++) {
                    if (visited[i][idx] == 0) {
                        max = Math.max(max, i);
                    }

                }
                return new int[]{max,idx};
            }
            else{
                int min=Integer.MAX_VALUE;
                for (int i = matrix[idx].length-1; i>=0; i--) {
                    if (visited[idx][i] == 0) {
                        min = Math.min(min, i);
                    }
                }
                return new int[]{min,idx};
            }

        }

    }
    public void innerSpiralOrder(int[][] matrix,int[][] visited,int x,List<Integer> ans) {
        if (visited[x][x]==1 || !isValid(x,x,matrix)){
            return;
        }
        int[] cornor1= getIndex(matrix,visited,x,true,false);
        //列增大，行不变
        for (int i=x;i<=cornor1[1];i++){
            if (visited[x][i]==0) {
                ans.add(matrix[x][i]);
                visited[x][i] = 1;
            }
        }
        if (!isValid(cornor1[0],cornor1[1],matrix)){
            return;
        }
        int[] cornor2= getIndex(matrix,visited,cornor1[1],false,false);
        //列不变，行增大
        for (int i=cornor1[0]+1;i<=cornor2[0];i++){
            if (visited[i][cornor1[1]]==0) {
                ans.add(matrix[i][cornor1[1]]);
                visited[i][cornor1[1]] = 1;
            }
        }
        if (!isValid(cornor2[0],cornor2[1],matrix)){
            return;
        }
        int[] cornor3= getIndex(matrix,visited,cornor2[0],true,true);

        //行不变，列减小
        for (int i=cornor2[1]-1;i>=cornor3[1];i--){
            if (visited[cornor2[0]][i]==0) {
                ans.add(matrix[cornor2[0]][i]);
                visited[cornor2[0]][i] = 1;
            }
        }

        if (!isValid(cornor3[0],cornor3[1],matrix)){
            return;
        }

        int[] cornor4= getIndex(matrix,visited,cornor3[1],true,true);

        //列不变，行减小
        for (int i=cornor3[0]-1;i>=cornor4[0];i--){
            if (visited[i][cornor3[1]]==0) {
                ans.add(matrix[i][cornor3[1]]);
                visited[i][cornor3[1]] = 1;
            }
        }

//        if (!isValid(cornor4[0],cornor4[1],matrix)){
//            return;
//        }

        innerSpiralOrder(matrix, visited, x+1, ans);
    }


    public boolean isValid(int x,int y,int[][] matrix){
        int rows=matrix.length;
        int cols=matrix[0].length;
        return x<=rows-1 && x>=0 && y<=cols-1 && y>=0;
    }

    public static void main(String[] args){
        Solution54 solution=new Solution54();
//        int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> list=solution.spiralOrder(matrix);
        System.out.println(list);
//        solution.spiralOrder()
    }


}
