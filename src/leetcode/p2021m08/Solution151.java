package leetcode.p2021m08;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 10:45 PM
 */
public class Solution151 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] chars  = s.toCharArray();
        int    length = s.length();
        reverse(chars, 0, length - 1);

        int i = 0;

        while (i < length) {
            while (i < length && chars[i] == ' ') {
                i++;
            }

            int j = i + 1;
            while (j < length && chars[j] != ' ') {
                j++;
            }

            reverse(chars, i, j - 1);

            i = j;
        }

        int k = 0;
        i = 0;
        while (i < length) {
            if (chars[i] == ' ') {
                chars[k++] = ' ';
                int j = i + 1;
                while (j < length && chars[j] == ' ') {
                    j++;
                }
                i = j;
            } else {
                chars[k++] = chars[i];
                i++;
            }
        }

        return new String(chars, 0, k).trim();
    }

    private void reverse(char[] array, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String      res         = solution151.reverseWords("  hello world  ");
        System.out.println(res);
    }
}
