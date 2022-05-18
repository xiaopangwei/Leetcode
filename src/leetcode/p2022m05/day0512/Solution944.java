package leetcode.p2022m05.day0512;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 8:05 PM
 */
public class Solution944 {
    public int minDeletionSize(String[] strs) {
        int cols  = 0;
        int count = 0;
        while (cols < strs[0].length()) {

            int row    = 1;
            int maxVal = strs[0].charAt(cols);
            while (row < strs.length) {
                if (strs[row].charAt(cols) >= maxVal) {
                    maxVal = strs[row].charAt(cols);
                    row++;
                } else {
                    count++;
                    break;
                }
            }

            cols++;
        }
        return count;
    }

    public static void main(String[] args){
        Solution944 solution944=new Solution944();
        int ans=solution944.minDeletionSize(new String[]{"a","b"});
        System.out.println(ans);
    }
}
