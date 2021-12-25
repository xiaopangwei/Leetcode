package leetcode.p2021m12;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/23
 * @time 9:33 PM
 */
public class Solution885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {

        int     downMost  = rStart + 1;
        int     upMost    = rStart - 1;
        int     leftMost  = cStart - 1;
        int     rightMost = cStart + 1;
        int     count     = rows * cols;
        int     idx       = 0;
        int     x         = rStart;
        int     y         = cStart;
        int[][] delta     = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int     dir       = 0;
        int[][] ans       = new int[rows * cols][2];
        while (idx < count) {
            if (x >= 0 && x < rows && y >= 0 && y < cols) {
                int[] t = new int[]{x, y};
//                System.out.println(Arrays.toString(t));
                ans[idx++] = t;
            }

            if (dir==0 && y==rightMost){
                dir+=1;
                rightMost++;
            }


            else if (dir==1 && x==downMost){
                dir+=1;
                downMost++;
            }



            else if (dir==2 && y==leftMost){
                dir+=1;
                leftMost--;
            }


            else if (dir==3 && x==upMost){
                dir=0;
                upMost--;
            }


            x += delta[dir][0];
            y += delta[dir][1];

        }
        return ans;
    }


    public static void main(String[] args) {
        Solution885 solution885 = new Solution885();
        int[][]     ans         = solution885.spiralMatrixIII(5, 6, 1, 4);
        for (int[] arr : ans) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
