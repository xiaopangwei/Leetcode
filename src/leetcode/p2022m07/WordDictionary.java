package leetcode.p2022m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/7/25
 * @time 8:47 PM
 */
public class WordDictionary {
    class TrieNode {
        boolean isTerminated = false;
        char                     ch;
        Map<Character, TrieNode> next;

        public TrieNode(char ch) {
            this.ch = ch;
            next = new HashMap<>();
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode(' ');
    }

    public void addWord(String word) {

        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.next.containsKey(ch)) {
                p = p.next.get(ch);
            } else {
                TrieNode temp = new TrieNode(ch);
                p.next.put(ch, temp);
                p = temp;
            }

            if (i == word.length() - 1) {
                p.isTerminated = true;
            }
        }
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }


    public boolean search(String word, int index, TrieNode node) {
        if (index >= word.length()) {
            return true;
        }
        TrieNode p  = node;
        char     ch = word.charAt(index);
        if (ch == '.') {
            if (p.next.isEmpty()) {
                return false;
            } else {
                for (Map.Entry<Character, TrieNode> entry : p.next.entrySet()) {
                    if (search(word, index + 1, entry.getValue())) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if (p.next.containsKey(ch)) {
                return search(word, index + 1, p.next.get(ch));
            } else {
                return false;
            }
        }

    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int item : nums) {
            freq.put(item, freq.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getValue();
            if (pq.size() < k) {
                pq.add(entry);
            } else {
                if (pq.peek().getValue() < value) {
                    pq.poll();
                    pq.add(entry);
                }
            }
        }

        int[] ans   = new int[k];
        int   index = 0;
        while (!pq.isEmpty()) {
            ans[index++] = pq.poll().getKey();
        }
        return ans;

    }

    static class SkipNode {
        int      value;
        SkipNode right;
        SkipNode down;

        public SkipNode(int value) {
            this.value = value;
        }
    }

    SkipNode head;

    class Skiplist {

        public Skiplist() {
            head = new SkipNode(Integer.MIN_VALUE);
        }

        public boolean search(int target) {
            SkipNode p = head;
            while (p != null) {
                if (p.right != null) {
                    if (p.right.value == target) {
                        return true;
                    }
                    if (p.value < target && target < p.right.value) {
                        p = p.down;
                    } else {
                        p = p.right;
                    }
                } else {
                    p = p.down;
                }
            }
            return false;
        }

        public void add(int target) {
            Stack<SkipNode> stack = new Stack<>();
            SkipNode        p     = head;
            boolean         ans   = false;
            while (p != null) {
                if (p.right != null) {
                    if (p.right.value == target) {
                        if (!ans) {
                            ans = true;
                        }
                        SkipNode node = p.right;
                        p.right = node.right;
                        p = node;
                    }
                    if (p.value < target && target < p.right.value) {
                        stack.add(p);
                        p = p.down;
                    } else {
                        p = p.right;
                    }
                } else {
                    p = p.down;
                }
            }

            SkipNode down       = null;
            boolean  isContinue = true;
            while (!stack.isEmpty()) {
                SkipNode t = stack.pop();

                SkipNode newNode = new SkipNode(target);
                newNode.right = t.right;
                t.right = newNode;
                newNode.down = down;
                down = newNode;

                double probe=Math.random();
                if (probe<=0.5){
                    break;
                }
            }
        }

        public boolean erase(int target) {
            SkipNode p   = head;
            boolean  ans = false;
            while (p != null) {
                if (p.right != null) {
                    if (p.right.value == target) {
                        if (!ans) {
                            ans = true;
                        }
                        SkipNode node = p.right;
                        p.right = node.right;
                        p = node;
                    }
                    if (p.value < target && target < p.right.value) {
                        p = p.down;
                    } else {
                        p = p.right;
                    }
                } else {
                    p = p.down;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

    }


}
