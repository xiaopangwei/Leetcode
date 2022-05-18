package leetcode.p2022m05.day0507;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 2:59 PM
 */
public class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        // 无序区间的右边界，实际上就是不满足从左到右递增的最后一个位置
        // 无序区间的左边界，实际上就是不满足从右到左递减的最前一个位置
        //从左往右找最后一个不满足单调递增的位置，它是无序区间的右边界
        int maxVal = Integer.MIN_VALUE;
        int to = -1;
        for(int i = 0;i < nums.length; ++i){
            if(nums[i] < maxVal) {to = i;System.out.println("left to:"+i+" "+nums[i]);}
            maxVal = Math.max(nums[i], maxVal);
            System.out.println(maxVal+" "+nums[i]);
        }

        //从右往左找最前一个不满足单调递减的位置，它是无序区间的左边界
        int minVal = Integer.MAX_VALUE;
        int from = nums.length;
        for(int i = nums.length - 1; i >= 0; --i){
            if(nums[i] > minVal) {from = i;System.out.println("right to:"+i+" "+nums[i]);}
            minVal = Math.min(nums[i], minVal);
        }

        System.out.println("res:"+from+" "+to);
        //如果完全有序
        if(to == -1) return 0;
        return to - from + 1;
    }

    public static void main(String[] args){
        Solution581 solution581=new Solution581();
        int ans=solution581.findUnsortedSubarray(new int[]{1,2,3,4,5});
        System.out.println(ans);
    }
}
