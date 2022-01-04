package leetcode.p2021m09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/28
 * @time 11:37 PM
 */
public class TwoSum {
    List<Integer> data;

    public TwoSum() {

        data = new ArrayList<>();
    }

    public void add(int number) {

        data.add(number);
    }

    public boolean find(int value) {

        Collections.sort(data);
        int left  = 0;
        int right = data.size() - 1;
        while (left <= right) {
            int a = data.get(left);
            int b = data.get(right);
            if (a + b == value) {
                return true;
            } else if (a + b < value) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }
}
