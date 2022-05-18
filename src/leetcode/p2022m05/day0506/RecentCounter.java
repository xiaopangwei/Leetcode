package leetcode.p2022m05.day0506;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/6
 * @time 10:34 PM
 */
public class RecentCounter {
    private LinkedList<Integer> list;

    public RecentCounter() {
        list = new LinkedList<>();
    }

    public int ping(int t) {
        while (!list.isEmpty() && list.getFirst() < t - 3000) {
            list.pollFirst();
        }
        list.add(t);
        return list.size();
    }

    public static void main(String[] args){
        RecentCounter recentCounter=new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
