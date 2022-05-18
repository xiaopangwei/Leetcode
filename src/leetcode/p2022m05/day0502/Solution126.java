package leetcode.p2022m05.day0502;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/2
 * @time 3:32 PM
 */
public class Solution126 {
    List<List<String>> ans = new ArrayList<>();
    boolean[] visited;
    String    begin;
    String    end;

    int shorestLen;


    class Node {
        List<String> prev;
        String       curr;

        public Node(String curr) {
            prev = new ArrayList<>();
            this.curr = curr;
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        this.begin = beginWord;
        this.end = endWord;
        visited = new boolean[wordList.size()];
        shorestLen = wordList.size() + 1;
        bfs(wordList);
        return ans;
    }


    private void bfs(List<String> wordList) {
        Queue<Node> queue = new LinkedList<>();
        Node        node  = new Node(begin);
        node.prev.add(begin);
        queue.add(node);
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node s = queue.poll();
                if (s.curr.equals(end)) {
                    found = true;
                    ans.add(s.prev);
                }

                if (!found) {
                    for (int j = 0; j < wordList.size(); j++) {
                        String temp = wordList.get(j);
                        if (s.prev.contains(temp)) {
                            continue;
                        }

                        if (check(temp, s.curr)) {
                            Node newNode=new Node(temp);
                            newNode.prev.addAll(s.prev);
                            newNode.prev.add(temp);
                            newNode.curr = temp;
                            queue.add(newNode);
                        }
                    }
                }

            }

            if (found) {
                break;
            }
        }

    }


    private boolean check(String dst, String src) {
        int count = 0;
        for (int t = 0; t < src.length(); t++) {
            if (src.charAt(t) != dst.charAt(t)) {
                if (count <= 0) {
                    count++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution126 solution126 = new Solution126();
        System.out.println(solution126.findLadders("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));
    }
}
