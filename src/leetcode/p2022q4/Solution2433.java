package leetcode.p2022q4;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/29
 * @time 9:39 PM
 */
public class Solution2433 {
    public int[] findArray(int[] pref) {
        int[] originalArray = new int[pref.length];
        originalArray[0] = pref[0];
        for (int i=1;i<pref.length;i++){
            originalArray[i]=pref[i] ^ pref[i-1];
        }
//        System.out.println(Arrays.toString(originalArray));
        return originalArray;
    }

    public static void main(String[] args){
        Solution2433 solution2433=new Solution2433();
        solution2433.findArray(new int[]{5,2,0,3,1});
    }
}
