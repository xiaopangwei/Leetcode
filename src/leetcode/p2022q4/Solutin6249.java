package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/11/27
 * @time 8:45 PM
 */
public class Solutin6249 {
    public int numberOfCuts(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n + 1) / 2;
        }
    }
}
