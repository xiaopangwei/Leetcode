package leetcode.p2022m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/25
 * @time 9:58 PM
 */
public class MedianFinder2 {

    //上中位数
    public int getMedianUp(int[] num1, int[] num2) {

        int left1  = 0;
        int right1 = num1.length - 1;
        int left2  = 0;
        int right2 = num2.length - 1;
        while (left1 < right1) {
            int len1 = right1 - left1 + 1;
            int len2 = right2 - left2 + 1;
            System.out.println(len1 + " " + len2);
            int mid1 = (left1 + right1) / 2;
            int mid2 = (left2 + right2) / 2;

            boolean flag = (right1 - left1 + 1) % 2 == 0;
            if (num1[mid1] == num2[mid2]) {
                return num1[mid1];
            } else if (num1[mid1] < num2[mid2]) {
                if (flag) {
                    left1 = mid1 + 1;
                } else {
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
        return Math.min(num1[left1], num2[left2]);
    }


    public static void main(String[] args) {
        MedianFinder2 medianFinder2 = new MedianFinder2();
        int[]         num1          = new int[]{1, 4, 6, 8, 10};
        int[]         num2          = new int[]{3, 7, 16, 18, 20};
        int           ans           = medianFinder2.getMedianUp(num1, num2);
        System.out.println(ans);
    }
}
