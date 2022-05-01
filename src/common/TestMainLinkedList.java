package common;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/4/7
 * @time 8:49 PM
 */
public class TestMainLinkedList {

    public static void main(String[] args) {
        ListNode head = ListNode.ofArray("[1,2]");
        ListNode slow = head;
        ListNode fast = head;


        while (true) {
            if (fast == null || fast.next == null) {
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        System.out.println(slow.val);
    }


}
