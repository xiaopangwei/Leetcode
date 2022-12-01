package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/28
 * @time 8:54 PM
 */
public class Solution2485 {
    public int pivotInteger(int n) {
        int left  = 1;
        int right = n;
        while (left <= right) {
            int mid      = (left + right) / 2;
            int leftSum  = (1 + mid) * mid / 2;
            int rightSum = (n + mid) * (n - mid + 1) / 2;
            if (leftSum == rightSum) {
                return mid;
            } else if (leftSum < rightSum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution2485 solution2485 = new Solution2485();
        System.out.println(solution2485.pivotInteger(1));
    }
}
