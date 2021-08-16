package demo.test20210120;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/1
 * @time 11:20 AM
 */
public class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int k,int v){
            this.key=k;
            this.value=v;
        }

    }
    private int capacity;

    private Node head;

    private Node tail;
    private int count=0;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(-1,-1);
        head.prev=null;
        head.next=null;
        tail=head;
    }


    public int get(int key) {

        Node p=head;
        while (p!=null){
            if (p.key==key){
                break;
            }
            p=p.next;
        }

        if (p!=null){
            int val=p.value;
            removeMiddle(p);
            addAfterHead(p);
            return val;
        }

        else{
            return -1;
        }

    }

    void print(Node head){
        if (head.next!=null) {
            System.out.println(head.next.key+":"+head.next.value);
            print(head.next);
        }
    }

    public void put(int key, int value) {
        if (count<capacity){
            count++;
            Node node=new Node(key,value);
            addAfterHead(node);
        }
        else{

            Node p=head.next;
            while (p!=null){
                if (p.key==key){
                    break;
                }
                p=p.next;
            }
            if (p!=null){
                removeMiddle(p);
                p.value=value;
                addAfterHead(p);
            }
            else {
                removeLast();
                Node newNode = new Node(key, value);
                addAfterHead(newNode);
            }
        }
    }


    private void addAfterHead(Node newNode){
        Node p=head.next;
        newNode.next = p;
        newNode.prev=head;
        head.next = newNode;
        if (p==null) {
            tail=newNode;
        }
        if (p!=null) {
            p.prev = newNode;
        }
    }


    public void removeLast(){
        tail=tail.prev;
        tail.next=null;

    }


    public void removeMiddle(Node p){
        if (p==tail){
            removeLast();
        }
        else{
            Node prevNode=p.prev;
            Node nextNode=p.next;

            prevNode.next=nextNode;
            nextNode.prev=prevNode;

        }
    }

    public static void main(String[] args){
        LRUCache lRUCache=new LRUCache(2);
        System.out.println(lRUCache.get(2));
        lRUCache.put(2, 6); // 缓存是 {1=1}
        System.out.println(lRUCache.get(1));

        System.out.println("----------1");
        lRUCache.print(lRUCache.head);
        lRUCache.put(1, 5); // 缓存是 {1=1}
        System.out.println("----------2");
        lRUCache.print(lRUCache.head);
        lRUCache.put(1, 2); // 缓存是 {1=1}
        System.out.println("----------3");
        lRUCache.print(lRUCache.head);

        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));

    }
}
