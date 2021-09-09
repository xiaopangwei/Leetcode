package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 9:37 PM
 */
public class Solution1151 {
    public int minSwaps(int[] data) {

        int oneCount = 0;
        for (int item : data) {
            if (item == 1) {
                oneCount++;
            }
        }

        int left  = 0;
        int right = left + oneCount - 1;

        int insideWindowOnes = 0;
        for (int i = 0; i < oneCount; i++) {
            if (data[i] == 1) {
                insideWindowOnes += 1;
            }
        }

        int maxValue = insideWindowOnes;
        while (right <= data.length - 1) {

            right++;
            if (right >= data.length) {
                break;
            }
            if (data[right] == 1) {
                insideWindowOnes++;
            }

            if (data[left] == 1) {
                insideWindowOnes--;

            }
            left++;

            maxValue = Math.max(maxValue, insideWindowOnes);
        }

        return oneCount - maxValue;
    }

    public static void main(String[] args) {
        Solution1151 solution1151 = new Solution1151();
        int          ans          = solution1151.minSwaps(new int[]{1,0,1,0,1,0,0,1,1,0,1});
        System.out.println(ans);
    }
}
