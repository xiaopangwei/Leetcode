package demo.szse.test20201123;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 11:30 AM
 */
public class Solution46 {

    List<List<Integer>> result=new ArrayList<>();
    public static void main(String[] args){
//

        Solution46 solution46 =new Solution46();
        System.out.println(solution46.permute(new int[]{1,2,3}));



    }


    public List<List<Integer>> permute(int[] nums) {

        permute(0,nums);

        return result;
    }


    public void permute(int idx,int[] nums) {

        if (idx==nums.length){
            List<Integer> list=new ArrayList<>();
            for (int item:nums) {
                list.add(item);
            }
            result.add(list);
        }

        for (int i=idx;i<nums.length;i++){

            swap(nums, idx, i);

            permute( idx+1, nums);

            swap(nums, i, idx);
        }

    }

    public void swap(int[] num,int i,int j){
        int temp=num[i];
        num[i]=num[j];
        num[j]=temp;
    }




}
