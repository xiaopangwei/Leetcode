package leetcode.p2021m11;


import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/27
 * @time 3:20 PM
 */
public class Solution126 {
    class Node {
        Node   prev;
        String word;

        public Node(String word) {
            this.word = word;
        }

        public Node(String word, Node prev) {
            this.word = word;
            this.prev = prev;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return new ArrayList<>();
        }

        return bfs(beginWord, endWord, wordList);

    }

    private List<List<String>> bfs(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans   = new ArrayList<>();
        Queue<Node>        queue = new LinkedList<>();
        queue.add(new Node(beginWord, null));


        List<Node> end = new ArrayList<>();

        boolean flag = false;

        Set<String> visited = new HashSet<>();


        while (!queue.isEmpty()) {

            int size = queue.size();
            if (flag) {
                break;
            }
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                visited.add(temp.word);
                if (temp.word.equals(endWord)) {
                    flag = true;
                    end.add(temp);
                }

                for (String word : wordList) {
                    if (check(temp.word, word) && !visited.contains(word)) {
                        queue.add(new Node(word, temp));
//                        visited.add(word);
                    }
                }
            }

        }

        for (Node t : end) {
            LinkedList<String> list = new LinkedList<>();

            Node temp = t;
            while (temp != null) {
                list.addFirst(temp.word);
                temp = temp.prev;
            }

            ans.add(list);


        }

        return ans;

    }

    private boolean check(String s1, String s2) {
        int len = s1.length();
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (cnt != 0) {
                    return false;
                } else {
                    cnt++;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
        List<List<String>> ans=solution126.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(ans);
    }
}
