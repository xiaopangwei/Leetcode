package leetcode.p2021m06.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 11:15 PM
 */
public class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int     m    = matrix.length;
        if (m<=0){
            return 0;
        }
        int     n    = matrix[0].length;
        int[][] left = new int[m][n];
        int maxLeft=-1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (j==0){
                        left[i][j] = 1;
                    }else {
                        left[i][j] = left[i][j - 1] + 1;
                    }
                    if (maxLeft<1){
                        maxLeft=1;
                    }
                } else {
                    left[i][j] = 0;
                }
            }
        }
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]=='1'){
                    int minWidth=Integer.MAX_VALUE;
                    for (int k=i-1;k>=0;k--){
                        if (matrix[k][j]!='1'){
                            minWidth=0;
                        }
                        int height=i-k+1;
                        if (left[i][j]<left[k][j]){
                            minWidth=Math.min(left[i][j],minWidth);
                        }else{
                            minWidth=Math.min(left[k][j],minWidth);
                        }
                        if (minWidth==height){
                        int area=minWidth*height;
                            if (area>max){
                                max=area;
                            }
                        }
                    }
                }
            }
        }


        return Math.max(max,maxLeft);
    }
    public static void main(String[] args){
        Solution221 solution221=new Solution221();
        System.out.println(solution221.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));

    }
}
