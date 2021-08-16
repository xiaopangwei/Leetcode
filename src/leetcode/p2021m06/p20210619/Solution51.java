package leetcode.p2021m06.p20210619;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/23
 * @time 11:28 AM
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans=new ArrayList<>();
        boolean[][] visited=new boolean[n][n];
        List<Coordinate> done=new ArrayList<>();
        dfs(n,0,done,visited,ans);
        return ans;

    }

    class Coordinate{
        public int x;
        public int y;
        public Coordinate(int x,int y){
            this.x=x;
            this.y=y;
        }

    }

    private <T extends Coordinate> List<String> copy(List<T> src){
        List<String> target=new ArrayList<>();
        int len=src.size();
        String[][] matrix=new String[len][len];
        for (int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                matrix[i][j]=".";
            }
        }
        for (T item:src){
            matrix[item.x][item.y]="Q";
        }

        for (int i=0;i<len;i++){
           StringBuilder sb=new StringBuilder();
            for (int j=0;j<matrix[i].length;j++){
               sb.append(matrix[i][j]);
            }
            target.add(sb.toString());
        }

        return target;
    }
    public void dfs(final int max,int row,List<Coordinate> already,boolean[][] visited,List<List<String>> ans){
        if (max==row){
            ans.add(copy(already));
            return;
        }
        for (int i=0;i<max;i++) {
            //(row,i)
            if (!visited[row][i] && isValid(already,max,row,i)) {
                visited[row][i]=true;
                already.add(new Coordinate(row,i));
                dfs(max,row+1,already,visited,ans);
                visited[row][i]=false;
                already.remove(already.size()-1);
            }
        }
    }

    private boolean isValid(List<Coordinate> already,int n,int x,int y){
        if (x>=n||y>=n||x<0||y<0){
            return false;
        }
        for (Coordinate item:already){
            if (item.x==x||item.y==y){
                return false;
            }else{
                if (item.x+item.y==x+y){
                    return false;
                }
                else if (item.x-item.y==x-y){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution51 solution51=new Solution51();
        List<List<String>> ans=solution51.solveNQueens(4);
        System.out.println(ans);
    }
}
