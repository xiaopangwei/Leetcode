package leetcode.p2021m08;

import common.CustomTrie;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 2:05 PM
 */
public class Solution425 {

    List<List<String>> ans  = new ArrayList<>();
    CustomTrie         root = new CustomTrie("");

    public List<List<String>> wordSquares(String[] words) {
        ans.clear();
        for (String line : words) {
            CustomTrie.insert(root, line);
        }
        int          singelWordLength = words[0].length();
        List<String> tempList         = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            tempList.add(words[i]);
            dfs(tempList, singelWordLength);
            tempList.remove(tempList.size() - 1);
        }

        return ans;
    }

    public List<String> search(String prefix) {
        return CustomTrie.searchTerminated(root, prefix);
    }

    public void dfs(List<String> temp, final int len) {
        if (temp.size() == len) {
            List<String> copy = new ArrayList<>();
            copy.addAll(temp);
            ans.add(copy);
            return;
        }
        int           size    = temp.size();
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < size; j++) {
            builder.append(temp.get(j).charAt(size));
        }
        String prefix = builder.toString();

        List<String> prefixList = search(prefix);
        if (prefixList != null && !prefixList.isEmpty()) {
            for (int i = 0; i < prefixList.size(); i++) {
                temp.add(prefixList.get(i));
                dfs(temp, len);
                temp.remove(temp.size() - 1);
            }
        }

    }


    public static void main(String[] args) {
        Solution425        solution425 = new Solution425();
        List<List<String>> ans         = solution425.wordSquares(new String[]{"abat","baba","atan","atal"});
        System.out.println(ans);
    }
}
