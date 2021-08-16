package leetcode.p20210701;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/2
 * @time 11:00 PM
 */
public class Solution169 {
    public int majorityElement(int[] nums) {
       int count=1;
       int major=nums[0];

       for (int i=1;i<nums.length;i++){
           if (major==nums[i]){
               count++;
           }else{
               count--;
               if (count<=0){
                   major=nums[i];
                   count=1;
               }
           }
       }

       return major;
    }

    public static void main(String[] args){
        int[] array=new int[]{1,3,1,1,4,1,1,5,1,1,6,2,2};
        Solution169 solution169=new Solution169();
        System.out.println(solution169.majorityElement(array));
    }
}
