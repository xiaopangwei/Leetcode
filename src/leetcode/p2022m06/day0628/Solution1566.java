package leetcode.p2022m06.day0628;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/5
 * @time 9:44 PM
 */
public class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {

        for (int i = 0; i < arr.length; i++) {
            int j = i + m * k - 1;
            if (j >= arr.length) {
                break;
            }


            int     index   = i;
            int     overlap = 0;
            boolean flag    = true;
            for (int t = i + m; t <= j; t++) {
                if (arr[t] != arr[index]) {
                    flag = false;
                    break;
                } else {
                    index++;
                    if (index >= i + m) {
                        index = i;
                    }
                    overlap++;
                }
            }

            if (flag && overlap % m == 0 && 1 + overlap / m >= k) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1566 solution1566 = new Solution1566();
        boolean      ans          = solution1566.containsPattern(new int[]{2, 2}, 1, 2);
        System.out.println(ans);
    }
}
