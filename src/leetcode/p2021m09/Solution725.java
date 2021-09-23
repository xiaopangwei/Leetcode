package leetcode.p2021m09;

import common.ListNode;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/22
 * @time 8:50 PM
 */
public class Solution725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int      count = 0;
        ListNode p     = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        ListNode[] res = new ListNode[k];
        if (count <= k) {
            p = head;
            int idx = 0;
            while (p != null) {
                ListNode nextP = p.next;
                p.next = null;
                res[idx++] = p;
                p = nextP;
            }
        } else {
            int[] cnt  = new int[k];
            int   avg  = count / k;
            int   left = count % k;
            Arrays.fill(cnt, avg);
            int idx = 0;
            while (left > 0) {
                cnt[idx++]++;
                left--;
            }

            p = head;
            ListNode prev = null;
            idx = 0;
            for (int i = 0; i < k; i++) {
                res[idx++] = p;
                int num = cnt[i];
                int j   = 0;
                while (p != null && j < num) {
                    ListNode nextP = p.next;
                    j++;
                    prev = p;
                    p = nextP;
                }
                if (prev != null) {
                    prev.next = null;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution725 solution725=new Solution725();
        ListNode head=ListNode.ofArray("[1,2,3,4,5,6,7,8,9,10]");
        ListNode[] list=solution725.splitListToParts(head,5);
        System.out.println(list);
    }

}
