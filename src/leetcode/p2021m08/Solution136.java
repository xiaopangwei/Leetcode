package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/1
 * @time 11:26 PM
 */
public class Solution136 {
    public int singleNumber(int[] nums) {

        int sum=nums[0];
        for (int i=1;i<nums.length;i++){
            sum=sum ^ nums[i];
        }
        return sum;
    }

    public static void main(String[] args){
        Solution136 solution136=new Solution136();
//        int ans=solution136.singleNumber(new int[]{2,2,1});
       int a=1;
       int b=2;
        System.out.println(a^a);
        System.out.println(b^b);
        System.out.println(b^a);
        System.out.println(b^a^b);
//        System.out.println(ans);
    }
}
