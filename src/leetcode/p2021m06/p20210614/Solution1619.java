package leetcode.p2021m06.p20210614;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/17
 * @time 3:27 PM
 */
public class Solution1619 {
    public int[] pondSizes(int[][] land) {
        List<Integer> result  =new ArrayList<>();
        boolean[][]   visited =new boolean[land.length][land[0].length];
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if (!visited[i][j] && land[i][j]==0){
                    int visitedCount=dfs(land,i,j,visited);
                    result.add(visitedCount);
                }
            }
        }

//        //visitedCount
//        int[] intArray=new int[result.size()];
//        int idx=0;
//        for(int i=0;i<result.size();i++){
//            if (i==0){
//                intArray[idx++]=result.get(i);
//            }
//            else{
//                intArray[idx++]=result.get(i)-result.get(i-1);
//            }
//        }


        Collections.sort(result);
        int[] ans=new int[result.size()];
        for (int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }


         return ans;
    }


    private boolean isLand(final int[][] land,int x,int y,boolean[][] visited){
        return isValid(land,x,y) && land[x][y]==0 && !visited[x][y];
    }
//
//    private int getZeroCount(final int[][] land,boolean[][] visited){
//        int count=0;
//        for (int i=0;i<land.length;i++){
//            for (int j=0;j<land[0].length;j++){
//                if (visited[i][j]){
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    private int dfs(final int[][] land,int x,int y,boolean[][] visited){
       visited[x][y]=true;

       int area=1;
        if (isLand(land, x-1, y-1, visited)){
            area+=dfs(land, x-1, y-1, visited);
        }
       if (isLand(land, x-1, y, visited)){
           area+=dfs(land, x-1, y, visited);
       }
        if (isLand(land, x-1, y+1, visited)){
            area+=dfs(land, x-1, y+1, visited);
        }


       if (isLand(land, x, y-1, visited)){
           area+=dfs(land, x, y-1, visited);
       }
       if (isLand(land, x, y+1, visited)){
           area+=dfs(land, x, y+1, visited);
       }
       if (isLand(land, x+1, y-1, visited)){
           area+=dfs(land, x+1, y-1, visited);
        }
       if (isLand(land, x+1, y, visited)){
           area+= dfs(land, x+1, y, visited);
        }

        if (isLand(land, x+1, y+1, visited)){
            area+=dfs(land, x+1, y+1, visited);
        }
        return area;
    }

    private boolean isValid(final int[][] land,int x,int y){
        if (x>=land.length||y>=land[0].length||x<0||y<0){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Solution1619 solution1619=new Solution1619();
        int[][] src=new int[][]{
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
                };
        System.out.println(Arrays.toString(solution1619.pondSizes(src)));
    }
}
