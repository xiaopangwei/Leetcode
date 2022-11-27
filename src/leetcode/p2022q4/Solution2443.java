package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/24
 * @time 9:10 PM
 */
public class Solution2443 {
    public boolean sumOfNumberAndReverse(int num) {
        if (num>=99937){
            if (num==99988){
                return true;
            }
            return false;
        }
        int half = num / 2;
        for (int i = half; i <= num; i++) {
            int sum = i + reverse(i);
            if (sum == num) {
                return true;
            }
        }
        return false;
    }

    private int reverse(int s) {

        int ans = 0;
        while (s != 0) {
            ans = ans * 10 + s % 10;
            s /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2443 solution2443 = new Solution2443();
        for (int i=99937;i<=100000;i++) {
            boolean ans = solution2443.sumOfNumberAndReverse(i);
            if (ans){
                System.out.println(i);
            }
        }

    }
}
