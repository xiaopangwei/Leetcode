package demo.lcs;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/23
 * @time 5:11 PM
 */
public class SolutionLCS03 {
    private int maxArea=Integer.MIN_VALUE;
    private static final int[][] DIRECTIONS=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public int largestArea(String[] grid) {

        int rowLength=grid.length;
        int colLength=grid[0].length();

        if (rowLength<=1 || colLength<=1){
            return 0;
        }
        int[][] matrix=new int[rowLength][colLength];
        boolean[][] visited=new boolean[rowLength][colLength];
        //init
        for (int i=0;i<rowLength;i++){
            char[] array=grid[i].toCharArray();
            for (int j=0;j<colLength;j++){
                matrix[i][j]=array[j]-'0';
            }
        }



        for (int i=0;i<rowLength;i++) {
            for (int j=0;j<colLength;j++){
                if (!isZero(matrix,i,j,rowLength,colLength) && !visited[i][j]) {
                    visited[i][j] = true;
                    int[] area=new int[]{0};
                    dfs(matrix, i, j, rowLength, colLength, visited,area);
                    maxArea=Math.max(maxArea,area[0]);
                    visited[i][j] = false;
                }
            }
        }


        return Math.max(maxArea,0);

    }

    private boolean isZero(int[][] matrix,int x,int y,int m,int n){
        if (x==0||y==0||x==m-1||y==n-1||matrix[x][y]==0){
            return true;
        }
        return false;
    }
    private void dfs(final int[][] matrix,int p,int q,final int x,final int y,
                     final boolean[][] visited,int[] area){

        boolean flag=true;
        for (int i=0;i<DIRECTIONS.length;i++){
            int deltaX=DIRECTIONS[i][0];
            int deltaY=DIRECTIONS[i][1];
            int newP=p+deltaX;
            int newQ=q+deltaY;

            if (isValid(newP,newQ,x,y) && !visited[newP][newQ]){
                System.out.println("newP,newQ("+newP+","+newQ+")");
                if (matrix[p][q]==matrix[newP][newQ] && !isZero(matrix, newP, newQ, x, y)) {
                        visited[p+deltaX][q+deltaY]=true;
                        dfs(matrix, p + deltaX, q + deltaY, x, y, visited, area);
                        visited[p+deltaX][q+deltaY]=false;
                        area[0] += 1;
                }else if (matrix[p][q]==matrix[newP][newQ] && isZero(matrix, newP, newQ, x, y)){
                    return;
                }
            }else{
                return;
            }
        }

    }


    private boolean isValid(int x,int y,int m,int n){
        if (x<0||y<0||x>m-1||y>n-1){return false;}
        return true;
    }
    public static void main(String[] args){
        String[][] sample=new String[][]{
//                {"11111100000","21243101111","21224101221","11111101111"},
                {"110","231","221"},
                {"111","222","333"},
                {"000","010","000"}

        };
        for (int i=0;i<3;i++) {
            SolutionLCS03 solutionLCS03 = new SolutionLCS03();
            int           ans           = 0;
            ans = solutionLCS03.largestArea(sample[i]);
            System.out.println(ans);
        }
    }
}
