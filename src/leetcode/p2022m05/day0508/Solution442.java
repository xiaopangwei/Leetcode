package leetcode.p2022m05.day0508;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 9:48 AM
 */
public class Solution442 {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = (nums[i] - 1)%n;
            nums[index] += n;
            System.out.println(Arrays.toString(nums));
        }

//        System.out.println(Arrays.toString(nums));
        List<Integer> ans=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>2*n){
                ans.add(i+1);
            }
        }
        return  ans;
    }

    public static void main(String[] args){
        Solution442 solution442=new Solution442();
        System.out.println(solution442.findDuplicates(new int[]{4,3,2,1}));
    }
}
