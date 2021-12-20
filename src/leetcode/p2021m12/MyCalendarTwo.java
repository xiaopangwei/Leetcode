package leetcode.p2021m12;

import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/19
 * @time 9:43 PM
 */
public class MyCalendarTwo {

    Map<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);


        int     temp = 0;
        boolean ok   = true;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            temp += entry.getValue();
//            max = Math.max(max, temp);
            if (temp >= 3) {
                ok = false;
                break;
            }
        }

        if (ok) {
            return true;
        } else {

            map.put(start, map.getOrDefault(start, 0) - 1);
            map.put(end, map.get(end) + 1);

            if (map.get(start) == 0) {
                map.remove(start);
            }

            return false;
        }

    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20));
        System.out.println(myCalendarTwo.book(50, 60));
        System.out.println(myCalendarTwo.book(10, 40));
        System.out.println(myCalendarTwo.book(5, 15));
        System.out.println(myCalendarTwo.book(5, 10));
        System.out.println(myCalendarTwo.book(25, 35));
    }
}
