package leetcode.springfestival.sf20220202;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 3:31 PM
 */
public class BinarySearcher {

    //<=target的最大索引
    private int getLowerBound(int[] nums, int target) {
        int left  = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }


    //>(=)target的最大索引
    private int getUpperBound(int[] nums, int target) {
        int left  = -1;
        int right = nums.length;
        while (left + 1 != right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    // 1 3 5 5 5 8
    private int getLeftBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid]==target){
                right = mid;
            }else{
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    private int getRightBound(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return nums[right] == target ? right : -1;
    }

    public static void main(String[] args) {
        BinarySearcher binarySearcher = new BinarySearcher();
        int idx = binarySearcher.getRightBound(
                new int[]{-1, 0, 2, 2, 2, 9, 10},
                2);
        System.out.println(idx);
    }

}
