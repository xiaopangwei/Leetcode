package leetcode.p2022m01;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/1/5
 * @time 10:16 PM
 */
public class MyLRUCache {
    static class LRUNode{
        public int key;
        public int value;

        public LRUNode(int k,int v){
            this.key=k;
            this.value=v;
        }
    }

    private LinkedList<LRUNode> list;
    private int                 capacity;
    Map<Integer,LRUNode> map;

    public MyLRUCache(int capacity) {
        this.capacity=capacity;
        list=new LinkedList<>();
        map=new HashMap<>();
    }


    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode t= map.get(key);
            list.remove(t);
            list.addFirst(t);
            return t.value;
        }

        return -1;
    }



    public void put(int key, int value) {
        if(map.containsKey(key)){
            LRUNode temp=map.get(key);
            list.remove(temp);
            temp.value=value;
            list.addFirst(temp);
            map.put(key,temp);
        }else{
            LRUNode temp=new LRUNode(key,value);
            if(map.keySet().size()<this.capacity){
                list.addFirst(temp);
                map.put(key,temp);
            }else{
                LRUNode node=list.removeLast();
                map.remove(node.key);
                list.addFirst(temp);
                map.put(key,temp);
            }

        }
    }
}
