package leetcode.p20210218;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/19
 * @time 5:14 PM
 */
public class DeepCopy {



    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }



    public Node copyRandomList(Node head) {

            if (head==null){
                return null;
            }

            Map<Node,Node> cached1=new HashMap<>();
            Map<Node,Node> cached2=new HashMap<>();
            Map<Node,Node> cached3=new HashMap<>();


            Node newHead=new Node(head.val);
            cached1.put(newHead,head);
            cached2.put(head,head.random);
            cached3.put(head,newHead);

            Node p=head.next;
            Node q=newHead;
            while (p!=null){
                Node node=new Node(p.val);
                q.next=node;
                cached1.put(node,p);
                cached2.put(p,p.random);
                cached3.put(p,node);
                p=p.next;
                q=q.next;
            }


            q=newHead;

            while (q!=null){
                Node oldNode=cached1.get(q);
                Node oldRandom=cached2.get(oldNode);
                if (oldRandom==null){
                    q.random=null;
                }
                else{
                    q.random=cached3.get(oldRandom);
                }
                q=q.next;

            }

            return newHead;

    }

    public static void main(String[] args){
        DeepCopy deepCopy=new DeepCopy();
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);

        n1.next=n2;
        n2.next=n3;
        n1.random=n3;
        n2.random=null;
        n3.random=n1;


        Node newNode=deepCopy.copyRandomList(null);
        System.out.println(newNode);
    }
}
