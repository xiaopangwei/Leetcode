package leetcode.p2022m05.day0501;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/1
 * @time 11:13 PM
 */
public class Solution11 {
    public int maxArea(int[] height) {
        int i       = 0;
        int j       = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            int width = j - i ;
            int h     = Math.min(height[i], height[j]);
            maxArea = Math.max(h * width, maxArea);
            if (height[i] == h) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args){
        Solution11 solution11=new Solution11();
        int max=solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(max);
    }
}
