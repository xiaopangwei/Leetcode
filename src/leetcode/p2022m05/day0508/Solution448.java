package leetcode.p2022m05.day0508;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/8
 * @time 10:14 PM
 */
public class Solution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - 1)%nums.length;
            nums[index]+=nums.length;
        }

        for (int i=0;i<nums.length;i++){
            if (nums[i]<=nums.length){ans.add(i+1);}
        }
        return ans;
    }

    public static void main(String[] args){
        Solution448      solution448=new Solution448();
        System.out.println(solution448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }
}
