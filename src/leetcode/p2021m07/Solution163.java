package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 11:13 AM
 */
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ans=new ArrayList<>();
        if (nums.length==0){
            if (lower!=upper){
                ans.add(String.format("%d->%d",lower,upper));
            }else{
                ans.add(String.valueOf(lower));
            }

            return ans;
        }
        if (lower<nums[0]){
            if (nums[0]-lower==1){
                ans.add(String.valueOf(lower));
            }else{
                ans.add(String.format("%d->%d",lower,nums[0]-1));
            }
        }
        for (int i=0;i<nums.length-1;i++){
            if (nums[i]<nums[i+1]-1){
                if (nums[i+1]-nums[i]==2){
                    ans.add(String.valueOf(nums[i]+1));
                }else{
                    ans.add(String.format("%d->%d",nums[i]+1,nums[i+1]-1));
                }
            }
        }
        int last=nums[nums.length-1];
        //98
        //100
        if (last<upper){
            if (upper-last==1){
                ans.add(String.valueOf(last+1));
            }else{
                ans.add(String.format("%d->%d",last+1,upper));
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Solution163 solution163=new Solution163();
        System.out.println(solution163.findMissingRanges(new int[]{-1},-2,-1));
    }
}
