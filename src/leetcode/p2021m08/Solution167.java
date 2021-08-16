package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/13
 * @time 5:49 PM
 */
public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length - 1;

        int[] res = null;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                res = new int[]{i + 1, j + 1};
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;

    }
}
