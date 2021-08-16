package demo.test20210120;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/11
 * @time 1:58 PM
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();


        int    maxLen = Math.max(len1, len2);
        int[]  carry  = new int[maxLen];
        int    gap    = Math.abs(len1 - len2);
        if (len1 < len2) {
            for (int i = 0; i < gap; i++) {
                num1 = "0" + num1;
            }
        } else if (len1 > len2) {
            for (int i = 0; i < gap; i++) {
                num2 = "0" + num2;
            }
        }
        char[] array1 = num1.toCharArray();
        char[] array2 = num2.toCharArray();
        int[] result = new int[maxLen];

        int firstCarry = 0;
        for (int i = maxLen - 1; i >= 0; i--) {
            int a1 = Character.digit(array1[i], 10);
            int a2 = Character.digit(array2[i], 10);

            int sum = a1 + a2 + carry[i];
            if (i >= 1) {
                carry[i - 1] += sum / 10;
            } else {
                firstCarry = sum / 10;
            }
            result[i] = sum % 10;
        }

        if (firstCarry == 0) {
            char[] charArray = new char[maxLen];
            for (int i = 0; i < result.length; i++) {
                charArray[i] = Character.forDigit(result[i], 10);
            }
            return new String(charArray);
        } else {
            char[] charArray = new char[maxLen + 1];
            charArray[0] = Character.forDigit(firstCarry, 10);
            for (int i = 1; i < result.length+1; i++) {
                charArray[i] = Character.forDigit(result[i-1], 10);
            }
            return new String(charArray);
        }
    }

    public static void main(String[] args){
        Solution415 solution415=new Solution415();
        String ans=solution415.addStrings("9","99");
        System.out.print(ans);
    }
}
