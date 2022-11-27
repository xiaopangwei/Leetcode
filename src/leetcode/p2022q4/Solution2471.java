package leetcode.p2022q4;

import common.TreeNode;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/20
 * @time 11:11 PM
 */
public class Solution2471 {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minCount = 0;
        while (!queue.isEmpty()) {
            int           size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode t = queue.poll();
                temp.add(t.val);
                // queue.add(t);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            int[] array = new int[temp.size()];
            for (int i = 0; i < array.length; i++) {
                array[i] = temp.get(i);
            }
            minCount += help(array);
        }
        return minCount;
    }

    private int help(int[] nums) {
        Map<Integer, Integer> map   = new HashMap<>();
        int[]                 clone = nums.clone();
        Arrays.sort(clone);
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(clone[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (; ; ) {
                int idx = map.get(nums[i]);
                if (idx != i) {
                    ans++;
                    swap(nums, idx, i);
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
