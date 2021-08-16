package leetcode.p20210218;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:25 PM
 */
public class WordTranslation {

    private int min=5001;
    class Node{
       String value;
       List<Node> nextList=new ArrayList<>();

       public void addNext(Node t){
           nextList.add(t);
       }
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Node root=new Node();
        root.value=beginWord;
        Map<String,Boolean> visited=new HashMap<>();
        for (String s:wordList){
            visited.put(s,false);
        }
        visited.put(beginWord,true);
        buildSolutions(root,endWord,beginWord.length(),wordList,visited,1);
        if (min==5001||min==0){
            return 0;
        }
        return min+1;

    }

    public List<String> getCandidates(List<String> data,final int wordLen,final String input){
        List<String> candidates=new ArrayList<>();
        for (String s:data) {
            for (int i=0;i<wordLen;i++) {
                //第i个字符不同
                //0-i-1相同
                //i+1-len-1相同
                if (s.charAt(i) != input.charAt(i) &&
                        input.substring(0, i).equals(s.substring(0, i)) &&
                        input.substring(i + 1, wordLen).equals(s.substring(i + 1, wordLen))) {
                    candidates.add(s);
                }
            }



        }
//        System.out.println(input+" "+candidates);
        return candidates;
    }

    public void buildSolutions(Node root,
                               String endWord,
                               int wordLen, List<String> wordList,
                               Map<String,Boolean> visited,int depth){



        List<String> candidates=getCandidates(wordList,wordLen,root.value);


        if (candidates.isEmpty()){
            min=0;
            return;
        }
        for (String str:candidates){
            if (!visited.getOrDefault(str,false)){
                Node next=new Node();
                next.value=str;
                root.addNext(next);
            }
        }

        for (Node node:root.nextList){
            if (node.value.equals(endWord)){
                min=Math.min(min,depth);
                return;
            }
            visited.put(root.value,true);
            buildSolutions(node,endWord,wordLen,wordList,visited,depth+1);
            visited.put(root.value,false);
        }

    }
    public static void main(String[] args){
        WordTranslation wordTranslation=new WordTranslation();
        //beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//        String[] a1=new String[]{"hot","dot","dog","lot","log"};
//        String[] a2=new String[]{"hot","dot","dog","lot","log","cog"};
        String[] a3=new String[]{"hot","dog"};
//        wordTranslation.ladderLength("hit","cog", Arrays.asList(a2));
        int ans=wordTranslation.ladderLength("hit","cog", Arrays.asList(a3));

        System.out.println(ans);
    }
}
