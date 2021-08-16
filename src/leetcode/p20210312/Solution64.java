package leetcode.p20210312;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/12
 * @time 2:26 PM
 */
public class Solution64 {


    Map<String,Integer> cached=new HashMap<>();
    public int minPathSum(int[][] grid) {

        return dfs(grid,0,0,grid.length-1,grid[0].length-1);
    }


    public int dfs(int[][] grid,int x1,int y1,final int x2,final int y2){

//        System.out.println(x1+":"+x2);
        if (x1==x2 && y1==y2){
           return grid[x2][y2];
        }
        String key=x1+"#"+y1;

        if (cached.containsKey(key)){
            return cached.get(key);
        }

        int res=Integer.MAX_VALUE;
        if (isValid(x1+1,y1,grid))
        {
            res=Math.min(dfs(grid,x1+1,y1,x2,y2)+grid[x1][y1],res);
        }
        if (isValid(x1,y1+1,grid))
        {
            res=Math.min(dfs(grid,x1,y1+1,x2,y2)+grid[x1][y1],res);
        }


        if (!cached.containsKey(key)){
            cached.put(key,res);
        }

        return res;

    }


    private boolean isValid(int x,int y,int[][] grid)
    {
        return x>=0&&y>=0&&x<grid.length&&y<grid[0].length;
    }
    public static void main(String[] args){

        int[][] array=new int[][]{{1,2,3},{4,5,6}};
//        int[][] array=new int[][]{{1,3,1},{1,5,1},{4,2,1}};

        Solution64 solution64=new Solution64();
        int ans=solution64.minPathSum(array);
        System.out.println(ans);
    }


}
