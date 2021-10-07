package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/6
 * @time 10:07 PM
 */
public class Solution302 {
    public int minArea(char[][] image, int x, int y) {

        int m = image.length;
        int n = image[0].length;


        int minX=Integer.MAX_VALUE;
        int minY=Integer.MAX_VALUE;
        int maxX=Integer.MIN_VALUE;
        int maxY=Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (image[i][j]=='1'){
                    minX=Math.min(minX,i);
                    minY=Math.min(minY,j);
                    maxX=Math.max(maxX,i);
                    maxY=Math.max(maxY,j);
                }
            }
        }

        return (maxX-minX+1)*(maxY-minY+1);
    }

    public static void main(String[] args){
        Solution302 solution302=new Solution302();
        int ans=solution302.minArea(new char[][]
                {{'1'}},1,2);

        System.out.println(ans);
    }
}
