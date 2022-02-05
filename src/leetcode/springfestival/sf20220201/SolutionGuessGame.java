package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 5:02 PM
 */
public class SolutionGuessGame extends GuessGame {
    @Override
    public int guess(int num) {
        int left  = 0;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            int res = this.guess(mid);
            if (res == 0) {
                return mid;
            } else if (res < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
