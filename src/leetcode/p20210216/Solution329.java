package leetcode.p20210216;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution329 {
    private Map<String,Integer> cached=new HashMap<>();
    public int longestIncreasingPath(int[][] matrix) {
        int max=-1;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                int[][] visited=new int[matrix.length][matrix[0].length];
                int temp=longestIncreasingPath(matrix,visited,i,j);
//                System.out.println(i+","+j+" "+matrix[i][j]+" "+temp);
                max=Math.max(max,temp);
            }
        }
        return max;
//        int[][] visited=new int[3][3];
//        int temp=longestIncreasingPath(matrix,visited,2,1);
//        return temp;
    }


    public int longestIncreasingPath(int[][] matrix,int[][] visited,int x,int y) {

        String key=x+"#"+y;
        if (cached.containsKey(key)){
            return cached.get(key);
        }
        List<Integer> result =new ArrayList<>();
        //left
        if (isValid(matrix,x-1,y,visited) && matrix[x-1][y]>matrix[x][y]){
            visited[x-1][y]=1;
            result.add(longestIncreasingPath(matrix,visited, x-1, y));
            visited[x-1][y]=0;
        }
        //right
        if(isValid(matrix,x+1,y,visited) && matrix[x+1][y]>matrix[x][y]){
            visited[x+1][y]=1;
            result.add(longestIncreasingPath(matrix,visited, x+1, y));
            visited[x+1][y]=0;
        }
        //up
        if(isValid(matrix,x,y-1,visited) && matrix[x][y-1]>matrix[x][y]){
            visited[x][y-1]=1;
            result.add(longestIncreasingPath(matrix,visited, x, y-1));
            visited[x][y-1]=0;
        }
        //down
        if(isValid(matrix,x,y+1,visited) && matrix[x][y+1]>matrix[x][y]){
            visited[x][y+1]=1;
            result.add(longestIncreasingPath(matrix,visited, x, y+1));
            visited[x][y+1]=0;
        }


        int ans=0;

        if (result.isEmpty()){
            ans= 1;
        }
        else {
            ans=result.stream().max(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            }).get() + 1;
        };

        cached.put(key,ans);
        return ans;
    }


    public boolean isValid(int[][] matrix,int x,int y,int[][] visited){
        if (x>=0 && x<=matrix.length-1
                && y>=0 && y<=matrix[0].length-1 && visited[x][y]==0)
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        Solution329 solution329=new Solution329();
//        int[][] matrix=new int[][]{{1}};
//        int[][] matrix=new int[][]{{3,4,5},{3,2,6},{2,2,1}};
//        int[][] matrix=new int[][]{{9,9,4},{6,6,8},{2,1,1}};

        int[][] matrix=new int[][]{{7,8,9},{9,7,6},{7,2,3}};
        System.out.println(solution329.longestIncreasingPath(matrix));

    }
}
