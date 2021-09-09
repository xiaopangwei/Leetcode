package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/7
 * @time 10:30 PM
 */
public class Solution1231 {
    public int maximizeSweetness(int[] sweetness, int k) {


        if (k + 1 >= sweetness.length) {
            int minVal = sweetness[0];
            for (int i = 1; i < sweetness.length; i++) {
                minVal = Math.min(minVal, sweetness[i]);
            }
            return minVal;
        }
        int sum = 0;

        for (int item : sweetness) {
            sum += item;
        }
        if (k == 0) {
            return sum;
        }
        //45/6=7
        int avg = sum / (k + 1);

        int left = 0;

        int right = avg;

        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isOk(sweetness, mid, k)) {
                left = mid + 1;
                res = mid;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }

    public boolean isOk(int[] sweetness, int avg, int k) {

        int sum   = 0;
        int count = 0;
        for (int i = 0; i < sweetness.length; i++) {
            sum += sweetness[i];
            if (sum >= avg) {
                count++;
                sum = 0;
            }
        }
        return count >= k + 1;
    }

    public static void main(String[] args) {
        Solution1231 solution1231 = new Solution1231();
        int[]        array        = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int          ans          = solution1231.maximizeSweetness(new int[]{93138, 60229, 11179, 91723, 85722, 58195, 95146, 85049, 33816, 96902, 90688, 49428, 12942, 92258, 79248, 34754, 84744, 36020, 92601, 27208, 28080, 47608, 56185, 30986, 99000, 75061, 86087, 81803, 49219, 97866, 40688, 45222, 13997, 38184, 93314, 39449, 11014, 45643, 34874, 12590, 92531, 41891, 4581, 19342, 4254, 65419, 74418, 37309, 72577, 29710, 70849, 48726, 4065, 8711, 65258, 66877, 61625, 2362, 78453, 44042, 15437, 69222, 53745, 18492, 34470, 95699, 14178, 24256, 86504, 63646, 34805, 84171, 30979, 784, 35720, 4666, 86966, 82187, 44100, 75253, 60649, 96874, 55457, 76446, 53927, 45725, 11740, 12169, 70093, 89884, 98535, 44881, 94654, 70810, 56558, 43993, 26318, 86350, 42786, 26313}, 81);
        int ans = solution1231.maximizeSweetness(array, 5);
        System.out.println(ans);
    }
}
