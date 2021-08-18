package leetcode.p2021m08;

import common.CustomTrie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 1:13 PM
 */
public class Solution648 {
    public String replaceWords(List<String> dictionary, String sentence) {

        CustomTrie root = new CustomTrie("");
        for (String line : dictionary) {
            CustomTrie.insert(root, line);
        }
        String[]     senArray = sentence.split(" ");
        List<String> output   = new ArrayList<>();
        for (String sen : senArray) {
            output.add(CustomTrie.searchPrefix(root, sen));
        }

        return String.join(" ", output);
    }


    public static void main(String[] args) {
        Solution648 solution648 = new Solution648();
        String ans = solution648.replaceWords(Arrays.asList("ac", "ab"),
                "it is abnormal that this solution is accepted");
        System.out.println(ans);
    }
}
