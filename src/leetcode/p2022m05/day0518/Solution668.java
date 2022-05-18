package leetcode.p2022m05.day0518;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/18
 * @time 7:48 PM
 */
public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        int left  = 1;
        int right = m * n;
        while (left < right) {
            int mid  = left + (right - left) / 2;
            int temp = getLessThanOrEqualsCnt(m, n, mid);
            if (temp < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getLessThanOrEqualsCnt(int m, int n, int target) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            int temp = Math.min(n, target / i);
            cnt += temp;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution668 solution668 = new Solution668();
        int         ans         = solution668.findKthNumber(2, 3, 6);
        System.out.println(ans);
    }
}
