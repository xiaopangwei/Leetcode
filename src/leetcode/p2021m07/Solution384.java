package leetcode.p2021m07;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 11:17 PM
 */
public class Solution384 {

    private int[] nums;
    public Solution384(int[] nums) {

        this.nums=nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random=new Random();
        int length=nums.length;
        int[] indices=new int[length];
        Set<Integer> set=new HashSet<>();
        int k=0;
        while (true){
            int val=random.nextInt(length);
            if (!set.contains(val)){
                set.add(val);
                indices[k++]=val;
                if (k==length){
                    break;
                }
            }
        }
        int[] randomNumArray=new int[length];
        for (int i=0;i<length;i++){
            randomNumArray[i]=nums[indices[i]];
        }
        return randomNumArray;
    }

    public static void main(String[] args){
        Solution384 solution384=new Solution384(new int[]{1,2,3,4,5});
        System.out.println(Arrays.toString(solution384.shuffle()));
        System.out.println(Arrays.toString(solution384.reset()));
        System.out.println(Arrays.toString(solution384.shuffle()));
        System.out.println(Arrays.toString(solution384.reset()));
        System.out.println(Arrays.toString(solution384.shuffle()));
    }
}
