package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/13
 * @time 2:27 PM
 */
public class Solution540 {
    public int singleNonDuplicate(int[] nums) {

        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
//            System.out.println(left + " ==> " + right);
            int     mid  = (left + right) / 2;
            int     prev = mid - 1;
            int     next = mid + 1;
            boolean flag = false;

            boolean leftOrRight = true;

            int leftLength = -1;

            int rightLength = -1;
            if (prev >= 0) {
                if (nums[prev] == nums[mid]) {
                    flag = true;
                    leftLength = prev - left;
                    leftOrRight = true;
                }
            }
            if (next < nums.length) {
                if (nums[next] == nums[mid]) {
                    flag = true;
                    rightLength = right - next;
                    leftOrRight = false;
                }
            }

            if (!flag) {
                return nums[mid];
            }


            if (leftOrRight) {
                if (leftLength != -1 && leftLength % 2 == 0) {
                    left = mid + 1;
                } else {
                    right = prev - 1;
                }

            } else {
                if (rightLength != -1 && rightLength % 2 == 0) {
                    right = mid - 1;
                } else {
                    left = next + 1;
                }
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        Solution540 solution540 = new Solution540();
        int         ans         = solution540.singleNonDuplicate(new int[]{0,1,1,2,2});
        System.out.println(ans);
    }
}
