package leetcode.p2022m06.day0612;

import common.ListNode;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/12
 * @time 9:11 PM
 */
public class AbstListNode {

    public ListNode getReversedKthNode(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode getMiddle2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            if (fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode p    = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next = prev;
            prev = p;
            p = nextP;
        }
        return prev;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode last      = dummyHead;

        ListNode p = head1;
        ListNode q = head2;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                ListNode nextP = p.next;
                last.next = p;
                last = p;
                p = nextP;
            } else {
                ListNode nextQ = q.next;
                last.next = q;
                last = q;
                q = nextQ;
            }
        }
        if (p != null) {
            last.next = p;
        }

        if (q != null) {
            last.next = q;
        }
        return dummyHead.next;
    }


    public ListNode reorderList(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode p      = head;
        while (p.next != middle) {
            p = p.next;
        }
        p.next = null;
        ListNode rev     = reverse(middle);
        ListNode newHead = jiaocha(head, rev);
        return newHead;
    }


    private ListNode jiaocha(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode();
        ListNode last      = dummyHead;

        ListNode p = head1;
        ListNode q = head2;

        while (p != null && q != null) {
            ListNode nextP = p.next;
            ListNode nextQ = q.next;

            last.next = p;
            last = p;
            last.next = q;
            last = q;

            p = nextP;
            q = nextQ;
        }

        last.next = q;
        return dummyHead.next;
    }


    public ListNode intersect(ListNode head1, ListNode head2) {

        ListNode p = head1;
        ListNode q = head2;

        while (p != q) {
            if (p != null) {
                p = p.next;
            } else {
                p = head2;
            }

            if (q != null) {
                q = q.next;
            } else {
                q = head1;
            }
        }
        return p;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        if (k == 1) {
            return head;
        }
        ListNode oldHead = head;
        ListNode q       = head;
        ListNode prev    = null;
        for (int i = 0; i < k; i++) {
            prev = q;
            q = q.next;
        }

        if (prev != null) {
            prev.next = null;
        }
        ListNode newHead = reverse(head);
        oldHead.next = reverseKGroup(q, k);
        return newHead;
    }


    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            ListNode p = head;
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        }
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        ListNode p    = head;
        while (p != null) {
            int      val = p.val;
            ListNode q   = p.next;
            while (q != null && q.val == val) {
                q = q.next;
            }
            last.next = q;
            last = q;
            p = q;
        }

        return head;
    }


    public ListNode oddEvenList(ListNode head) {

        ListNode oddHead  = head;
        ListNode evenHead = head.next;

        ListNode p = head;
        ListNode q = head.next;

        ListNode oddLast = head;

        while (p != null && q != null) {
            oddLast = p;

            ListNode nextQ = q.next;
            p.next = nextQ;
            p = nextQ;


            ListNode nextP = p.next;
            q.next = nextP;
            q = nextP;

        }

        oddLast.next = evenHead;
        return oddHead;

    }

    public ListNode addTwoNumbersReversedOrder(ListNode l1, ListNode l2) {
        int      carry = 0;
        ListNode p1    = l1;
        ListNode p2    = l2;

        ListNode dummyHead = new ListNode(-1);
        ListNode last      = dummyHead;

        while (p1 != null && p2 != null) {
            int      sum = p1.val + p2.val + carry;
            ListNode res = new ListNode(sum % 10);
            last.next = res;
            last = last.next;
            carry = sum / 10;

            p1 = p1.next;
            p2 = p2.next;
        }

        while (p1 != null) {
            int      sum = p1.val + carry;
            ListNode res = new ListNode(sum % 10);
            last.next = res;
            last = last.next;
            carry = sum / 10;
            p1 = p1.next;
        }

        while (p2 != null) {
            int      sum = p2.val + carry;
            ListNode res = new ListNode(sum % 10);
            last.next = res;
            last = last.next;
            carry = sum / 10;
            p2 = p2.next;

        }

        if (carry != 0) {
            last.next = new ListNode(carry);
        }

        return reverse(dummyHead.next);

    }


    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode p      = head;
        while (p.next != middle) {
            p = p.next;
        }
        p.next = null;
        ListNode head1 = mergeSort(head);
        ListNode head2 = mergeSort(middle);

        return merge(head1, head2);
    }


    private ListNode insertSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode();
        dummyHead.val = Integer.MIN_VALUE;

        ListNode p = head;
        while (p != null) {
            ListNode nextP = p.next;
            p.next=null;
            ListNode q = dummyHead;
            if (q.next != null) {
                while (q.next != null) {
                    if (q.val <= p.val && p.val < q.next.val) {
                        p.next = q.next;
                        q.next = p;
                        break;
                    }
                    q = q.next;
                }
            } else {
                q.next = p;
            }
            p = nextP;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        AbstListNode absListNode = new AbstListNode();
//        ListNode     head1       = absListNode.reverse(ListNode.ofArray("[1,2,3]"));
//        ListNode     head2       = absListNode.reverse(ListNode.ofArray("[4,5,6,7]"));
////        ListNode     newHead         = reveredListNode.merge(head1, head2);
//        ListNode newHead = absListNode.addTwoNumbersReversedOrder(head1, head2);
        ListNode newHead = absListNode.insertSort(ListNode.ofArray("[9,-2,-1,0,8,1,2,1,5,8,2]"));
        ListNode p       = newHead;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
        System.out.println(newHead);
    }
}
