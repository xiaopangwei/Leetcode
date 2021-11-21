package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/11
 * @time 9:28 PM
 */
public class Solution1198 {
    public int smallestCommonElement(int[][] mat) {

        int m = mat.length;

        int n = mat[0].length;


        for (int i = 0; i < n; i++) {
            int target = mat[0][i];

            boolean flag = true;
            for (int k = 1; k < m; k++) {

                if (!search(mat[k], target)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return target;
            }
        }

        return -1;

    }

    private boolean search(int[] arr, int target) {
        int left  = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args){
        Solution1198 solution1198=new Solution1198();
        int ans=solution1198.smallestCommonElement(new int[][]{{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}});
        System.out.println(ans);

    }
}
