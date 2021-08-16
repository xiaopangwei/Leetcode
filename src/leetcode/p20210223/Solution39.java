package leetcode.p20210223;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Solution39 {

    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {


        List<Integer> dataList=new ArrayList<>();
        dfs(dataList,candidates,target,0);
        System.out.println(res.size());
        return res;
    }

    private int sum(List<Integer> dataList){
        int sum=0;
        for (Integer i:dataList){
            sum+=i;
        }
        return sum;
    }


    public void dfs(List<Integer> dataList,final int[] candidates, final int target,int begin)
    {
        int sum=sum(dataList);

        if (sum==target)
        {
            res.add(new ArrayList<>(dataList));
            return;
        }
        for (int i=begin;i<candidates.length;i++){
            int item=candidates[i];
            if (item+sum<=target) {
                dataList.add(item);
                System.out.println("Before:"+dataList);
                dfs(dataList, candidates, target,i);
                dataList.remove(Integer.valueOf(item));
                System.out.println("After:"+dataList);
            }
            else{
                break;
            }
        }


    }
    public static void main(String[] args){
        Solution39          solution77 =new Solution39();
        int[] array=new int[]{2,3,5};
        Arrays.sort(array);
        List<List<Integer>> ans        =solution77.combinationSum(array,8);
        System.out.println(ans);

    }
}
