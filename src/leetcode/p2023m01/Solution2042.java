package leetcode.p2023m01;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2023/1/5
 * @time 8:57 PM
 */
public class Solution2042 {
    public boolean areNumbersAscending(String s) {

        int      currentMax = -1;
        String[] array      = s.split(" ");
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() == 0) {
                continue;
            }
            char ch = array[i].charAt(0);
            if (Character.isDigit(ch)) {
                int val = Integer.parseInt(array[i]);
                if (val <= currentMax) {
                    return false;
                } else {
                    currentMax = val;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution2042 solution2042=new Solution2042();
        System.out.println(solution2042.areNumbersAscending("hello world 5 x 5"));
    }
}
