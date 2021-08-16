package demo.szse;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
//	    System.out.println(1^1);
//	    //01
//        //10
//        System.out.println(1^2);
//        System.out.println(2^2);
//        System.out.println(0^2);
//        //00
//        //11
//        System.out.println(0^3);
//
        //1100
//        System.out.println(Integer.parseInt("0011",2) & 12);
//        System.out.println(4>>>1);
//        System.out.println(4>>1);
//        System.out.println(4<<1);
        LinkedList<Integer> data=new LinkedList();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(1);

        System.out.println(data);
        data.addFirst(5);
        System.out.println(data);
        data.addLast(100);
        System.out.println(data);
        data.removeFirst();
        System.out.println(data);
        data.removeLast();
        System.out.println(data);

        System.out.println("-------------");

        System.out.println(data.pop());
        System.out.println(data);
        System.out.println(data.pop());
        System.out.println(data);
        data.push(8);
        System.out.println(data);
        data.push(9);
        System.out.println(data);

        System.out.println(data.peek());
        System.out.println(data);

        System.out.println("-------------");
        System.out.println(data.getFirst());
        System.out.println(data.getLast());

        System.out.println(data.peekFirst());
        System.out.println(data.peekLast());

        System.out.println("-------------==》》");

        int a=2;
        //10 ^ 01
        System.out.println(a^1);
        System.out.println(a^2);
        System.out.println(a >>> 16);


        System.out.println(int[].class);
        System.out.println(Integer[].class);
        System.out.println(Object[].class);

        System.out.println(int[].class.equals(Integer[].class));




    }
}
