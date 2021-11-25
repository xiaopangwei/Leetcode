package leetcode.p2021m11;

import common.CustomTrie;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/24
 * @time 9:37 PM
 */
public class StreamChecker {
    StringBuilder builder = new StringBuilder();
    CustomTrie trie;

    public StreamChecker(String[] words) {

        trie = new CustomTrie("");
        for (String w : words) {
            String newWord = new StringBuilder(w).reverse().toString();
            CustomTrie.insert(trie, newWord);
        }
    }

    public boolean query(char letter) {
        builder.append(letter);
        CustomTrie t    = trie;
        int        size = builder.length();
        for (int i = size - 1; i >= 0; i--) {
            char ch = builder.charAt(i);
            if (!t.nextNodeMap.containsKey(ch)) {
                return false;
            }

            CustomTrie customTrie = t.nextNodeMap.get(ch);
            if (customTrie == null) {
                return false;
            }
            if (customTrie.terminated) {
                return true;
            }
            t = customTrie;
        }

        return false;
    }

    public static void main(String[] args){
        StreamChecker streamChecker=new StreamChecker(new String[]{"cd","f","kl"});
        for (char ch='a';ch<='l';ch++){
            System.out.println(ch+" => "+streamChecker.query(ch));
        }
    }
}
