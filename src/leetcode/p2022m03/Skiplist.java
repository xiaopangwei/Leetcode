package leetcode.p2022m03;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/19
 * @time 8:47 PM
 */
public class Skiplist {
    class SkipNode {
        private int      val;
        private SkipNode right, down;

        public SkipNode() {
        }

        public SkipNode(int val) {
            this();
            this.val = val;
        }
    }

    public SkipNode head;

    int level;

    public Skiplist() {
        head = new SkipNode(-1);
        level = 1;
    }

    public boolean search(int target) {
        SkipNode p = head;
        while (p != null) {
            System.out.println(p.val);
            if (p.right == null) {
                p = p.down;
            }else {
                if (target < p.right.val) {
                    p = p.down;
                } else if (target == p.right.val) {
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
            if (p.right == null) {
                stack.push(p);
                p = p.down;
            } else {
                if (p.right.val >= num) {
                    stack.push(p);
                    p = p.down;
                } else {
                    p = p.right;
                }
            }
        }

        boolean  nextInsertAtLevel = true;
        SkipNode down              = null;
        while (nextInsertAtLevel && !stack.isEmpty()) {
            SkipNode temp = stack.pop();
            SkipNode next = temp.right;
            SkipNode curr = new SkipNode(num);
            curr.right = next;
            temp.right = curr;
            curr.down = down;
            down = curr;
            if (Math.random() < 0.5) {
                nextInsertAtLevel = true;
            } else {
                nextInsertAtLevel = false;
            }
        }

        if (nextInsertAtLevel && level < 8) {
            SkipNode newNode = new SkipNode(-1);
            newNode.down = head;
            head = newNode;
            level++;
        }
    }

    public boolean erase(int num) {
        boolean  ans = false;
        SkipNode p   = head;
        while (p != null) {
            if (p.right == null) {
                p = p.down;
            }else {
                if (num < p.right.val) {
                    p = p.down;
                } else if (num == p.right.val) {
                    ans = true;
                    p.right = p.right.right;
                    p = p.down;
                } else {
                    p = p.right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();

        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
//        skiplist.search(0);
        skiplist.add(4);
//        skiplist.search(1);
        skiplist.add(5);
//        skiplist.search(3);
        print(skiplist);
        skiplist.search(6);
    }


    public static void print(SkipNode node) {
        SkipNode p = node;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.right;
        }
        System.out.println();
    }


    public static void print(Skiplist skiplist) {
        SkipNode p = skiplist.head;

        while (p != null) {
            SkipNode down = p.down;
            print(p.right);
            p = down;
        }
        System.out.println();
    }


}
