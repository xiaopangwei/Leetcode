package leetcode.springfestival.pm20220204;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/4
 * @time 3:50 PM
 */
public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return mergeSort(lists, 0, lists.length - 1);

    }

    private ListNode mergeSort(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int      mid = (left + right) / 2;
        ListNode l1  = mergeSort(lists, left, mid);
        ListNode l2  = mergeSort(lists, mid + 1, right);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode r         = dummyHead;

        ListNode p = l1;
        ListNode q = l2;

        while (p != null && q != null) {
            if (p.val < q.val) {
                ListNode pNext = p.next;
                r.next = p;
                r = p;
                p = pNext;
            } else if (p.val == q.val) {
                ListNode pNext = p.next;
                ListNode qNext = q.next;
                r.next = p;
                r = p;
                p = pNext;
                r.next = q;
                r = q;
                q = qNext;
            } else {
                ListNode qNext = q.next;
                r.next = q;
                r = q;
                q = qNext;
            }
        }

        while (p != null) {
            ListNode pNext = p.next;
            r.next = p;
            r = p;
            p = pNext;
        }

        while (q != null) {
            ListNode qNext = q.next;
            r.next = q;
            r = q;
            q = qNext;
        }

        return dummyHead.next;
    }

    public void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val)
            ;
            p = p.next;
        }
    }

    public static void main(String[] args) {
//        [[1,4,5],[1,3,4],[2,6]]
        ListNode   l1         = ListNode.ofArray("[1,4,5]");
        ListNode   l2         = ListNode.ofArray("[1,3,4]");
        ListNode   l3         = ListNode.ofArray("[2,6]");
        ListNode[] arr        = new ListNode[]{l1, l2, l3};
        Solution23 solution23 = new Solution23();
        ListNode   ans        = solution23.mergeKLists(arr);
        solution23.print(ans);
    }
}
