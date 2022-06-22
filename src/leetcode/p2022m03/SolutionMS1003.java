package leetcode.p2022m03;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/2
 * @time 9:07 PM
 */
public class SolutionMS1003 {

    public int search(int[] arr, int target) {
        if (arr[0] == target)
            return 0;
        int left  = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                int j = mid;
                while (j >= 0 && arr[j] == arr[mid]) {
                    j--;
                }
                return j + 1;
            }

            if (arr[mid] > arr[left]) {
                if (arr[left] <= target && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (arr[mid] < arr[left]) {
                if (arr[mid] < target && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        [1,1,1,1,1,2,1,1,1]
//        2
        int[]          array          = new int[]{12, 20, -21, -21, -19, -14, -11, -8, -8, -8, -6, -6, -4, -4, 0, 1, 5, 5, 6, 11, 11, 12};
        SolutionMS1003 solutionMS1003 = new SolutionMS1003();
        int            ans            = solutionMS1003.search(array, -8);
        System.out.println(ans);
    }

}
