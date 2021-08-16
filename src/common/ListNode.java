package common;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 11:13 PM
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static ListNode ofArray(String str){
       String sub=str.substring(1,str.length()-1).trim();
       if (sub.length()==0){
           return null;
       }
       String[] array=sub.split(",");
       ListNode head=new ListNode(-1);
       ListNode p=head;
       for (String item:array){
           p.next=new ListNode(Integer.parseInt(item.trim()));
           p=p.next;
       }

       return head.next;
    }

    public static void main(String[] args){
       ListNode head=ListNode.ofArray("[1,2,4]");
       System.out.println(head);
    }

}
