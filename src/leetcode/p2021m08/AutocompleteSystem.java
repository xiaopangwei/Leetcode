package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/11
 * @time 11:32 PM
 */
public class AutocompleteSystem {

    static class Trie {
        public int weight = 0;
        public String str;
        public boolean              isTerminal = false;
        public Map<Character, Trie> nextMap    = new HashMap<>();

        public Trie(String str, boolean isTerminal) {
            this.str = str;
            this.isTerminal = isTerminal;
        }

        public void addNext(char current, Trie trie) {
            nextMap.put(current, trie);
        }

        public boolean contains(char current) {
            return nextMap.containsKey(current);
        }

    }

    public Trie dummyRoot = new Trie("", false);

    private List<Trie> characterTrie = new ArrayList<>();

    private boolean firstFlag = true;

    private String prefix = null;

    public AutocompleteSystem(String[] sentences, int[] times) {

        int length = sentences.length;


        for (int i = 0; i < length; i++) {
            Trie   p          = dummyRoot;
            int    weight     = times[i];
            String prev       = "";
            String currentSen = sentences[i];
            int    senLen     = sentences[i].length();
            for (int j = 0; j < senLen; j++) {
                char   current = currentSen.charAt(j);
                String str     = concat(prev, current);
                prev = str;
                if (p.contains(current)) {
                    p = p.nextMap.get(current);
                    if (j == senLen - 1) {
                        p.weight = weight;
                        p.isTerminal = true;
                    }
                } else {
                    Trie temp = null;
                    if (j == senLen - 1) {
                        temp = new Trie(str, true);
                        temp.weight = weight;
                    } else {
                        temp = new Trie(str, false);
                    }

                    p.addNext(current, temp);
                    p = temp;
                }

            }
        }
    }

    private String concat(String prev, char current) {
        StringBuilder builder = new StringBuilder(prev);
        builder.append(String.valueOf(current));
        return builder.toString();
    }


    public List<String> input(char c) {

        if (c == '#') {
            char[] array  = prefix.toCharArray();
            Trie   p      = dummyRoot;
            String prev   = "";
            int    senLen = array.length;
            for (int j = 0; j < senLen; j++) {
                char   current = array[j];
                String str     = concat(prev, current);
                prev = str;
                if (p.contains(current)) {
                    Trie nextTrie = p.nextMap.get(current);
                    if (j == senLen - 1) {
                        nextTrie.weight++;
                        nextTrie.isTerminal = true;
                    }
                    p = nextTrie;
                } else {
                    Trie temp = null;
                    if (j == senLen - 1) {
                        temp = new Trie(str, true);
                        temp.weight = 1;
                    } else {
                        temp = new Trie(str, false);
                        temp.weight = 1;
                    }
                    p.addNext(current, temp);
                    p = temp;
                }
            }
            characterTrie.clear();
            firstFlag = true;
            prefix = null;
            return new ArrayList<>();
        }
        PriorityQueue<Trie> queue = new PriorityQueue<>(new Comparator<Trie>() {
            @Override
            public int compare(Trie o1, Trie o2) {
                if (o1.weight != o2.weight) {
                    return o1.weight - o2.weight;
                } else if (!o1.str.equals(o2.str)) {
                    return o2.str.compareTo(o1.str);
                }
                return 0;
            }
        });
        if (!firstFlag) {
            prefix = concat(prefix, c);
            Iterator<Trie> iterator = characterTrie.iterator();
            while (iterator.hasNext()) {
                Trie t = iterator.next();
                if (!t.nextMap.keySet().contains(c)) {
                    iterator.remove();
                }
            }
            for (int i = 0; i < characterTrie.size(); i++) {
                Trie t = characterTrie.get(i);
                characterTrie.set(i, t.nextMap.get(c));
            }
        } else {
            prefix = String.valueOf(c);
            findPrefixRoot(dummyRoot, characterTrie, c);
            firstFlag = false;
        }
        for (Trie t : characterTrie) {
            dfs(queue, t);
        }
        LinkedList<String> ans = new LinkedList<>();

        List<Trie> removedList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Trie   temp = queue.poll();
            String val  = temp.str;
            ans.addFirst(val);
            removedList.add(temp);
        }

        for (Trie t : removedList) {
            queue.add(t);
        }
        return ans;
    }


    private void dfs(PriorityQueue<Trie> queue, Trie root) {
        if (root == null) {
            return;
        }

        if (root.isTerminal) {
            if (queue.size() < 3) {
                queue.add(root);
            } else {
                if (!queue.isEmpty()) {
                    Trie currentSmallest = queue.peek();
                    if (root.weight > currentSmallest.weight) {
                        queue.poll();
                        queue.add(root);
                    } else if (root.weight == currentSmallest.weight && root.str.compareTo(currentSmallest.str) < 0) {
                        queue.poll();
                        queue.add(root);
                    }
                }
            }
        }

        Set<Character> chs = root.nextMap.keySet();
        for (char ch : chs) {
            dfs(queue, root.nextMap.get(ch));
        }

    }

    public void findPrefixRoot(Trie root, List<Trie> queue, final char ch) {
        if (root == null) {
            return;
        }
        Map<Character, Trie> nextMap = root.nextMap;
        Set<Character>       keySet  = nextMap.keySet();
        if (keySet.contains(ch)) {
            queue.add(nextMap.get(ch));
        }
    }

    public static void main(String[] args) {
        String[] array = new String[]{"abc", "abbc", "a"};
        int[]    times = new int[]{3, 3, 2};

//        String[]           array              = new String[]{"ab", "ac", "abc", "cc", "ccz", "ccg", "cca", "ccd"};
//        int[]              times              = new int[]{5, 3, 2, 1, 10, 10, 10, 10};
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(array, times);
        System.out.println(autocompleteSystem);
        List<String> ans = autocompleteSystem.input('a');
        System.out.println(ans);
//        ans = autocompleteSystem.input(' ');
//        System.out.println(ans);
//        ans = autocompleteSystem.input('a');
//        System.out.println(ans);
//        ans = autocompleteSystem.input('#');
//        System.out.println(ans);
    }


}
