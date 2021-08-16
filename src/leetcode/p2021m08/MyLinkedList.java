package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/14
 * @time 10:57 PM
 */
public class MyLinkedList {

    static class Node {
        public int  val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private int nodeCount = 0;
    public Node head;


    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

        head = new Node(-1);

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= nodeCount) {
            return -1;
        }
        Node p = head;
        int  i = 0;

        while (i <= index) {
            p = p.next;
            i++;
        }
        return p.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node p    = head.next;
        Node node = new Node(val);
        node.next = p;
        head.next = node;
        nodeCount++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(nodeCount, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0) {
            addAtHead(val);
        } else if (index > nodeCount) {
            return;
        } else {
            Node p    = head;
            Node node = new Node(val);
            int  i    = 0;
            while (i < index) {
                p = p.next;
                i++;
            }

            Node prevNode = p;
            Node nextNode = p.next;

            node.next = nextNode;
            prevNode.next = node;

            nodeCount++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

        if (index < 0 || index >= nodeCount) {
            return;
        }
        Node p = head;

        int i = 0;
        while (i < index) {
            p = p.next;
            i++;
        }

        Node prevNode = p;
        if (p.next != null) {
            Node nextNode = p.next.next;
            prevNode.next = nextNode;
        } else {
            Node nextNode = null;
            prevNode.next = nextNode;
        }


        nodeCount--;
    }

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(2);
        myLinkedList.deleteAtIndex(1);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(3);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(5);
        myLinkedList.addAtTail(5);
        myLinkedList.get(5);
        myLinkedList.deleteAtIndex(6);
        myLinkedList.deleteAtIndex(4);

//
//        System.out.println(myLinkedList.get(-1));
//        System.out.println(myLinkedList.get(0));
//        System.out.println(myLinkedList.get(1));
//        System.out.println(myLinkedList.get(2));
        System.out.println(myLinkedList.get(30));
        System.out.println(myLinkedList.get(4));
    }
}
