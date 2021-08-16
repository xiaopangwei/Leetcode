package demo.test20210120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/11
 * @time 11:46 PM
 */
public class Solution1030 {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {

        int[][] ans=new int[R*C][2];
        int[][] directions=new int[][]{
                {-1,0},{1,0},{0,1},{0,-1},
        };
        int k=0;
        boolean[][] visited=new boolean[R][C];

        Queue<int[]> queue=new LinkedList<>();
        int[] first=new int[]{r0,c0};
        queue.add(first);
        visited[r0][c0]=true;
        ans[k++]=first;
        while (!queue.isEmpty()){
            int[] temp=queue.poll();
            for (int i=0;i<directions.length;i++){
                int newX=temp[0]+directions[i][0];
                int newY=temp[1]+directions[i][1];
                if (isValid(newX,newY,R,C) && !visited[newX][newY]){
                    visited[newX][newY]=true;
                    int[] next=new int[]{newX,newY};
                    ans[k++]=next;
                    queue.add(next);
                }
            }
        }
        return ans;
    }


    private boolean isValid(int x,int y,int R ,int C){
        return x>=0 && x<R && y>=0 && y<C;
    }

    public static void main(String[] args){
        Solution1030 solution1030=new Solution1030();
        int[][] res=solution1030.allCellsDistOrder(3,3,0,2);
        for (int i=0;i<res.length;i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
