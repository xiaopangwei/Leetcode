package leetcode.p2022m05.day0507;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/7
 * @time 9:44 PM
 */
public class Solution556 {
    public int nextGreaterElement(int n) {
        if(n>=Integer.MAX_VALUE){
            return -1;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (n != 0) {
            list.addFirst(n % 10);
            n /= 10;
        }
        int idx = -1;
        for (int i = list.size() - 2; i >= 0; i--) {
            if (list.get(i) < list.get(i + 1)) {
                idx = i;
                break;
            }
        }

        if (idx == -1) {
            return -1;
        }

        List<Integer> temp = new ArrayList<>();
        for (int i = idx + 1; i < list.size(); i++) {
            temp.add(list.get(i));
        }

        Collections.sort(temp);

        for (int i = 0; i < temp.size(); i++) {
            list.set(i + idx + 1, temp.get(i));
        }

        int i = idx + 1;
        int j = list.size() - 1;

        int target = list.get(idx);
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (list.get(mid) <= target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        Collections.swap(list, idx, i);

        long sum = 0;
        for (int t = 0; t < list.size(); t++) {
            sum = sum * (long) 10 + (long) list.get(t);
            if (sum > Integer.MAX_VALUE) {
                return -1;
            }
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Solution556 solution556 = new Solution556();
        int         n           = solution556.nextGreaterElement(12);
        System.out.println(n);

    }
}
