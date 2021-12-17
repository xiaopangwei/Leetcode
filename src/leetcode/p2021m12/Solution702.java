package leetcode.p2021m12;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/12/9
 * @time 10:10 PM
 */
public class Solution702 {
    public int search(ArrayReader reader, int target) {
        int val = reader.get(0);
        if (val == target) {
            return 0;
        }

        int left  = 0;
        int right = 1;
        while (true) {
            if (reader.get(left) <= target && reader.get(right) >= target) {
                break;
            }

            left = right;
            right <<= 1;
        }


        while (left <= right) {
            int mid = (left + right) >> 1;
            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;


    }
}
