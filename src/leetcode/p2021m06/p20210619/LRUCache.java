package leetcode.p2021m06.p20210619;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/20
 * @time 4:43 PM
 */
public class LRUCache {
    class LRUNode{
        public int key;
        public int value;
        public LRUNode(int key,int value){
            this.value=value;
            this.key=key;
        }


        public LRUNode shadowClone() {
            return new LRUNode(key,value);
        }
    }

    private Map<Integer,LRUNode> cacheMap;
    private LinkedList<LRUNode>  cachedList;
    private int                  maxCapacity;
    public LRUCache(int capacity) {

        cacheMap=new HashMap<>();
        this.maxCapacity =capacity;
        cachedList=new LinkedList<>();

    }


    public int get(int key) {
        if (cacheMap.containsKey(key)){
            int ans=cacheMap.get(key).value;

                LRUNode temp=cacheMap.get(key);
                cachedList.remove(temp);
                LRUNode newNode=temp.shadowClone();
                cachedList.addFirst(newNode);
                cacheMap.put(key,newNode);

            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {

        //没有满的话,直接倒序插入
        if (cacheMap.size()< maxCapacity){
            if (!cacheMap.containsKey(key)){
                LRUNode node=new LRUNode(key,value);
                cachedList.addFirst(node);
                cacheMap.put(key,node);
            }else{
                //删除当前位置的元素，直接插入到头部
                LRUNode oldNode=cacheMap.get(key);
                cachedList.remove(oldNode);
                cacheMap.remove(oldNode.key);
                LRUNode newNode=new LRUNode(key, value);
                cachedList.addFirst(newNode);
                cacheMap.put(key,newNode);
            }
        }
        //准备删除最后的链表的元素,再头部插入
        else{
            if (!cacheMap.containsKey(key)) {
                LRUNode lastOne = cachedList.getLast();
                LRUNode newNode = new LRUNode(key, value);
                cachedList.remove(lastOne);
                cacheMap.remove(lastOne.key);
                cachedList.addFirst(newNode);
                cacheMap.put(key, newNode);
            }else{
                cachedList.remove(cacheMap.get(key));
                LRUNode newNode = new LRUNode(key, value);
                cachedList.addFirst(newNode);
                cacheMap.put(key, newNode);
            }
        }

    }

    public static void main(String[] args){
        LRUCache cache=new LRUCache(2);
        //[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
