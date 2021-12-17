package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/3
 * @time 10:34 PM
 */
public class Solution845 {
    public int longestMountain(int[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        int[] left  = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = 0;
        right[arr.length - 1] = 0;

        int ans = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 0;
            }
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 0;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (left[i]>0 && right[i]>0) {
                ans = Math.max(ans, left[i] + right[i] + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution845 solution845 = new Solution845();
        int         ans         = solution845.longestMountain(new int[]{2,2,2});
        System.out.println(ans);
    }
}
