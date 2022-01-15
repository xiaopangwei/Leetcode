package leetcode.p2022m01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/15
 * @time 4:58 PM
 */
public class Solution1233 {

    private List<String> ans = new ArrayList<>();

    class Trie {
        Map<String, Trie> subMap = new HashMap<>();
        boolean isTerminal;
        String  content;


        public Trie(String content) {
            this.content = content;
            this.isTerminal = false;
        }


        public void insert(String s, Trie root) {
            String[] array = s.split("/");
            Trie     t     = root;
            for (int i = 0; i < array.length; i++) {
                String item = array[i];
                if (item.isEmpty()) {
                    continue;
                }
                if (t.subMap.containsKey(item)) {
                    t = t.subMap.get(item);
                    if (i==array.length-1){
                        t.isTerminal=true;
                    }
                } else {
                    Trie temp = new Trie(item);
                    if (i == array.length - 1) {
                        temp.isTerminal = true;
                    }
                    t.subMap.put(item, temp);
                    t = temp;
                }
            }
        }

        public void traverse(Trie root, List<String> tmp) {
            if (root == null) {
                return;
            }

            tmp.add(root.content);
            if (root.isTerminal) {
                if (!root.content.isEmpty()) {
                    String t = String.join("/", tmp);
                    if (!t.isEmpty() && !"/".equals(t)) {
                        ans.add(t);
                    }
                }
            } else {
                for (Trie trie : root.subMap.values()) {
                    traverse(trie, tmp);
                }
            }
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<String> removeSubfolders(String[] folder) {

        Trie root = new Trie("");

        for (String s : folder) {

            root.insert(s, root);
        }

        root.traverse(root, new ArrayList<>());

        return ans;

    }

    public static void main(String[] args) {
        Solution1233 solution1233 = new Solution1233();
        //["/ah/al/am","/ah/al"]
        List<String> ans          = solution1233.removeSubfolders(new String[]{"/ah/al/am","/ah/al"});
        System.out.println(ans);

    }
}
