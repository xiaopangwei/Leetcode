package leetcode.p2022m06.day0601;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/6/7
 * @time 8:51 PM
 */
public class Solution1245 {
    public int treeDiameter(int[][] edges) {
        Map<Integer,List<Integer>> map =new HashMap<>();
        for(int[] item:edges){
            int s=item[0];
            int e=item[1];
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(e);
            if(!map.containsKey(e)){
                map.put(e,new ArrayList<>());
            }
            map.get(e).add(s);
        }

        int s=bfs1(map);
        return bfs2(s,map);
    }

    private int bfs1(Map<Integer,List<Integer>> map){
        Queue<Integer> queue=new LinkedList<>();
        queue.add(0);
        Set<Integer> visited=new HashSet<>();
        visited.add(0);
        int last=0;
        while(!queue.isEmpty()){
            last=queue.poll();
            if(map.containsKey(last)){
                List<Integer> next=map.get(last);
                for(int item:next){
                    if(visited.contains(item)){
                        continue;
                    }
                    visited.add(item);
                    queue.add(item);
                }
            }
        }
        return last;
    }

    private int bfs2(int start,Map<Integer,List<Integer>> map){
        Queue<Integer> queue =new LinkedList<>();
        queue.add(start);
        Set<Integer> visited=new HashSet<>();
        visited.add(start);
        int level=0;
        while(!queue.isEmpty()){
            int s=queue.size();
            for(int i=0;i<s;i++){
                int temp=queue.poll();
//                System.out.println(temp);
                if(map.containsKey(temp)){
                    List<Integer> next=map.get(temp);
                    for(int item:next){
                        if(visited.contains(item)){
                            continue;
                        }
                        visited.add(item);
                        queue.add(item);
                    }
                }
            }
            level++;
        }
        return level-1;
    }

    public static void main(String[] args){
        int[][] array=new int[][]{{0,1},{0,2}};
        Solution1245 solution1245=new Solution1245();
        int ans=solution1245.treeDiameter(array);
        System.out.println(ans);
    }
}
