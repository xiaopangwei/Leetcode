package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 3:58 PM
 */
public class Solution200 {
    public int numIslands(char[][] grid) {

        int count=0;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        for (int i=0;i<grid.length;i++){
            {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1' && !visited[i][j]) {
                        dfs(grid,visited,i,j);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid,boolean[][] visited,int startX,int startY){
        visited[startX][startY]=true;
        if (isValid(grid,startX+1,startY) && grid[startX+1][startY]=='1' && !visited[startX+1][startY]){
            dfs(grid,visited,startX+1,startY);
        }

        if (isValid(grid,startX-1,startY) && grid[startX-1][startY]=='1' && !visited[startX-1][startY]){
            dfs(grid,visited,startX-1,startY);
        }

        if (isValid(grid,startX,startY+1) && grid[startX][startY+1]=='1' && !visited[startX][startY+1]){
            dfs(grid,visited,startX,startY+1);
        }

        if (isValid(grid,startX,startY-1) && grid[startX][startY-1]=='1' && !visited[startX][startY-1]){
            dfs(grid,visited,startX,startY-1);
        }
    }

    private boolean isValid(char[][] grid,int x,int y){
        if (x<0 || y<0 || x>=grid.length || y>=grid[0].length){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
//        char[][] array=new char[][]{ {'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] array=new char[][]{ {'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution200 solution200=new Solution200();
        int res=solution200.numIslands(array);
        System.out.println(res);
    }
}
