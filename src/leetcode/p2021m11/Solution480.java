package leetcode.p2021m11;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/28
 * @time 10:36 AM
 */
public class Solution480 {
    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] res = new double[nums.length - k + 1];

        long[] window = new long[k];


        int left  = 0;
        int right = k - 1;

        for (int i = left; i <= right; i++) {
            window[i] = (long)( nums[i]);
        }

        Arrays.sort(window);
        int idx = 0;
        res[idx++] = getMid(window, k);
        while (right <= nums.length - 1) {


            int tIndex = findIndex(window, nums[left]);
            System.out.println(tIndex+" "+right);
            if (right==nums.length-1){
//                res[idx++]=getMid(window,k);
                break;
            }
            window[tIndex] = nums[++right];
            left++;

            int i = tIndex;
            int j = i + 1;
            while (j <k && window[i] > window[j]) {
                swap(window,i,j);
                i++;
                j++;
            }

            i=tIndex-1;
            j=tIndex;

            while (i>=0 && window[i] > window[j]) {
                swap(window,i,j);
                i--;
                j--;
            }

            res[idx++] = getMid(window, k);

        }

        return res;
    }

    private void swap(long[] arr, int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private int findIndex(long[] arr, long value) {
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (arr[mid] == value) {
                return mid;
            } else if (arr[mid] > value) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return -1;
    }

    public double getMid(long[] arr, int k) {
        if (k % 2 != 0) {
            return arr[k / 2] * 1.0;
        } else {
            return (arr[k / 2] + arr[k / 2 - 1]) * 1.0 / 2;
        }
    }

    public static void main(String[] args){
        Solution480 solution480=new Solution480();
        double[] ans=solution480.medianSlidingWindow(new int[]{2147483647,2147483647},2);
        System.out.println(Arrays.toString(ans));
    }
}
