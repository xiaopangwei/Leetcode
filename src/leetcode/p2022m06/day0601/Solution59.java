package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/6
 * @time 9:31 PM
 */
public class Solution59 {
    int[][] res;
    public int[][] generateMatrix(int n) {
        res=new int[n][n];
        dfs(0,0,1,n);
        return res;

    }

    public void dfs(int x,int y,int val,final int n){
        if(val>=n*n){
            if(res[x][y]==0){
                res[x][y]=val;
            }
            return;
        }
        int t1=x;
        int t2=y;
        while(y<n && res[x][y]==0){
            res[x][y++]=val++;
        }
        x++;
        y--;
        while(x<n && y>=0 && res[x][y]==0){
            res[x++][y]=val++;
        }
        x--;
        y--;
        while(y>=0 && x>=0 && res[x][y]==0){
            res[x][y--]=val++;
        }
        x--;
        y++;
        while(x>=0 && y<n && res[x][y]==0){
            res[x--][y]=val++;
        }
        dfs(t1+1,t2+1,val,n);
    }

    public static void main(String[] args){
        Solution59 solution59=new Solution59();
        int[][] ans=solution59.generateMatrix(2);
        System.out.println(ans);
    }
}
