package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 5:48 PM
 */
public class Solution1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {


        int peekIndex = findPeek(mountainArr);
        int peekVal   = mountainArr.get(peekIndex);
        if (target == peekVal) {
            return peekIndex;
        } else if (target > peekVal) {
            return -1;
        } else {
            //左边搜索
            int ans = search1(0, peekIndex - 1, target, mountainArr);
            if (ans != -1) {
                return ans;
            } else {
                ans = search2(peekIndex + 1, mountainArr.length() - 1, target, mountainArr);
                return ans;
            }
        }

    }
    //3, 5, 3, 2, 0

    private int findPeek(MountainArray mountainArr) {
        int left  = 1;
        int right = mountainArr.length() - 2;
        while (left <= right) {

            int mid    = left + (right - left) / 2;
            int midVal = mountainArr.get(mid);
            if (isPeek(mountainArr, mid)) {
                return mid;
            } else if (mountainArr.get(mid + 1) < midVal) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isPeek(MountainArray mountainArray, int index) {
        int val = mountainArray.get(index);
        return mountainArray.get(index + 1) < val
                && mountainArray.get(index - 1) < val;
    }

    private int search1(int left, int right, int target, MountainArray mountainArr) {
        int i = left;
        int j = right;
        while (i <= j) {
            int mid = (i + j) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return -1;
    }

    private int search2(int left, int right, int target, MountainArray mountainArr) {
        int i = left;
        int j = right;
        while (i <= j) {
            int mid = (i + j) / 2;
            int val = mountainArr.get(mid);
            if (val == target) {
                return mid;
            } else if (val < target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution1095 solution1095 = new Solution1095();
        int[]        array        = new int[]{1,2,3,4,5,3,1};
//        int          index        = solution1095.findPeek(new MountainArrayImpl(array));
//        System.out.println(index);

        int res = solution1095.findInMountainArray(1,
                new MountainArrayImpl(array));
        System.out.println(res);
    }

    static class MountainArrayImpl implements MountainArray {

        int[] array;

        public MountainArrayImpl(int[] nums) {
            this.array = nums;
        }

        @Override
        public int get(int index) {
            return array[index];
        }

        @Override
        public int length() {
            return array.length;
        }
    }
}
