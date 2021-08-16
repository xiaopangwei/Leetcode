package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/22
 * @time 9:21 AM
 */
public class Solution130 {
    public void solve(char[][] board) {

        int rows=board.length;
        int cols=board[0].length;

        for (int i=0;i<rows;i++){
            if (board[i][0]=='O') {
                mark(board, i, 0,rows,cols);
            }
            if (board[i][cols-1]=='O') {
                mark(board, i, cols-1,rows,cols);
            }
        }


        for (int i=0;i<cols;i++){
            if (board[0][i]=='O') {
                mark(board, 0, i,rows,cols);
            }
            if (board[rows-1][i]=='O') {
                mark(board, rows-1, i,rows,cols);
            }
        }



        for (int i=1;i<rows-1;i++){
            for (int j=1;j<cols-1;j++){
                if (isValid(i-1,j,rows,cols) && isReachBound(i-1,j,rows,cols) && board[i-1][j]=='O'){
                    continue;
                }
                if (isValid(i+1,j,rows,cols) && isReachBound(i+1,j,rows,cols) && board[i+1][j]=='O'){
                    continue;
                }
                if (isValid(i,j-1,rows,cols) && isReachBound(i,j-1,rows,cols) && board[i][j-1]=='O'){
                    continue;
                }
                if (isValid(i,j+1,rows,cols) && isReachBound(i,j+1,rows,cols) && board[i][j+1]=='O'){
                    continue;
                }
                dfs(board,i,j,rows,cols);
            }
        }

        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }


    private void mark(char[][] board,int x,int y,final int rows,final int cols){
        if (isValid(x,y,rows,cols) && board[x][y]=='O'){
            board[x][y]='#';
            mark(board,x+1,y,rows,cols);
            mark(board,x-1,y,rows,cols);
            mark(board,x,y-1,rows,cols);
            mark(board,x,y+1,rows,cols);
        }
    }
    private void dfs(char[][] board,int x,int y,final int rows,final int cols){
        if (isValid(x,y,rows,cols) && !isReachBound(x,y,rows,cols) && board[x][y]=='O'){
            board[x][y]='X';
            dfs(board,x+1,y,rows,cols);
            dfs(board,x-1,y,rows,cols);
            dfs(board,x,y-1,rows,cols);
            dfs(board,x,y+1,rows,cols);
        }
    }

    public boolean isReachBound(int i,int j,int rows,int cols){
        if (i==0||j==0||i==rows-1||j==cols-1){
            return true;
        }
        return false;
    }

    public boolean isValid(int i,int j,int rows,int cols){
        if (i<0||j<0||i>=rows||j>=cols){
            return false;
        }
        return true;
    }


    public static void main(String[] args){
        Solution130 solution130=new Solution130();
//        char[][] array=new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
//        char[][] array=new char[][]{{'X'}};
//        char[][] array=new char[][]{{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'},{'O','O','O','O'}};
        char[][] array=new char[][]{{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};


        for (int i=0;i<array.length;i++) {
            System.out.println(Arrays.toString(array[i]));
        }

        solution130.solve(array);
        System.out.println("---------");
        for (int i=0;i<array.length;i++){
            System.out.println(Arrays.toString(array[i]));
        }
    }
}
