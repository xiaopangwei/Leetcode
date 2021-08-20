package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 10:06 AM
 */
public class Solution541 {
    public String reverseStr(String s, int k) {

        int    i      = 0;
        int    length = s.length();
        char[] array  = s.toCharArray();
        while (i < length) {

            int j     = i;
            int count = 0;
            while (j < length && count < 2 * k) {
                j++;
                count++;
            }
            if (count == 2 * k) {
                reverse(array, i, i + k - 1);
            } else if (count >= k && count < 2 * k) {
                reverse(array, i, i + k - 1);
                break;
            } else {
                reverse(array, i, length - 1);
                break;
            }

            i = j;
        }

        return new String(array);
    }

    private void reverse(char[] array, int i, int j) {
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
        String      ans         = solution541.reverseStr("abc", 3);
        System.out.println(ans);
    }
}
