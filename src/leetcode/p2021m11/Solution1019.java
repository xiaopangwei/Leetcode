package leetcode.p2021m11;

import common.ListNode;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/11
 * @time 10:46 PM
 */
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {

        Stack<int[]>  monoStack = new Stack<>();


        ListNode p     = head;
        int      index = 0;
        int      count = 0;
        while (p != null) {
            count++;
            p = p.next;
        }
        p = head;
        int[] ans=new int[count];
        while (p != null) {

            while (!monoStack.isEmpty() && p.val > monoStack.peek()[1]) {
                int[] temp = monoStack.pop();
                ans[temp[0]]= p.val;
            }
            monoStack.push(new int[]{index, p.val});
            p = p.next;
            index++;
        }

        while (!monoStack.isEmpty()) {
            int[] arr = monoStack.pop();
            ans[arr[0]]= 0;
        }


        return ans;
    }

    public static void main(String[] args) {
        ListNode     arr          = ListNode.ofArray("[1,7,5,1,9,2,5,1]");
        Solution1019 solution1019 = new Solution1019();
        int[]        array        = solution1019.nextLargerNodes(arr);
        System.out.println(Arrays.toString(array));
    }
}
