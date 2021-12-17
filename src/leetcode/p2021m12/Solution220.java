package leetcode.p2021m12;

import java.util.TreeSet;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/9
 * @time 9:21 PM
 */
public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Long> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Long minVal = treeSet.ceiling((long) nums[i] - (long) t);

            if (minVal != null && minVal <= nums[i] + t) {
                return true;
            }

            treeSet.add((long) nums[i]);

            if (i >= k) {
                treeSet.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution220      solution220 = new Solution220();
        boolean flag=solution220.containsNearbyAlmostDuplicate(new int[]{1,0,1,1},1,2);
        System.out.println(flag);

        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(1);
        treeSet.add(3);
        treeSet.add(1);

        System.out.println(treeSet);

        treeSet.remove(1);

        System.out.println(treeSet);
    }
}
