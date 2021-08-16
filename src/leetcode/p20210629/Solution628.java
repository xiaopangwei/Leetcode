package leetcode.p20210629;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/29
 * @time 10:31 PM
 */
public class Solution628 {
    public int maximumProduct(int[] nums) {
        List<Integer> positive=new ArrayList<>();
        List<Integer> negative=new ArrayList<>();
        List<Integer> zero=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zero.add(nums[i]);
            }else if (nums[i]<0){
                negative.add(nums[i]);
            }else{
                positive.add(nums[i]);
            }
        }

        Collections.sort(positive, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1>=o2){
                    return -1;
                }
                return 1;
            }
        });
        Collections.sort(negative);


        int maxVal=Integer.MIN_VALUE;
        if (!zero.isEmpty())
        {
            maxVal=0;
        }
        if (positive.size()>=3){
            maxVal=Math.max(maxVal,positive.get(0)*positive.get(1)*positive.get(2));
        }
        if (negative.size()>=2){
            if (positive.size()>=1) {
                maxVal = Math.max(maxVal,negative.get(0) * negative.get(1) * positive.get(0));
            }else if (!zero.isEmpty())
            {
                maxVal = Math.max(maxVal,0);
            }else{
                int maxIndex=negative.size()-1;
                maxVal = Math.max(maxVal,negative.get(maxIndex) * negative.get(maxIndex-1) * negative.get(maxIndex-2));
            }
        }

        return maxVal;

    }

    public static void main(String[] args){

        int[] test=new int[]{-1,-2,-3,-4,0};
        Solution628 solution628=new Solution628();
        System.out.println(solution628.maximumProduct(test));



    }
}
