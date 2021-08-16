package leetcode.p2021m06.p20210628;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 9:40 PM
 */
public class Solution351 {
    public int numberOfPatterns(int m, int n) {

        List<Integer> data = new ArrayList<>();
        boolean[] visited = new boolean[10];
        int[] count=new int[1];
        for (int i=1;i<=9;i++){
            for(int j=m;j<=n;j++) {
                dfs(i, data, j, count, visited);
            }
        }
        return  count[0];
    }

    private void dfs(int index,List<Integer> list,final int m,final int[] count,boolean[] visited){

        if (list.size()+1==m){

            count[0]++;
            list.add(index);
//            System.out.println(" list:"+list);
            list.remove(list.size()-1);
            return;
        }
        Set<Integer> next =new HashSet<>();
        for (int item=1;item<=9;item++){
            if (index!=item && isNeigborhood(index,item,visited) && !visited[item]){
                next.add(item);
            }
        }

        list.add(index);
        visited[index]=true;
//        System.out.println("index:"+index+" nextMap:"+nextMap+" list:"+list);
        for (int nextIndex : next) {
            dfs(nextIndex, list, m, count,visited);
        }
        list.remove(list.size() - 1);
        visited[index]=false;

    }

    private int[] getXYByIndex(int index){
        int x=(index-1)/3;
        //index=6, x=1
        int y=(index-1)%3;
        return new int[]{x,y};
    }


    private boolean isNeigborhood(int index1,int index2,boolean[] visited){
       int[][] directions=new int[][]{
               {-1,-1},{-1,0},{-1,1},
               {0,-1},{0,1},
               {1,-1},{1,0},{1,1}
       };
        int[] coordinate1=getXYByIndex(index1);
        int[] coordinate2=getXYByIndex(index2);

        for (int i=0;i<directions.length;i++) {

            if (coordinate1[0] + directions[i][0] == coordinate2[0] &&
                    coordinate1[1] + directions[i][1] == coordinate2[1]) {
                return true;
            }
        }

        int absGap=Math.abs(coordinate1[0]-coordinate2[0])+Math.abs(coordinate1[1]-coordinate2[1]);
            if (absGap>=2){
                   if (coordinate1[0]==coordinate2[0]){
                       int middle=(index1+index2)/2;
                       if (visited[middle]){
                           return true;
                       }else{
                           return false;
                       }

                   }else if (coordinate1[1]==coordinate2[1]){
                       int middle=(index1+index2)/2;
                       if (visited[middle]){
                           return true;
                       }else{
                           return false;
                       }
                   }else{
                       if (coordinate1[0]+coordinate1[1]==coordinate2[0]+coordinate2[1] &&
                               coordinate2[0]+coordinate2[1]==2){
                           if (!visited[5]) return false;
                           else {return true;}

                       }
                       else if (coordinate1[0]==coordinate1[1] && coordinate2[0]==coordinate2[1])
                       {
                           if (!visited[5]) return false;
                           else {return true;}
                       }else{
                           return true;
                       }
                   }

               }


        return false;
    }
    public static void main(String[] args){
        Solution351 solution351=new Solution351();
        int ans=solution351.numberOfPatterns(1,3);
        System.out.println(ans);
    }
}
