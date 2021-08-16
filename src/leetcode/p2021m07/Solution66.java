package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 11:35 PM
 */
public class Solution66 {
    public int[] plusOne(int[] digits) {

        int idx=digits.length-1;
        int carry=0;
        digits[idx]=digits[idx]+1;
        while (idx>=0){
            int sum=digits[idx]+carry;
            digits[idx]=sum%10;
            carry=sum/10;
            idx--;
        }

        List<Integer>  carryList=new ArrayList<>();
        if (carry==0){
            return digits;
        }else {
            while (carry != 0) {
                carryList.add(carry % 10);
                carry /= 10;
            }
            int[] newArray=new int[digits.length+carryList.size()];
            int k=0;
            for (int item:carryList){
                newArray[k++]=item;
            }
            System.arraycopy(digits,0,newArray,k,digits.length);
            return newArray;
        }
    }

    public static void main(String[] args){
        Solution66 solution66=new Solution66();
        int[] array=new int[]{0};
        System.out.println(Arrays.toString(solution66.plusOne(array)));
    }
}
