package demo.szse.test20201123;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/12/10
 * @time 7:33 PM
 */
public class Test2 {

    public static void main(String[] args){
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(6);
        deque.addLast(9);

        Iterator<Integer> iterator=
                deque.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


        System.out.println("xxxxxxxxxxxxxxxx");
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());
        System.out.println(deque.isEmpty());
    }
}
