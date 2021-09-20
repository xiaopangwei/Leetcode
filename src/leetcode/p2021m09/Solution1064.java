package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/19
 * @time 10:02 PM
 */
public class Solution1064 {
    public int fixedPoint(int[] arr) {

        int left  = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left >= 0 && left < arr.length && arr[left]==left) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution1064 solution1064 = new Solution1064();
        int          ans          = solution1064.fixedPoint(new int[]{-10, -5, -2, 0, 4, 5, 6, 7, 8, 9, 10});
        System.out.println(ans);
    }
}
