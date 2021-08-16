package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/25
 * @time 9:41 AM
 */
public class Solution1743 {
    static class Node{

        public int value;
        public Node peer1;
        public Node peer2;

        public Node(int value, Node peer1, Node peer2){
            this.value=value;
            this.peer1=peer1;
            this.peer2=peer2;
        }

    }
    public int[] restoreArray(int[][] adjacentPairs) {
        int totalLen=adjacentPairs.length;
        Map<Integer,Node> map=new HashMap<>();
        for (int i=0;i<totalLen;i++){
            if (!map.containsKey(adjacentPairs[i][0])){
                map.put(adjacentPairs[i][0],new Node(adjacentPairs[i][0],null,null));
            }

            if (!map.containsKey(adjacentPairs[i][1])){

                map.put(adjacentPairs[i][1],new Node(adjacentPairs[i][1],null,null));
            }

            if (map.get(adjacentPairs[i][0]).peer1==null){
                map.get(adjacentPairs[i][0]).peer1=map.get(adjacentPairs[i][1]);
            }else{
                map.get(adjacentPairs[i][0]).peer2=map.get(adjacentPairs[i][1]);
            }

            if (map.get(adjacentPairs[i][1]).peer1==null){
                map.get(adjacentPairs[i][1]).peer1=map.get(adjacentPairs[i][0]);
            }else{
                map.get(adjacentPairs[i][1]).peer2=map.get(adjacentPairs[i][0]);
            }
        }


        Node start=null;
        for (Map.Entry<Integer,Node> temp:map.entrySet()){
            if (temp.getValue().peer2==null){
                start=temp.getValue();
                break;
            }
        }

        if (start==null){
            return null;
        }

        List<Integer> ans=new ArrayList<>();
        Map<Integer,Boolean> visited=new HashMap<>();
        Node tempNode=start;

        while (tempNode!=null){
            visited.put(tempNode.value,true);
            ans.add(tempNode.value);

            Node next=null;
            if (!visited.containsKey(tempNode.peer1.value)){
                next=tempNode.peer1;
            }else{
                next=tempNode.peer2;
            }
            tempNode=next;
        }


        int[] res=new int[ans.size()];
        int k=0;
        for (int i=0;i<ans.size();i++){
            res[k++]=ans.get(i);
        }
        return res;


    }

    public static void main(String[] args){
        Solution1743 solution1743=new Solution1743();
        //{2,1},{3,4},{3,2}
        //{4,-2},{1,4},{-3,1}
        int[] res=solution1743.restoreArray(new int[][]{{1,2},{2,3},{3,4}});
        System.out.println(Arrays.toString(res));
    }
}
