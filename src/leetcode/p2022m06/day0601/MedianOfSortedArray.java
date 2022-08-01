package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/8
 * @time 11:12 PM
 */
public class MedianOfSortedArray {

    int[] array1;
    int[] array2;

    public int getMedian(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
        int n = array1.length;
        return getMedian(0, n - 1, 0, n - 1);
    }


    private double getMedia2(int[] num1, int[] num2) {
        int left1  = 0;
        int right1 = num1.length - 1;
        int left2  = 0;
        int right2 = num2.length - 1;
        while (left1 < right1) {
            int len1 = right1 - left1 + 1;
            int len2 = right2 - left2 + 1;
            int mid1 = (left1 + right1) / 2;
            int mid2 = (left2 + right2) / 2;

            boolean flag = (right1 - left1 + 1) % 2 == 0;
            if (num1[mid1] == num2[mid2]) {
                return num1[mid1];
            } else if (num1[mid1] < num2[mid2]) {
                //偶数
                if (flag) {
                    left1 = mid1 + 1;
                } else {
                    //奇数
                    left1 = mid1;
                }
                right2 = mid2;
            } else {
                if (flag) {
                    left2 = mid2 + 1;
                } else {
                    left2 = mid2;
                }
                right1 = mid1;
            }
        }
        System.out.println(num1[left1] + " " + num2[left2]);
        return Math.min(num1[left1], num2[left2]);
    }

    private int getMedian(int left1, int right1,
                          int left2, int right2) {

        if (left1 == right1) {
            return (array1[left1] + array2[left2]) / 2;
        }

        int mid1 = left1 + (right1 - left1) / 2;
        int mid2 = left2 + (right2 - left2) / 2;

        int len = right1 - left1 + 1;

        int half = len / 2;
        if (array1[mid1] < array2[mid2]) {
            return getMedian(left1 + half, right1, left2, right2 - half);

        } else if (array1[mid1] > array2[mid2]) {
            return getMedian(left1, right1 - half, left2 + half, right2);
        } else {
            return array1[mid1];
        }

    }

    public static void main(String[] args) {
        MedianOfSortedArray medianOfSortedArray = new MedianOfSortedArray();
        double              ans                 = medianOfSortedArray.getMedia2(new int[]{1, 8, 12}, new int[]{4, 6, 7});
        System.out.println(ans);
    }
}
