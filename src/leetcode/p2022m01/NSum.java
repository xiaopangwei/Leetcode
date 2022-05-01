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
 * @time 2:06 PM
 */
public class NSum {

    public List<List<Integer>> nsum(int[] nums, int target, int n) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return dfs(nums, 0, target, n);
    }

    private List<List<Integer>> dfs(int[] nums, int start, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index <= 2) {
            int i = start;
            int j = nums.length - 1;
            while (i < j) {
                System.out.println(i + " " + j);
                int s = nums[i] + nums[j];
                if (s == target) {
                    LinkedList<Integer> t = new LinkedList<>();
                    t.addLast(nums[i]);
                    t.addLast(nums[j]);
                    result.add(t);
                    int t1 = i + 1;
                    int t2 = j - 1;
                    while (t1 < j && nums[t1] == nums[i]) {
                        t1++;
                    }
                    i = t1;
                    while (i < t2 && nums[t2] == nums[j]) {
                        t2--;
                    }
                    j = t2;
                } else if (s < target) {
                    int t1 = i + 1;
                    while (t1 < j && nums[t1] == nums[i]) {
                        t1++;
                    }
                    i = t1;
                } else {
                    int t2 = j - 1;
                    while (i < t2 && nums[t2] == nums[j]) {
                        t2--;
                    }
                    j = t2;
                }
            }
            return result;
        }


        int i = start;
        while (i < nums.length) {
            int                 pivot   = nums[i];
            List<List<Integer>> subList = dfs(nums, i + 1, target - pivot, index - 1);
            if (!subList.isEmpty()) {
                for (List<Integer> item : subList) {
                    LinkedList<Integer> linkedList = (LinkedList<Integer>) item;
                    linkedList.addFirst(pivot);
                    result.add(item);
                }
            }

            int j = i + 1;
//            while (j < nums.length && nums[j] == nums[i]) {
//                j++;
//            }
            i = j;
        }
        return result;
    }

    public static void main(String[] args) {
        NSum                nSum = new NSum();
        List<List<Integer>> list = nSum.nsum(new int[]{-1,0,1,2,-1,-4}, 0, 3);
        System.out.println(list);
    }
}
