package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 4:30 PM
 */
public class Solution769 {
    public int maxChunksToSorted(int[] arr) {
        int maxVal = -1;
        int res    = 0;
        for (int i = 0; i < arr.length; i++) {
            maxVal = Math.max(arr[i], maxVal);
            if (maxVal == i) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution769 solution769=new Solution769();
        int ans=solution769.maxChunksToSorted(new int[]{1,0,2,3,4});
        System.out.println(ans);
    }
}
