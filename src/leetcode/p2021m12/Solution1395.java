package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/30
 * @time 8:39 PM
 */
public class Solution1395 {
    public int numTeams(int[] rating) {
        int   len       = rating.length;
        int[] leftLess  = new int[len];
        int[] rightMore = new int[len];
        int[] leftMore  = new int[len];
        int[] rightLess = new int[len];

        for (int i = 1; i < len - 1; i++) {

            int pivot = rating[i];

            //
            for (int j = 0; j < i; j++) {
                if (rating[j] < pivot) {
                    leftLess[i]++;
                } else if (rating[j] > pivot) {
                    leftMore[i]++;
                }
            }

            for (int j = len - 1; j > i; j--) {
                if (rating[j] < pivot) {
                    rightLess[i]++;
                } else if (rating[j] > pivot) {
                    rightMore[i]++;
                }
            }
        }


        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += (rightLess[i] * leftMore[i]);
            ans += (rightMore[i] * leftLess[i]);
        }

        return ans;

    }

    public static void main(String[] args) {
        Solution1395 solution1395 = new Solution1395();
        int          ans          = solution1395.numTeams(new int[]{2,5,3,4,1});
        System.out.println(ans);
    }
}
