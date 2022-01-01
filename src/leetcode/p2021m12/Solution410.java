package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/26
 * @time 8:13 PM
 */
public class Solution410 {





    public int splitArray(int[] nums, int m) {

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left  = max;
        int right = sum;

        //7,2,5,10,8 32/5=6
        //10 32 => 21
        //press
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println(left + " " + right + " " + mid);
            if (check(nums, mid, m)) {
                //press
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    private boolean check(int[] nums, int mid, int m) {
        int s = 0;
        int t = 1;
        for (int n : nums) {
            if (s + n <= mid) {
                s += n;
            } else {
                t++;
                s = n;
            }
        }
        return t <= m;
    }


    public static void main(String[] args) {
        Solution410 solution410 = new Solution410();
        int         ans         = solution410.splitArray(new int[]{7, 2, 5, 10, 8}, 2);
        System.out.println(ans);
    }
}
