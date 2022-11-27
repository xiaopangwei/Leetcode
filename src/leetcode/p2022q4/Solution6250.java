package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 9:02 PM
 */
public class Solution6250 {
    public int bestClosingTime(String customers) {

        // 1 1 0 1
        //[1 2 2(停止)/1 2]
        int[] array = new int[customers.length()];
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'N') {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        int maxVal   = 0;
        int s        = 0;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                s += 1;
                if (s > maxVal) {
                    maxVal = s;
                    maxIndex = i;
                }
            } else {
                s -= 1;
                if (s > maxVal) {
                    maxVal = s;
                    maxIndex = i;
                }
            }
        }
        return maxIndex + 1;
    }


    private int dfs(char[] array, int index, int currentSum) {
        if (array.length == index) {
            return currentSum;
        }
        if (array[index] == 'Y') {
            return dfs(array, index + 1, currentSum + 1);
        } else {
            return Math.max(dfs(array, index + 1, currentSum - 1), currentSum);
        }
    }

    public static void main(String[] args) {
        Solution6250 solution6250 = new Solution6250();
        System.out.println(solution6250.bestClosingTime("YNYY"));
    }

}
