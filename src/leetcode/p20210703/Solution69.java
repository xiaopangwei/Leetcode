package leetcode.p20210703;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/4
 * @time 11:09 PM
 */
public class Solution69 {
    public List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        dfs(nums,new ArrayList<>(),new boolean[nums.length]);
        return  ans;
    }

    private void dfs(final int[] num,List<Integer> slice,boolean[] visited){

        if (slice.size()==num.length){
            List<Integer> temp=new ArrayList<>();
            for (Integer item:slice){
                temp.add(item);
            }
            ans.add(temp);
            return;
        }

        for (int i=0;i<num.length;i++){
            if (visited[i]) {continue;}
            if (i>0 && num[i]==num[i-1] && !visited[i-1]) {continue;}
            visited[i]=true;
            slice.add(num[i]);
            dfs(num,slice,visited);
            slice.remove(slice.size()-1);
            visited[i]=false;
        }
    }

    public static void main(String[] args){
        Solution69 solution69=new Solution69();
        List<List<Integer>> data=solution69.permuteUnique(new int[]{1,1,2});
        System.out.println(data);
    }

}
