package leetcode.p2021m11;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/21
 * @time 10:22 PM
 */
public class SnapshotArray {

    int version=0;
    int[] source;
    Map<Integer,TreeMap<Integer,Integer>> modifyChainMap =new HashMap<>();
    public SnapshotArray(int length) {
        source=new int[length];
    }

    public void set(int index, int val) {

        if (!modifyChainMap.containsKey(index)){
            modifyChainMap.put(index,new TreeMap<>());
        }
        modifyChainMap.get(index).put(version,val);
    }

    public int snap() {
        int v=version;
        version++;
        return v;
    }

    public int get(int index, int snap_id) {
        if (!modifyChainMap.containsKey(index)){
            return 0;
        }

        TreeMap<Integer,Integer> treeMap=modifyChainMap.get(index);
        Map.Entry<Integer,Integer> lastestEntry=treeMap.floorEntry(snap_id);
        if (lastestEntry==null){
            return 0;
        }else{
            return lastestEntry.getValue();
        }
    }
}
