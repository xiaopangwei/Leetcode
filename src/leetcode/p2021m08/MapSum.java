package leetcode.p2021m08;

import common.CustomTrie;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/18
 * @time 11:26 AM
 */
public class MapSum {
    private CustomTrie root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new CustomTrie("");
    }

    public void insert(String key, int val) {
        CustomTrie.insert(root, key, val);
    }

    public int sum(String prefix) {
        CustomTrie temp = CustomTrie.search(root, prefix);
        if (temp == null) {
            return 0;
        }
        return dfs(temp);
    }


    public int dfs(CustomTrie dummy) {
        int sum = 0;
        sum += dummy.weight;

        for (CustomTrie trie : dummy.nextNodeMap.values()) {
            sum += dfs(trie);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        int ans = mapSum.sum("ap");           // return 3 (apple = 3)
        System.out.println(ans);
        mapSum.insert("app", 2);
        ans = mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
        System.out.println(ans);
    }
}
