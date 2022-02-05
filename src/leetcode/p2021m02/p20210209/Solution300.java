package leetcode.p2021m02.p20210209;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution300 {


    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return 1;
        }

        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);

            } else {
                int index = search2(list, nums[i]);
                if (index >= 0 && index < list.size()) {
                    list.set(index, nums[i]);
                }
            }
        }

        return list.size();

    }

//    public int search(List<Integer> list, int target) {
//        int index = -1;
//        for (int i = 0; i < list.size(); i++) {
//            if (i >= 1) {
//                if (list.get(i - 1) < target && target < list.get(i)) {
//                    index = i;
//                    break;
//                }
//            } else {
//                if (target < list.get(i)) {
//                    index = i;
//                    break;
//                }
//            }
//        }
//        return index;
//    }


    public int search2(List<Integer> list, int target) {
        int index = -1;
        int left  = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0) {
                if (list.get(mid - 1) < target && target < list.get(mid)) {
                    index = mid;
                    break;
                }

                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (target < list.get(mid)) {
                    index = mid;
                    break;
                }
                if (list.get(mid) < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution300 solution300 = new Solution300();
//        List<Integer> list        = Arrays.asList(2, 5, 8, 10, 10, 10, 11, 15, 17);
//        int           target      = solution300.search(list, 16);
//
//        System.out.println(target);
        System.out.println(solution300.lengthOfLIS(new int[]{7,7,7,7,7,7,7}));


    }
}
