package leetcode.p2021m06.p20210630;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 1:42 PM
 */
public class Solution13Offer {
    public int movingCount(int m, int n, int k) {


        boolean[][] visited=new boolean[m][n];
        int cnt=0;
        dfs(0,0,m,n,k,visited);

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (visited[i][j])
                {
                    cnt++;
                }
            }
        }

        return cnt;
    }


    //(m,n)
    private void dfs(int x,int y,final int m,final int n,final int k,final boolean[][] visited) {
        if (x==m-1 && y==n-1){
            if (isValid(x,y,m,n,k)) {
                visited[x][y] = true;
            }
            return;
        }

        if (isValid(x,y,m,n,k) && !visited[x][y]){
            visited[x][y]=true;
        }

        if (isValid(x-1,y,m,n,k) && !visited[x-1][y]){
            visited[x-1][y]=true;
            dfs(x-1,y,m,n,k,visited);
        }

        if (isValid(x+1,y,m,n,k) && !visited[x+1][y]){
            visited[x+1][y]=true;
            dfs(x+1,y,m,n,k,visited);
        }

        if (isValid(x,y+1,m,n,k) && !visited[x][y+1]){
            visited[x][y+1]=true;
            dfs(x,y+1,m,n,k,visited);
        }

        if (isValid(x,y-1,m,n,k) && !visited[x][y-1]){
            visited[x][y-1]=true;
            dfs(x,y-1,m,n,k,visited);
        }
    }

    private boolean isValid(int x,int y,int m,int n,int k){
        if (x<0 || y<0 || x>=m ||  y>=n ) {return false;}
        if (getDigitSum(x)+getDigitSum(y)>k) {return false;}
        return true;
    }


    public static void main(String[] args){
        Solution13Offer solution13Offer=new Solution13Offer();
        System.out.println(solution13Offer.movingCount(2,3,1));
        System.out.println(solution13Offer.movingCount(3,1,0));
    }

    private int getDigitSum(int data){
        int sum=0;
        int temp=data;
        while (temp!=0){
            sum+=temp%10;
            temp=temp/10;
        }
        return sum;
    }
}
