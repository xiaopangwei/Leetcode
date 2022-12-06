package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/4
 * @time 10:28 PM
 */
public class Solution6253 {
    public boolean isCircularSentence(String sentence) {
        String[] array = sentence.split(" ");
        for (int i = 1; i < array.length; i++) {
            if (array[i].charAt(0) != array[i - 1].charAt(array[i - 1].length() - 1)) {
                return false;
            }
        }
        return sentence.charAt(0)==sentence.charAt(sentence.length()-1);
    }

    public static void main(String[] args) {
        Solution6253 solution6253 = new Solution6253();
        System.out.println(solution6253.isCircularSentence("Leetcode is cool"));
    }
}
