package leetcode.p20210619;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/19
 * @time 11:49 PM
 */
public class StockSpanner {
    class Pair{
        public  int index;
        public  int price;
        public Pair(int index,int price){
            this.index=index;
            this.price=price;
        }
    }
    private Deque<Pair> stack;
    private int count=0;
    public StockSpanner() {
        stack=new ArrayDeque<>();
//        stack.push(new Pair(-1,-1));
    }

    public int next(int price) {


       while (!stack.isEmpty() && stack.peek().price<=price){
           stack.pop();
       }

       Pair temp=null;
       if (!stack.isEmpty())
       {
           temp=stack.peek();
       }else{
           temp=new Pair(-1,-1);
       }
       int currentTop=temp.index;
       int ans=count-currentTop;

        stack.push(new Pair(count++,price));


       return ans;
    }

    public static void main(String[] args){
        StockSpanner S=new StockSpanner();
        System.out.println(S.next(28));
        System.out.println(S.next(14));
        System.out.println(S.next(28));

    }

}
