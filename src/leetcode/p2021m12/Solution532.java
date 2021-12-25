package leetcode.p2021m12;

import com.sun.jmx.snmp.internal.SnmpSubSystem;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/25
 * @time 11:14 AM
 */
public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int i   = 0;
        int ans = 0;
        while (i < nums.length) {
            int target = nums[i] + k;

            int index = search(nums, target, i + 1, nums.length - 1);
            if (index != -1) {
                ans += 1;
            }
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[i]) {
                j++;
            }
            i = j;
        }
        return ans;
    }

    private int search(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] array=new int[]{1,2,4,4,3,3,0,9,2,3};
        Solution532 solution532=new Solution532();
        int ans=solution532.findPairs(array,3);
        System.out.println(ans);
    }
}
