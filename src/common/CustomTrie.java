package common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 10:46 AM
 */
public class CustomTrie {

    public String prefix;

    public boolean terminated = false;

    public Map<Character, CustomTrie> nextNodeMap;

    public int weight = 0;

    public CustomTrie(String value) {
        this.prefix = value;
        nextNodeMap = new TreeMap<>();
    }


    @Override
    public String toString() {
        return prefix + " " + terminated;
    }

    public static void insert(CustomTrie root, String original, int weight) {
        char[]     array = original.toCharArray();
        CustomTrie temp  = root;
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (!temp.nextNodeMap.containsKey(ch)) {
                String     newPrefix = temp.prefix + String.valueOf(ch);
                CustomTrie newTrie   = new CustomTrie(newPrefix);
                if (i == array.length - 1) {
                    newTrie.terminated = true;
                    newTrie.weight = weight;
                }
                temp.nextNodeMap.put(ch, newTrie);
                temp = newTrie;
            } else {
                temp = temp.nextNodeMap.get(ch);
                if (i == array.length - 1) {
                    temp.terminated = true;
                    temp.weight = weight;
                }
            }
        }
    }

    public static void insert(CustomTrie root, String original) {
        insert(root, original, 0);
    }

    public static CustomTrie search(CustomTrie root, String original) {
        char[]     array = original.toCharArray();
        CustomTrie temp  = root;
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (!temp.nextNodeMap.containsKey(ch)) {
                return null;
            } else {
                temp = temp.nextNodeMap.get(ch);
            }
        }
        return temp;
    }

    public static List<String> searchTerminated(CustomTrie root, String prefix) {
        List<String> res  = new ArrayList<>();
        CustomTrie   trie = search(root, prefix);
        if (trie == null) {
            return res;
        } else {
            dfs(trie, res);
            return res;
        }
    }


    public static String searchPrefix(CustomTrie root, String original) {
        char[]     array = original.toCharArray();
        CustomTrie temp  = root;
        boolean    flag  = true;
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (!temp.nextNodeMap.containsKey(ch)) {
                flag = false;
                break;
            } else {
                temp = temp.nextNodeMap.get(ch);
                if (temp.terminated) {
                    break;
                }
            }
        }
        if (flag) {
            return temp.prefix;
        } else {
            return original;
        }
    }

    public static void dfs(CustomTrie root, List<String> res) {

        if (root.terminated) {
            res.add(root.prefix);
        }
        Map<Character, CustomTrie> map = root.nextNodeMap;

        for (Map.Entry<Character, CustomTrie> entry : map.entrySet()) {
            dfs(entry.getValue(), res);
        }
    }

    public static boolean exist(CustomTrie root, String original, int index) {

        if (index == original.length()) {
            if (root.terminated) {
                return true;
            } else {
                return false;
            }
        }
        char ch = original.charAt(index);

        if (ch == '.') {
            boolean flag = false;
            for (CustomTrie t : root.nextNodeMap.values()) {
                flag = exist(t, original, index + 1);
                if (flag) {
                    flag = true;
                    break;
                }
            }
            return flag;
        } else {
            if (!root.nextNodeMap.containsKey(ch)) {
                return false;
            } else {
                return exist(root.nextNodeMap.get(ch), original, index + 1);
            }
        }
    }

    public static void main(String[] args) {
        CustomTrie root  = new CustomTrie("");
        String[]   array = new String[]{"a", "ac", "abc", "bd", "abb"};
        for (String line : array) {
            CustomTrie.insert(root, line);
        }

        System.out.println(CustomTrie.exist(root, ".e", 0));

//        String[] dict = new String[]{"b", "a", "huang", "ac", "abc", "ab", "bd", "abb"};
//        for (String line : dict) {
//            CustomTrie trie = root.search(root, line);
//            if (trie != null) {
//                System.out.println(line + " " + trie);
//            } else {
//                System.out.println(line + " " + "NULL");
//            }
//        }

    }
}
