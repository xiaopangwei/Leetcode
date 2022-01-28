package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/26
 * @time 10:48 PM
 */
public class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] modArray = new int[k];
        for (int item : arr) {
            int t = 0;
            if (item >= 0) {
                t = item % k;
            } else {
                int p = Math.abs(item) / k + 1;
                t = (item + p * k) % k;
            }
            modArray[t]++;
        }

        int i = 1;
        int j = modArray.length - 1;

        if (modArray[0] % 2 != 0) {
            return false;
        }
        while (i <= j) {
            if (modArray[i] != modArray[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1497 solution1497 = new Solution1497();
        boolean      ans          = solution1497.canArrange(new int[]{-1,1,-2,2,-3,3,-4,4}, 3);
        System.out.println(ans);
    }
}
