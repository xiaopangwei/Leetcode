package leetcode.p2021m11;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/21
 * @time 9:12 PM
 */
public class Solution784 {
    List<String> ans = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {


        dfs(0,s.toCharArray());
        return ans;
    }

    private void dfs(int index, char[] array) {
        if (index == array.length) {
            String t = new String(array);
            if (!ans.contains(t)) {
                ans.add(t);
            }
            return;
        }
        char temp = array[index];
        if (temp >= '0' && temp <= '9') {
            dfs(index + 1, array);
        } else {

            dfs(index + 1, array);
            if (temp >= 'a' && temp <= 'z') {
                array[index] = (char) (temp + 'A' - 'a');
                dfs(index + 1, array);
                array[index] = temp;
            } else {
                array[index] = (char) (temp + 'a' - 'A');
                dfs(index + 1, array);
                array[index] = temp;
            }
        }
    }

    public static void main(String[] args){
        Solution784 solution784=new Solution784();
        List<String> ans=solution784.letterCasePermutation("12345");
        System.out.println(ans);
    }
}
