package leetcode.p20210218;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution131 {

    private List<List<String>> list;
    class Node{
        public Node parent=null;
        public String val;
        public Map<String,Node> nextNodes=new HashMap<>();

    }
    public List<List<String>> partition(String s) {

        List<List<String>> ret=new ArrayList<>();
        Node root=new Node();
        root.val=s;
        dfs(root,new ArrayList<>());

        return ret;
    }

    private boolean isPlalindrome(String s){
        int len=s.length();
        if (s.length()==1){
            return true;
        }
        if (s.length()==2){
            return s.charAt(0)==s.charAt(1);
        }
        for (int i=0;i<len >>> 1;i++){
            if (s.charAt(i)!=s.charAt(len-1-i)){
                return false;
            }
        }

        return true;
    }


    public void dfs(Node node,List<String> item){
        for (int i=0;i<node.val.length();i++){
            int startIndex=0;
            int endIndex=i+1;
            String edge=node.val.substring(startIndex,endIndex);
            Node newNode=new Node();
            newNode.parent=node;
            newNode.val=node.val.substring(endIndex);
            if (!isPlalindrome(edge)){
                continue;
            }
            node.nextNodes.put(edge,newNode);
        }

        for (Map.Entry<String,Node> entry:node.nextNodes.entrySet()){
            Node childNode=entry.getValue();
            dfs(childNode,item);
        }


    }



    public void collect(Node root){
        if (root.val.isEmpty()){
            List<String> ans=new ArrayList<>();
            while (root!=null){
//                bintree.add(root)
            }
            list.add(ans);
        }
    }

    public static void main(String[] args){
        Solution131 solution131=new Solution131();
        solution131.partition("aab");

        System.out.println();

//        int[] a1=new int[]{1,2,3,1,2};
//
//
//        System.out.println(Arrays.stream(a1).boxed().filter(item->item==1).collect(Collectors.toList()));

    }


}
