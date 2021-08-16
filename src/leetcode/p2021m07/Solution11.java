package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 5:24 PM
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int  left=0;
        int  right=height.length-1;
        int maxArea=-1;
        while (left<right){

            int width=right-left;
            int minHeight=Math.min(height[left],height[right]);
            System.out.println(width*minHeight);
            maxArea=Math.max(maxArea,width*minHeight);
            if (minHeight==height[left]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args){
        Solution11 solution11=new Solution11();
        int max=solution11.maxArea(new int[]{1});
        System.out.println(max);
    }

}
