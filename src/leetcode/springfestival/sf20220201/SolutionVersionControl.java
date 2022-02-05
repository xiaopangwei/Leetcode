package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/2
 * @time 5:09 PM
 */
public abstract class SolutionVersionControl extends VersionControl {

    public int firstBadVersion(int n) {
        int left  = 1;
        int right = n;
        while (left < right) {
            int     mid = left + ((right - left) >> 1);
            boolean res = this.isBadVersion(mid);
            if (res) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
