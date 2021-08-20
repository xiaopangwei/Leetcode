package leetcode.p2021m08;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/19
 * @time 9:35 AM
 */
public class Solution345 {
    public String reverseVowels(String s) {

        char[] array = s.toCharArray();

        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            while (i < j && !isVowels(array[i])) {
                i++;
            }
            while (i < j && !isVowels(array[j])) {
                j--;
            }
            swap(array, i++, j--);
        }
        return new String(array);
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public boolean isVowels(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
                ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        Solution345 solution345=new Solution345();
        System.out.println(solution345.reverseVowels("aaa"));
    }
}
