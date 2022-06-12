package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/9
 * @time 8:41 PM
 */
public class KthSortedArrayProblem {

    public int getKthNumber(int[] array1, int[] array2, int k) {
        return getKth(array1, array2, 0, array1.length - 1, 0, array2.length - 1, k);
    }


    private int getKth(int[] array1,
                       int[] array2,
                       int left1, int right1, int left2, int right2, int k) {
        int len1 = right1 - left1 + 1;
        int len2 = right2 - left2 + 1;
        if (len1 > len2) {
            return getKth(array2, array1, left2, right2, left1, right1, k);
        }
        if (len1 == 0) {
            return array2[k - 1];
        }
        if (k == 1) {
            return Math.min(array1[left1], array2[left2]);
        }


        int k1 = Math.min(k / 2, len1);
        int k2 = Math.min(k - k1, len2);


        int idx1 = k1 + left1 - 1;
        int idx2 = k2 + left2 - 1;
        if (array1[idx1] == array2[idx2]) {
            return array1[idx1];
        } else if (array1[idx1] < array2[idx2]) {
            return getKth(array1, array2, left1 + k1, right1, left2, right2, k - k1);
        } else {
            return getKth(array1, array2, left1, right1, left2 + k2, right2, k - k2);
        }
    }


    public static void main(String[] args) {
        KthSortedArrayProblem kthSortedArrayProblem = new KthSortedArrayProblem();
        int[]                 array1                = new int[]{1, 2};
        int[]                 array2                = new int[]{3, 4};
        for (int i = 1; i <= 4; i++) {
            int ans = kthSortedArrayProblem.getKthNumber(array1, array2, i);
            System.out.println(i + " " + ans);
        }
    }
}
