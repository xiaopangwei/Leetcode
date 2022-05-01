package leetcode.springfestival.pm20220205;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/1
 * @time 3:47 PM
 */
public class Solution794 {
    public boolean validTicTacToe(String[] board) {

        int xCount = count(board, 'X');
        int oCount = count(board, 'O');

        if (xCount < oCount || xCount - oCount > 1) {
            return false;
        }

        boolean xWin = false;
        boolean oWin = false;

        xWin = board[0].equals("XXX") || board[1].equals("XXX") || board[2].equals("XXX")
                || (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X')
                || (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X');

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') {
                xWin = true;
                break;
            }
        }


        oWin = board[0].equals("OOO") || board[1].equals("OOO") || board[2].equals("OOO")
                || (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O')
                || (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O');

        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') {
                oWin = true;
                break;
            }
        }


        if (xWin && oWin) {
            return false;
        }


        if (xWin && xCount == oCount) {
            return false;
        }

        if (oWin && xCount != oCount) {
            return false;
        }


        return true;
    }

    private int count(String[] board, char ch) {
        int cnt = 0;
        for (String item : board) {
            for (int i = 0; i < item.length(); i++) {
                if (item.charAt(i) == ch) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution794 solution794 = new Solution794();

        boolean     ans         = solution794.validTicTacToe(new String[]{"OXX","XOX","OXO"});
        System.out.println(ans);

    }
}
