package leetcode.p2021m09;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/9/21
 * @time 11:14 AM
 */
public class Solution1576 {
    public String modifyString(String s) {

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '?') {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (i > 0 && ch == array[i - 1]) {
                        continue;
                    }
                    if (i < array.length - 1 && ch == array[i + 1]) {
                        continue;
                    }

                    array[i] = ch;
                    break;
                }
            }
        }

        return new String(array);
    }

    public static void main(String[] args){
        Solution1576 solution1576=new Solution1576();
        String ans=solution1576.modifyString("???");
        System.out.println(ans);
    }
}
