package leetcode.springfestival.sf20220130;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/30
 * @time 3:47 PM
 */
//面试0205
public class SolutionMS0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode t         = dummyHead;
        int      carry     = 0;
        ListNode p         = l1;
        ListNode q         = l2;
        while (p != null && q != null) {
            int temp  = p.val + q.val;
            int lower = (temp + carry) % 10;
            carry = (temp + carry) / 10;
            t.next = new ListNode(lower);
            t = t.next;
            p = p.next;
            q = q.next;
        }

        while (p != null) {
            int temp  = p.val + carry;
            int lower = temp % 10;
            t.next = new ListNode(lower);
            t = t.next;
            carry = temp / 10;
            p = p.next;
        }


        while (q != null) {
            int temp  = q.val + carry;
            int lower = temp % 10;
            t.next = new ListNode(lower);
            t = t.next;
            carry = temp / 10;
            q = q.next;
        }

        if (carry != 0) {
            t.next = new ListNode(carry % 10);
            carry /= 10;
        }
        return dummyHead.next;
    }


    public ListNode addTwoAsc(ListNode l1, ListNode l2) {
        align(l1, l2);
        ListNode r1 = reverse(l1);
        ListNode r2 = reverse(l2);
        ListNode t  = addTwoNumbers(r1, r2);
        return t;
    }

    public ListNode reverse(ListNode l1) {
        ListNode prev = null;
        ListNode p    = l1;
        while (p != null) {
            ListNode pNext = p.next;
            p.next = prev;
            prev = p;
            p = pNext;
        }
        return prev;
    }

    private void align(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;

        ListNode lastP = null;
        ListNode lastQ = null;

        int cnt1 = 0;
        int cnt2 = 0;
        while (p != null) {
            lastP = p;
            cnt1++;
            p = p.next;
        }

        while (q != null) {
            lastQ = q;
            cnt2++;
            q = q.next;
        }

        int gap=Math.abs(cnt1-cnt2);
        if (cnt1 > cnt2) {
            ListNode temp=lastQ;
            for (int i=0;i<gap;i++){
                temp.next=new ListNode(0);
                temp=temp.next;
            }
        }

        if (cnt2 > cnt1) {
            ListNode temp=lastP;
            for (int i=0;i<gap;i++){
                temp.next=new ListNode(0);
                temp=temp.next;
            }
        }

    }

    public static void main(String[] args) {
        SolutionMS0205 solutionMS0205 = new SolutionMS0205();
        ListNode       l1             = ListNode.ofArray("[9,6,1,7]");
        ListNode       l2             = ListNode.ofArray("[3,9,5]");
        ListNode       l              = solutionMS0205.addTwoAsc(l1, l2);
        ListNode       p              = solutionMS0205.reverse(l);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
