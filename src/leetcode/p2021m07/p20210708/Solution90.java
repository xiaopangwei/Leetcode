package leetcode.p2021m07.p20210708;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/7
 * @time 11:06 AM
 */
public class Solution90 {
    private List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans.add(new ArrayList<>());
        Arrays.sort(nums);
        dfs(nums,nums.length,0,new ArrayList<>(),new boolean[nums.length]);
        return ans;
    }


    private void dfs(int[] nums,int len,int index,List<Integer> sub,boolean[] visited){

        if (index==len){
            return;
        }
        for (int i=index;i<len;i++){
            if (i>0 && nums[i]==nums[i-1] && !visited[i-1]) {continue;}
            visited[i]=true;
            sub.add(nums[i]);
                List<Integer> temp=new ArrayList<>();
                for (int num:sub){
                    temp.add(num);
                }
//            System.out.println(temp);
                ans.add(temp);

            dfs(nums,len,i+1,sub,visited);
            sub.remove(sub.size()-1);
            visited[i]=false;
        }

//        System.out.println(ans);

    }


    public static void main(String[] args){
        Solution90 solution90=new Solution90();
        List<List<Integer>>  ans=solution90.subsetsWithDup(new int[]{1,2,2});
        System.out.println(ans);
    }
}
