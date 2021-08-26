package leetcode.p2021m08;

import java.util.Random;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/25
 * @time 3:13 PM
 */
public class Skiplist {
    static class SkipNode {
        public int key;
        public int value;
        public SkipNode right = null, down = null;

        public SkipNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public SkipNode(int key) {
            this.key = key;
            this.value = Integer.MIN_VALUE;
        }

    }

    public SkipNode head;

    private int highLevel = 0;


    public Skiplist() {

        head = new SkipNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public boolean search(int target) {

        SkipNode p = head;
        while (p != null) {
            if (p.right == null || target < p.right.key) {
                p = p.down;
            } else {
                if (target == p.right.key) {
                    return true;
                } else {
                    p = p.right;
                }

            }
        }

        return false;
    }

    public void add(int num) {

        SkipNode        p     = head;
        Stack<SkipNode> stack = new Stack<>();

        while (p != null) {
            if (p.right == null || num <= p.right.key) {
                stack.push(p);
                p = p.down;
            } else if (num > p.right.key) {
                p = p.right;
            }
        }


        int      level    = 1;
        SkipNode previous = null;
        while (!stack.isEmpty()) {
            SkipNode currentDown = stack.pop();
            SkipNode node        = new SkipNode(num);
            SkipNode next        = currentDown.right;

            node.right = next;
            currentDown.right = node;

            node.down = previous;
            previous = node;

            double probe = new Random().nextDouble();
            System.out.println(num + " => " + probe);
            if (probe >= 0.5) {
                break;
            } else {
                level++;
                if (level > 8) {
                    return;
                }
                if (level > highLevel) {
                    highLevel = level;
                    SkipNode newHead = new SkipNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
                    newHead.down = head;
                    head = newHead;
                    stack.push(head);
                }
            }

        }

    }

    public boolean erase(int num) {
        SkipNode p   = head;
        boolean  res = false;
        while (p != null) {
            if (p.right == null || num < p.right.key) {
                p = p.down;
            } else {
                if (num == p.right.key) {
                    res = true;
                    SkipNode rightTemp = p.right;
                    SkipNode downTemp  = p.down;

                    p.right = rightTemp.right;
                    p = downTemp;
                } else {
                    p = p.right;
                }

            }
        }
        return res;
    }

    public void print() {
        SkipNode p    = head;
        SkipNode down = p.down;

        while (true) {
            while (p != null) {
                System.out.print(p.key + " => ");
                p = p.right;
            }
            System.out.println("----");
            p = down;
            if (down == null) {
                break;
            }
            down = down.down;

        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(6);
        skiplist.add(4);
        skiplist.add(10);
        skiplist.add(19);
        System.out.println("**********");
        skiplist.print();

//        System.out.println(skiplist.search(1));
//        System.out.println(skiplist.search(4));
//        System.out.println(skiplist.search(10));
//        System.out.println(skiplist.search(18));
//        System.out.println(skiplist.search(100));

        System.out.println(skiplist.erase(3));
        skiplist.print();
        System.out.println("---------------------");
        System.out.println(skiplist.erase(4));

        skiplist.print();
        System.out.println("---------------------");
        System.out.println(skiplist.erase(1));

        skiplist.print();
        System.out.println("---------------------");


        System.out.println(skiplist.erase(19));
        skiplist.print();
        System.out.println("---------------------");


    }
}
