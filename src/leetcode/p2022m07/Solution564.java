package leetcode.p2022m07;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/23
 * @time 5:10 PM
 */
public class Solution564 {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        if (num < 11) {
            return String.valueOf(num - 1);
        }


        PriorityQueue<Long> pq = new PriorityQueue<Long>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                long a = num != o1 ? Math.abs(o1 - num) : Long.MAX_VALUE;
                long b = num != o2 ? Math.abs(o2 - num) : Long.MAX_VALUE;
                if (a < b) {
                    return -1;
                } else if (a == b) {
                    if (!o1.equals(o2)) {
                        return o1.compareTo(o2);
                    }
                    return 0;
                }
                return 1;
            }
        });

        List<Long> list = getCandidates(n);
        System.out.println(list);
        for (Long item : list) {
            pq.add(item);
        }
        return String.valueOf(pq.peek());
    }

    private List<Long> getCandidates(String n) {
        int        len = n.length();
        List<Long> res = new ArrayList<>();

        res.add((long) (Math.pow(10, len) - 1));
        res.add((long) (Math.pow(10, len) + 1));
        res.add((long) (Math.pow(10, len - 1) + 1));
        res.add((long) (Math.pow(10, len - 1) - 1));

        StringBuilder sb = new StringBuilder();


        if (len % 2 == 0) {
            String prefix    = n.substring(0, len / 2);
            long   prefixNum = Long.parseLong(prefix);
            for (long i = prefixNum - 1; i <= prefixNum + 1; i++) {
                sb.setLength(0);
                sb.append(String.valueOf(i));
                sb.append(new StringBuilder(String.valueOf(i)).reverse().toString());
                String t = sb.toString();
                if (!t.equals(n)) {
                    res.add(Long.valueOf(t));
                }
            }
        } else {
            String prefix    = n.substring(0, (len+1) / 2);
            long   prefixNum = Long.parseLong(prefix);
            for (long i = prefixNum - 1; i <= prefixNum + 1; i++) {
                sb.setLength(0);
                String left=String.valueOf(i);
                sb.append(left);

                String temp=left.substring(0,left.length()-1);
                sb.append(new StringBuilder(temp).reverse().toString());

                String t = sb.toString();
                if (!t.equals(n)) {
                    res.add(Long.valueOf(t));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution564 solution564 = new Solution564();
        String      ans         = solution564.nearestPalindromic("11011");
        System.out.println(ans);
    }
}
