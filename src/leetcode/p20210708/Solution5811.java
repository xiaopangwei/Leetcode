package leetcode.p20210708;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 10:49 PM
 */
public class Solution5811 {
//    红、绿、蓝
    static final int red=1;
    static final int green=2;
    static final int blue=3;
    static final int white=4;
    long kinds=0;
    public int colorTheGrid(int m, int n) {
        int[][] grid=new int[m][n];
        for (int i=0;i<m;i++) {
            Arrays.fill(grid[i],white);
        }

        dfs(grid,0,0);

        return (int)(kinds%(1000000007));
    }


    private void dfs(int[][] grid,int startX,int startY){
        if (startX==grid.length){
            kinds=(kinds+1)%(1000000007);
            return;
        }

        for (int i=1;i<=3;i++){
            if (isOneKindColor(grid,startX,startY,i)){
                continue;
            }
            grid[startX][startY]=i;
            if (startY<grid[0].length-1){
                dfs(grid,startX,startY+1);
            }else{
                dfs(grid,startX+1,0);
            }
            grid[startX][startY]=4;

        }
    }

    private  boolean isOneKindColor(int[][] grid,int startX,int startY,int type){
        if (isValid(grid,startX+1,startY)){
            if (grid[startX+1][startY]==type){
                return true;
            }
        }

        if (isValid(grid,startX-1,startY)){
            if (grid[startX-1][startY]==type){
                return true;
            }
        }

        if (isValid(grid,startX,startY+1)){
            if (grid[startX][startY+1]==type){
                return true;
            }
        }

        if (isValid(grid,startX,startY-1)){
            if (grid[startX][startY-1]==type){
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int[][] grid,int startX,int startY){
        if (startX<0 || startY<0 ||startX>= grid.length || startY>=grid[0].length){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        Solution5811 solution5811=new Solution5811();
        System.out.println(solution5811.colorTheGrid(2,37));
    }
}
