package leetcode.p2022m06.day0601;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/11
 * @time 2:45 PM
 */
public class Solution557 {
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int    i     = 0;
        while (i < s.length()) {

            int j = i + 1;
            while (j < array.length && array[j] != ' ') {
                j++;
            }
            swap(array,i,j-1);

            while (j < array.length && array[j] == ' ') {
                j++;
            }

            i=j;
        }
        return new String(array);
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

    public static void main(String[] args){
        Solution557 solution557=new Solution557();
        String str=solution557.reverseWords("God Ding");
        System.out.println(str);
    }
}
