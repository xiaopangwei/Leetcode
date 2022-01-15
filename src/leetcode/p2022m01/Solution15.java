package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 10:15 AM
 */
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pivot = nums[i];
            //highLights
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int remained = -pivot;

            List<LinkedList<Integer>> twoTuplesList = twoSum(nums, i + 1, nums.length - 1, remained);

            for (LinkedList<Integer> linkedList : twoTuplesList) {
                linkedList.addFirst(pivot);
                ans.add(linkedList);
            }

        }
        return ans;
    }

    private List<LinkedList<Integer>> twoSum(int[] nums, int left, int right, int newTarget) {
        List<LinkedList<Integer>> ans = new ArrayList<>();
        while (left < right) {
            int s = nums[left] + nums[right];
            if (s == newTarget) {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(nums[left]);
                linkedList.add(nums[right]);
                ans.add(linkedList);
                int i = left + 1;
                int j = right - 1;
                while (i < right && nums[i] == nums[left]) {
                    i++;
                }
                left = i;
                while (left < j && nums[j] == nums[right]) {
                    j--;
                }
                right = j;
            } else if (s < newTarget) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution15          solution15 = new Solution15();
        List<List<Integer>> ans        = solution15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ans);
    }
}
