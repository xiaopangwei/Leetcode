package leetcode.p2021m10;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/8
 * @time 7:04 PM
 */
public class Solutin1063 {
    public int validSubarrays(int[] nums) {
        int[] copy = new int[nums.length + 1];
        System.arraycopy(nums, 0, copy, 0, nums.length);
        copy[copy.length - 1] = -1;

        Stack<Integer> idxStack = new Stack<>();
        int            ans      = 0;
        for (int i = 0; i < copy.length; i++) {
            while (!idxStack.isEmpty() && copy[idxStack.peek()] > copy[i]) {
                int temp = idxStack.pop();
                ans += (i - temp);
            }
            idxStack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solutin1063 solutin1063 = new Solutin1063();
        int         ans         = solutin1063.validSubarrays(new int[]{2,2,2});
        System.out.println(ans);
    }
}
