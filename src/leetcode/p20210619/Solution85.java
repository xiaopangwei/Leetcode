package leetcode.p20210619;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 10:01 PM
 */
public class Solution85 {
    public int maximalRectangle(char[][] matrix) {

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
                } else {
                    left[i][j] = 0;
                }
                maxLeft=Math.max(maxLeft,left[i][j]);
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
                        int area=minWidth*height;
                        if (area>max){
                            max=area;
                        }
                    }
                }


            }
        }


        return Math.max(max,maxLeft);
    }


    public static void main(String[] args){
        Solution85 solution85=new Solution85();
        char[][] array=new char[][]{{'1','0','1','1','1'},{'0','1','0','1','0'},{'1','1','0','1','1'},{'1','1','0','1','1'},{'0','1','1','1','1'}};
        int area=solution85.maximalRectangle(array);
        System.out.println(area);

    }
}
