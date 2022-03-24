package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/31
 * @time 10:48 AM
 */
public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            return (getKthNum(nums1, nums2, length / 2 + 1) + getKthNum(nums1, nums2, length / 2)) * 1.0 / 2;
        }
        return getKthNum(nums1, nums2, length / 2+1);
    }

    private int getKthNum(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[nums2.length - 1];
        }
        if (nums2.length == 0) {
            return nums1[nums1.length - 1];
        }
        int start = Math.min(nums1[0], nums2[0]);
        int end   = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);
        while (start < end) {
            int mid  = start + (end - start) / 2;

            int cnt1 = lessThanOrEqualsCount(nums1, mid);
            int cnt2 = lessThanOrEqualsCount(nums2, mid);
            if (cnt1 + cnt2 < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private int lessThanOrEqualsCount(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        double ans=solution4.findMedianSortedArrays(new int[]{4, 5, 5, 10}, new int[]{2, 3, 4, 20, 34});
        System.out.println(ans);
        // 2 3 4 4 5 5 10 20 34
//        for (int i=1;i<=10;i++) {
//            int ans = solution4.getKthNum(new int[]{1, 4, 5, 5, 10}, new int[]{2, 3, 4, 20, 34}, i);
//            System.out.println(i+"th: "+ans);
//        }
    }


}
