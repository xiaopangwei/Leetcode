package leetcode.p2021m06.p20210630;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 4:04 PM
 */
public class MyStack {
    /** Initialize your data structure here. */
    private Deque<Integer> d1;
    private Deque<Integer> d2;
    public MyStack() {
        d1=new ArrayDeque<>();
        d2=new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (d2.isEmpty()){
            d1.add(x);
        }else{
            d2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        int ans=-1;
        if (d2.isEmpty()){
            int size=d1.size();
            int cnt=0;

            ans=d1.getLast();
            while (!d1.isEmpty()){
               int temp=d1.poll();
               cnt++;
               if (cnt<size){
                   d2.add(temp);
               }
            }
            return ans;
        }else{
            int size=d2.size();
            int cnt=0;
            ans=d2.getLast();
            while (!d2.isEmpty()){
                int temp=d2.poll();
                cnt++;
                if (cnt<size){
                    d1.add(temp);
                }
            }
            return ans;
        }

    }

    /** Get the top element. */
    public int top() {
        if (d2.isEmpty()){
           return d1.getLast();
        }else{
            return d2.getLast();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return d1.isEmpty() && d2.isEmpty();
    }


    public static void main(String[] args){
        MyStack stack=new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
