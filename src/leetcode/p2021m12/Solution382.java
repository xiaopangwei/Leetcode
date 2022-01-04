package leetcode.p2021m12;

import common.ListNode;

import java.util.Random;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/1
 * @time 3:11 PM
 */
public class Solution382 {

    ListNode head;

    public Solution382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode p      = head;
        int      i      = 0;
        Random   random = new Random();

        int ans = head.val;
        while (p != null) {
            i++;
            double t = random.nextDouble();
            if (t < 1.0 / i) {
                ans = p.val;
            }
            p = p.next;
        }

        return ans;

    }
}
