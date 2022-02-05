package leetcode.springfestival.sf20220201;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/3
 * @time 11:06 AM
 */
public class Solution744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left  = 0;
        int right = letters.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left>=letters.length){
            return letters[0];
        }else {
            return letters[left];
        }
    }

    public static void main(String[] args) {
        Solution744 solution744 = new Solution744();
        char        ch          = solution744.nextGreatestLetter("cfj".toCharArray(), 'k');
        System.out.println(ch);
    }


}
