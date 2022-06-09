package leetcode.p2022m06.day0601;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 10:47 PM
 */
public class WordFilter {
    static class TrieNode {
        public int     index      = -1;
        public boolean isTerminal = false;
        char val;
        Map<Character, TrieNode> nextMap = new HashMap<>();

        public TrieNode(char val) {
            this.val = val;
        }

        public boolean containsNext(char key) {
            return this.nextMap.containsKey(key);
        }
    }

    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode(' ');

        for (int i = 0; i < words.length; i++) {
            String item = words[i];
            int    n    = item.length();
            for (int j = 1; j <= n; j++) {
                String temp  = item.substring(n - j, n);
                String biKey = temp + "#" + item;
//                System.out.println(biKey);
                add(biKey, i);
            }
        }
    }

    public int f(String prefix, String suffix) {
        String   biKey = suffix + "#" + prefix;
        TrieNode p     = root;

        for (int i = 0; i < biKey.length(); i++) {
            if (!p.containsNext(biKey.charAt(i))) {
                return -1;
            }
            p = p.nextMap.get(biKey.charAt(i));
        }

        if (p != null) {
            return p.index;
        }
        return -1;
    }

    private void add(String word, int index) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.containsNext(ch)) {
                if (p.index < index) {
                    p.index = index;
                }
                p = p.nextMap.get(ch);
            } else {
                TrieNode newNode = new TrieNode(ch);
                newNode.index = index;
                p.nextMap.put(ch, newNode);
                p = newNode;
            }
            if (i == word.length() - 1) {
                p.isTerminal = true;
            }
        }
    }

    public static void main(String[] args) {
        WordFilter wordFilter = new WordFilter(new String[]{"apple"});
        int        index      = wordFilter.f("a", "e");
        System.out.println(index);
    }

}
