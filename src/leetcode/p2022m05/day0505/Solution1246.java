package leetcode.p2022m05.day0505;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/5
 * @time 10:50 PM
 */
public class Solution1246 {

    public int minimumMoves(int[] arr) {
        return dfs(arr, 0, arr.length - 1);
    }

    private int dfs(int[] arr, int start, int end) {
        System.out.println(start + " " + end);
        if (start > end) {
            return 0;
        }
        if (start == end) {
            return 1;
        }
        if (start + 1 == end) {
            if (arr[start] == arr[end]) {
                return 1;
            } else {
                return 2;
            }
        }

        int min = Integer.MAX_VALUE;
        if (arr[start] == arr[end]) {
            min = dfs(arr, start + 1, end - 1);
        }

        for (int i = start; i <= end; i++) {
            if (start <= i && i + 1 <= end) {
                min = Math.min(dfs(arr, start, i) + dfs(arr, i + 1, end), min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Solution1246 solution1246 = new Solution1246();
        int          ans          = solution1246.minimumMoves(new int[]{1, 3, 4, 1, 5});
        System.out.println(ans);
    }
}
