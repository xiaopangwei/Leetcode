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

        char[] array = s.toCharArray();
        reverse(array, 0, array.length - 1);

        int i = 0;
        while (i < s.length()) {
            //寻找第一个不是空格的字符
            while (i < s.length() && array[i] == ' ') {
                i++;
            }
            int j = i + 1;
            //寻找i后面第一个空格
            while (j < s.length() && array[j] != ' ') {
                j++;
            }

            reverse(array, i, j - 1);
            i = j;
        }


        String ans = trim(array, 0, array.length - 1);

        return ans.trim();


    }

    private void reverse(char[] array, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

    }


    public String trim(char[] array, int left, int right) {
        int a = left;
        int b = right;
        while (a < array.length && array[a] == ' ') {
            a++;
        }

        while (b >= 0 && a <= b && array[b] == ' ') {
            b--;
        }

        int i   = a;
        int idx = 0;
        while (i <= b) {
            if (array[i] != ' ') {
                array[idx++] = array[i];
                i++;
            } else {
                if (idx != 0) {
                    array[idx++] = ' ';
                }
                int j = i + 1;
                while (j < array.length && array[j] == ' ') {
                    j++;
                }
                i = j;
            }
        }

        return new String(array, 0, idx);
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
//        String      test1       = "the sky is blue";
//        System.out.println(test1.length());
//        System.out.println(test1.trim().length());
//        String      t           = solution151.trim(test1.toCharArray());
//        System.out.println(t.length());
//        System.out.println(t);
        String res = solution151.reverseWords("  hello world  ");
        System.out.println(res);
    }
}
