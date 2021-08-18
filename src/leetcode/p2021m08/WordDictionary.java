package leetcode.p2021m08;

import common.CustomTrie;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 1:54 PM
 */
public class WordDictionary {
    private CustomTrie root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new CustomTrie("");
    }

    public void addWord(String word) {

        CustomTrie.insert(root, word);
    }

    public boolean search(String word) {

        return CustomTrie.exist(root, word, 0);
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

}
