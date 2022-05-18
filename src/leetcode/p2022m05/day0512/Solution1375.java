package leetcode.p2022m05.day0512;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:16 PM
 */
public class Solution1375 {
    public int numTimesAllBlue(int[] flips) {
        int maxVal = 0;
        int cnt    = 0;
        for (int i = 0; i < flips.length; i++) {
            //如果最大亮起来的灯等于遍历过的灯的数量
            maxVal = Math.max(maxVal, flips[i]);
            if (maxVal == i + 1) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution1375 solution1375 = new Solution1375();
        int          ans          = solution1375.numTimesAllBlue(new int[]{3, 2, 4, 1, 5});
        System.out.println(ans);
    }
}
