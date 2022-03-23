package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/2
 * @time 9:03 PM
 */
public class Solution136 {
    public int singleNumber(int[] nums) {
        int temp=nums[0];
        for (int i=1;i<nums.length;i++){
            temp=temp^nums[i];
        }
        return temp;
    }

    public static void main(String[] args){
        Solution136 solution136=new Solution136();
        int ans=solution136.singleNumber(new int[]{2,2,1});
        System.out.println(ans);
    }
}
