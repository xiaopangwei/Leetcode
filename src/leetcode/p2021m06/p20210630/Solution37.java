package leetcode.p2021m06.p20210630;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 10:51 AM
 */
public class Solution37 {
    public void solveSudoku(char[][] board) {

       List<int[]> blank=new ArrayList<>();
       for (int i=0;i<9;i++){
           for (int j=0;j<9;j++) {
               if (board[i][j] == '.') {
                   blank.add(new int[]{i,j});
               }
           }
       }

       dfs(board,0,blank);
    }


    //0-8
    //int x =startX/3*3
    //int y= startY/3*3
    private boolean dfs(final char[][] board,int index,final List<int[]> blank) {
        if (blank.size()==index){
            return true;
        }
        int startX=blank.get(index)[0];
        int startY=blank.get(index)[1];
        boolean isCanGoOn=false;
        Set<Character> characterSet = getHappendCharSet(board, startX, startY);
        for (int i = 1; i <= 9; i++) {
            char ch=(char)(i+'0');
                if (!characterSet.contains(ch)) {
                    board[startX][startY]=ch;
//                    System.out.println(startX+" "+startY+" => "+board[startX][startY]);
                    boolean flag=dfs(board, index+1,blank);
                    if (!flag){
                        board[startX][startY]='.';
                    }else{
                        isCanGoOn=true;
                        return true;
                    }
                }
        }
        if (!isCanGoOn){return false;}
        return true;
    }

    private Set<Character> getHappendCharSet(final char[][] board, int x, int y){
        int leftUpX=x/3*3;
        int leftUpY=y/3*3;
        Set<Character> happendCharSet=new HashSet<>();
        for (int i=0;i<9;i++){
            if (board[x][i]!='.'){
                happendCharSet.add(board[x][i]);
            }
        }

        for (int i=0;i<9;i++){
            if (board[i][y]!='.'){
                happendCharSet.add(board[i][y]);
            }
        }

        for (int i=leftUpX;i<leftUpX+3;i++){
            for (int j=leftUpY;j<leftUpY+3;j++){
                if (board[i][j]!='.'){
                    happendCharSet.add(board[i][j]);
                }
            }
        }
        return happendCharSet;
    }

    public static void main(String[] args){
        char[][] charArray=new char[][]{{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};
        Solution37 solution37=new Solution37();
        solution37.solveSudoku(charArray);
        for (int i=0;i<9;i++){
            System.out.println(Arrays.toString(charArray[i]));
        }
    }
}
