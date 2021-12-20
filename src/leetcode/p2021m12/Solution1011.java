package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/18
 * @time 3:57 PM
 */
public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int maxVal = Integer.MIN_VALUE;
        int sumVal = 0;
        for (int w : weights) {
            maxVal = Math.max(maxVal, w);
            sumVal += w;
        }

        int left  = maxVal;
        int right = sumVal;

        while (left < right) {
            int mid = (left + right) / 2;
            int t   = 0;
            int s   = 0;
            for (int i = 0; i < weights.length; i++) {
                if (s + weights[i] > mid) {
                    t++;
                    s = weights[i];
                } else {
                    s += weights[i];
                }
            }

            if (t+1 <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args){
        Solution1011 solution1011=new Solution1011();
        int ans=solution1011.shipWithinDays(new int[]{3,2,2,4,1,4},3);
        System.out.println(ans);
    }
}
