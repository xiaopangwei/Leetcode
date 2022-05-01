package common;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/4/12
 * @time 7:44 PM
 */
public class TestBinSearch {
    public int firstGreaterThan(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int firstGreaterThanOrEquals(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int lastLessThan(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;

            } else {
                left = mid + 1;
            }
        }
        return right;
    }

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
        TestBinSearch testBinSearch=new TestBinSearch();
        int[] array=new int[]{0,1,1,2,2,2,3,3,3,100};
        System.out.println("length=>"+array.length);
        System.out.println(testBinSearch.lastLessThanOrEquals(array,1));
    }
}
