package leetcode.p2021m07;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 5:00 PM
 */
public class Solution80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int length=nums.length;
        int i=0;
        int fillIndex=0;
        int j=0;
        while (true){
            int target=nums[i];
            while (i<length && nums[i]==target){
                i++;
            }
            if (i<length){
                int prevLength=i-j;
                if (prevLength>=2){
                    nums[fillIndex++]=target;
                    nums[fillIndex++]=target;
                }else{
                    nums[fillIndex++]=target;
                }
                j=i;
            }else{
                break;
            }
        }

//        System.out.println(fillIndex+" "+j+" "+i);
        int count=0;
        while (j<length){
            nums[fillIndex++]=nums[j];
            count++;
            if (count==2){
                break;
            }
            j++;
        }
        return fillIndex;
    }

    public static void main(String[] args){
        Solution80 solution80=new Solution80();
        int[] array=new int[]{0,0,0};
        int ans=solution80.removeDuplicates(array);
        System.out.println(ans);
        System.out.println(Arrays.toString(array));
    }
}
