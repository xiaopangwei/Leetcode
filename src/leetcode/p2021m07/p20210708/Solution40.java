package leetcode.p2021m07.p20210708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/6
 * @time 10:45 AM
 */
public class Solution40 {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        dfs(candidates,new ArrayList<>(),target,new boolean[candidates.length],0,0);
        return  ans;

    }

    private void dfs(final int[] candidates,final List<Integer> data,
                     final int target,boolean[] visited,int currentSum,int startIndex){

        if (currentSum==target){
            List<Integer> temp=new ArrayList<>();
            temp.addAll(data);
//            System.out.println("Got it "+temp);
            ans.add(temp);
        }
        for (int i=startIndex;i<candidates.length;i++){
            if (visited[i]) {continue;}
            if (candidates[i]+currentSum>target) {continue;}
            if (i>0 && candidates[i]==candidates[i-1] && !visited[i-1]) {continue;}
            visited[i]=true;

            data.add(candidates[i]);
//            System.out.println("Pick "+i+" "+candidates[i]+" =>"+data);
            dfs(candidates,data,target,visited,currentSum+candidates[i],i);
            data.remove(data.size()-1);
//            System.out.println("Remove "+i+" "+candidates[i]+" =>"+data);
            visited[i]=false;
        }
    }

    public static void main(String[] args){
      Solution40 solution40=new Solution40();
      List<List<Integer>> res=solution40.combinationSum2(new int[]{10,1,2,7,6,1,5},8)    ;
      System.out.println(res);
    }
}
