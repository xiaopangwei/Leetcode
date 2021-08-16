package leetcode.p20210630;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 10:53 AM
 */
public class Solution36 {
    public boolean isValidSudoku(char[][] board) {


        for (int i=0;i<9;i++){
            Map<Character,Integer> freq=new HashMap<>();
            for (int j=0;j<9;j++){
                if (board[i][j]!='.')
                {
                    if (freq.containsKey(board[i][j])){

                            return false;

                    }else{
                        freq.put(board[i][j],1);
                    }
                }
            }
        }



        //i 列的编号
        for (int i=0;i<9;i++){
            Map<Character,Integer> freq=new HashMap<>();
            for (int j=0;j<9;j++){
                if (board[j][i]!='.')
                {
                    if (freq.containsKey(board[j][i])){

                            return false;

                    }else{
                        freq.put(board[j][i],1);
                    }
                }
            }
        }


        int[][] leftUpCoordinate=new int[][]{
                {0,0},{0,3},{0,6},
                {3,0},{3,3},{3,6},
                {6,0},{6,3},{6,6},
        };


        for (int i=0;i<leftUpCoordinate.length;i++){
            int x=leftUpCoordinate[i][0];
            int y=leftUpCoordinate[i][1];
            Map<Character,Integer> freq=new HashMap<>();
            for (int m=x;m<x+3;m++){
                for (int n=y;n<y+3;n++){
                    if (board[m][n]!='.')
                    {
                        if (freq.containsKey(board[m][n])){

                                return false;

                        }else{
                            freq.put(board[m][n],1);
                        }
                    }
                }
            }
        }
        return true;

    }

    public static void main(String[] args){
        char[][] charArray1=new char[][]
                {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        Solution36 solution36=new Solution36();
        System.out.println(solution36.isValidSudoku(charArray1));
    }
}
