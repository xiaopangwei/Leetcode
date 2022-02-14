package leetcode.p2022m02;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/12
 * @time 5:21 PM
 */
public class NumArray {
    int[] treeSum;
    int[] nums;

    public NumArray(int[] nums) {


        int len = nums.length;
        this.nums = nums;
        this.treeSum = new int[2 * len];
        for (int i = 0; i < len; i++) {
            treeSum[i + len] = nums[i];
        }

        for (int i = len - 1; i >= 0; i--) {

            treeSum[i] = treeSum[2 * i] + treeSum[2 * i + 1];
        }

        System.out.println(Arrays.toString(treeSum));

    }


    public void update(int i, int val) {
        int index = i + nums.length;
        treeSum[index] = val;
        while (index != 0) {
            int parent = index / 2;
            int left   = 2 * parent;
            int right  = 2 * parent + 1;
            treeSum[parent] = treeSum[left] + treeSum[right];
            index = parent;
        }
    }


    public int sumRange(int l, int r) {

        int n=nums.length;
        int[] tree=this.treeSum;
        // get leaf with value 'l'
        l += n;
        // get leaf with value 'r'
        r += n;
        int sum = 0;
        while (l <= r) {
            if ((l % 2) == 1) {
                sum += tree[l];
                l++;
            }
            if ((r % 2) == 0) {
                sum += tree[r];
                r--;
            }
            l /= 2;
            r /= 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumArray numArray = new NumArray(new int[]{5, 6, 7, 8, 9});
        System.out.println(numArray.sumRange(0, 4));
    }
}
