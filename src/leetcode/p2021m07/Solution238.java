package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 5:17 PM
 */
public class Solution238 {
    public static void main(String[] args){
        Solution238 solution238=new Solution238();
        int[] in=new int[]{2,3,4,5};
        System.out.println(Arrays.toString(in));
        int[] ans=solution238.productExceptSelf(in);
        System.out.println(Arrays.toString(ans));
    }


    public int[] productExceptSelf(int[] nums) {

        int n=nums.length;
        int left=1,right=1;     //left：从左边累乘，right：从右边累乘

        int[] res=new int[nums.length];
        Arrays.fill(res,1);

        for(int i=0;i<n;++i)    //最终每个元素其左右乘积进行相乘得出结果
        {
            res[i]*=left;       //乘以其左边的乘积
            left*=nums[i];


            res[n-1-i]*=right;  //乘以其右边的乘积
            right*=nums[n-1-i];

            System.out.println("res["+i+"]:"+res[i]+" left:"+left+" res["+(n-1-i)+"]:"+res[n-1-i]+" right:"+right);
        }

        return res;

    }
}
