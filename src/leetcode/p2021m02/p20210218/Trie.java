package leetcode.p2021m02.p20210218;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/19
 * @time 10:08 AM
 */
public class Trie {

    private Node root;
    class Node{
        char value;
        boolean terminated=false;
        Map<Character,Node> nextNodes=new HashMap<>();

        public void  addNext(char c,Node node){
            nextNodes.put(c,node);
        }
    }
    /** Initialize your data structure here. */
    public Trie() {
        root=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] array=word.toCharArray();
        Node node=root;
        for (int i=0;i<array.length;i++){
            char c=array[i];

            if (node.nextNodes.containsKey(c)){
                node=node.nextNodes.get(c);
            }
            else{
                Node newNode=new Node();
                newNode.value=c;
                node.addNext(c,newNode);
                node=node.nextNodes.get(c);
            }
        }

        node.terminated=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] array=word.toCharArray();
        Node p=root;
        for (char c:array){
            if (p.nextNodes.containsKey(c)){
                p=p.nextNodes.get(c);
            }
            else{
                return false;
            }
        }

        if (p.terminated){
            return true;
        }
        else{
            return false;
        }
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] array=prefix.toCharArray();
        Node p=root;
        for (char c:array){
            if (p.nextNodes.containsKey(c)){
                p=p.nextNodes.get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String word="apple";
        String prefix="app";
        Trie obj = new Trie();
        obj.insert(word);
        System.out.println(obj.search(word));
        System.out.println(obj.search(prefix));
        System.out.println(obj.startsWith(word));
        System.out.println(obj.startsWith(prefix));
    }
}
