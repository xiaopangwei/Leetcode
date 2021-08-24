package leetcode.p2021m08;

import java.util.LinkedList;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/20
 * @time 10:50 PM
 */
public class Solution405 {
    public String toHex(int num) {


        char[]                array      = "0123456789abcdef".toCharArray();
        LinkedList<Character> linkedList = new LinkedList<>();
        int                   count      = 0;
        while (num != 0) {

            char ch = array[num & 0xf];
            linkedList.addFirst(ch);
            count++;
            if (count == 8) {
                break;
            }
            num = num >> 4;

        }


        char[] charArray = new char[linkedList.size()];
        int    k         = 0;
        for (char ch : linkedList) {
            charArray[k++] = ch;
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Solution405 solution405 = new Solution405();
        String ans=solution405.toHex(26);
        System.out.println(ans);
    }
}
