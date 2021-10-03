package leetcode.p2021m10;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/10/2
 * @time 10:30 PM
 */
public class Solution1265 {
    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }
        ImmutableListNode next = head.getNext();
        printLinkedListInReverse(next);
        head.printValue();
    }
}
