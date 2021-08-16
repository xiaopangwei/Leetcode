package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/20
 * @time 10:53 PM
 */
public class Solution1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {


        int[] newArray=new int[arr.length];
        System.arraycopy(arr,0,newArray,0,arr.length);
        Arrays.sort(newArray);
        newArray[0]=1;
        for (int i=1;i<newArray.length;i++){
            if (newArray[i]-newArray[i-1]>1){
                newArray[i]=newArray[i-1]+1;
            }
        }

        return newArray[newArray.length-1];
    }

    public static void main(String[] args){
        Solution1846 solution1846=new Solution1846();
        System.out.println(solution1846.maximumElementAfterDecrementingAndRearranging(new int[]{100,1,1000}));
    }
}
