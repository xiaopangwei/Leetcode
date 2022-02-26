package leetcode.p2022m02;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/19
 * @time 2:01 PM
 */
public class SolutionMS1620 {
    public List<String> getValidT9Words(String num, String[] words) {
        String[] array = new String[10];
        array[2] = "abc";
        array[3] = "def";
        array[4] = "ghi";
        array[5] = "jkl";
        array[6] = "mno";
        array[7] = "pqrs";
        array[8] = "tuv";
        array[9] = "wxyz";

        List<String> ans = new ArrayList<>();

        int index;
        for (String word : words) {
            index = 0;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                String temp = array[num.charAt(index) - '0'];
                if (temp.contains(String.valueOf(word.charAt(i)))) {
                    index++;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        SolutionMS1620 solutionMS1620 = new SolutionMS1620();
        List<String>   ans            = solutionMS1620.getValidT9Words("2", new String[]{"a", "b","c","d"});
        System.out.println(ans);
    }


}
