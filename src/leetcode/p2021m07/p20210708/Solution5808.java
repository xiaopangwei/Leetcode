package leetcode.p2021m07.p20210708;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/11
 * @time 9:37 PM
 */
public class Solution5808 {
    public int[] getConcatenation(int[] nums) {

        int len=nums.length;
        int[]  array=new int[len*2];
        System.arraycopy(nums,0,array,0,len);
        System.arraycopy(nums,0,array,len,len);

        return array;
    }

    public static void main(String[] args){
        Solution5808 solution5808=new Solution5808();
        System.out.println(Arrays.toString(solution5808.getConcatenation(new int[]{1,2,3,4})));
        System.out.println(Arrays.toString(solution5808.getConcatenation(new int[]{1})));
    }
}
