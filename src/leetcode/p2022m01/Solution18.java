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
 * @time 10:38 AM
 */
public class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int pivot = nums[i];
            //highLights
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int remained = target - pivot;

            List<List<Integer>> list = threeSum(nums, i + 1, nums.length - 1, remained);
            for (List<Integer> item : list) {
                LinkedList<Integer> linkedList = (LinkedList<Integer>) item;
                linkedList.addFirst(nums[i]);
                ans.add(linkedList);
            }

        }

        return ans;
    }


    public List<List<Integer>> threeSum(int[] nums, int left, int right, int newTarget) {

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int pivot = nums[i];
            //highLights
            if (i > 0 && nums[i] == nums[i - 1] && i - 1 >= left) {
                continue;
            }
            int remained = newTarget - pivot;

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
        Solution18          solution18 = new Solution18();
        List<List<Integer>> ans        = solution18.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        System.out.println(ans);
    }
}
