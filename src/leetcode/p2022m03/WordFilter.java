package leetcode.p2022m03;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/20
 * @time 3:34 PM
 */
public class WordFilter {


    public TrieNode root = new TrieNode();

    public WordFilter(String[] words) {

        for (int i = 0; i < words.length; i++) {
            final int weight = i;
            for (int t = 0; t < words[i].length(); t++) {
                int    start = words[i].length() - t - 1;
                String left  = words[i].substring(start, words[i].length());
                String right = words[i];
                String temp  = left + "#" + right;
                root.insert(temp, weight);
            }
        }
    }

    public int f(String prefix, String suffix) {
        return root.search(suffix + "#" + prefix);
    }


    class TrieNode {
        Map<Character, TrieNode> next;
        int                      weight;
        char                     ch;

        public TrieNode() {
            next = new HashMap<>();
            weight = 0;
        }

        public void insert(String s, int index) {
            TrieNode p = WordFilter.this.root;

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.next.containsKey(c)) {
                    p = p.next.get(c);
                    p.weight = index;
                } else {
                    TrieNode t = new TrieNode();
                    t.ch = c;
                    t.weight = index;
                    p.next.put(c, t);
                    p = t;
                }
            }
        }

        public int search(String s) {
            TrieNode p    = WordFilter.this.root;
            TrieNode last = p;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (p.next.containsKey(c)) {
                    p = p.next.get(c);
                    last = p;
                } else {
                    return -1;
                }
            }
            return last.weight;
        }
    }

    public static void main(String[] args) {

        //apple

        //e le ple pple apple#apple
        //a aj aje ajee#ajee
        WordFilter wordFilter = new WordFilter(new String[]{"apple", "ajee"});
        int        index      = wordFilter.f("a", "e");
        System.out.println(index);
    }
}
