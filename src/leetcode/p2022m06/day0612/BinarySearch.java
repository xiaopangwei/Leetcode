package leetcode.p2022m06.day0612;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/13
 * @time 9:09 PM
 */
public class BinarySearch {
    public int lastLessThanOrEquals(int[] nums, int target) {
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
        return right;
    }

    public static void main(String[] args){
        BinarySearch binarySearch=new BinarySearch();
        int ans=binarySearch.lastLessThanOrEquals(new int[]{1,2,2,3,3,5,10},4);
        System.out.println(ans);
    }
}
