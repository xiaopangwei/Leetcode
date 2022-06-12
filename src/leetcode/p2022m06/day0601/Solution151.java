package leetcode.p2022m06.day0601;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 2:52 PM
 */
public class Solution151 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int    n     = array.length;
        swap(array, 0, n - 1);
        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n && array[j] != ' ') {
                j++;
            }
            swap(array, i, j - 1);
            while (j < n && array[j] == ' ') {
                j++;
            }

            i = j;
        }

        i = 0;
        while (i < n && array[i] == ' ') {
            i++;
        }

        int index = 0;
        int j     = 0;
        while (i < n) {
            j = i;
            while (j < n && array[j] != ' ') {
                array[index++] = array[j++];
            }
            if (index < n) {
                array[index++] = ' ';
            } else {
                break;
            }
            while (j < n && array[j] == ' ') {
                j++;
            }
            i = j;
        }

        if (array[index - 1] == ' ') {
            index--;
        }
        String ans = new String(array, 0, index);
        return ans;
    }

    private void swap(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String      ans         = solution151.reverseWords("the sky is blue");
        System.out.println(ans);
    }
}
