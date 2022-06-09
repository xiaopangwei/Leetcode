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
        int                 ans                 = medianOfSortedArray.getMedian(new int[]{1,4,10,15}, new int[]{2,3,4,6});
        System.out.println(ans);
    }
}
