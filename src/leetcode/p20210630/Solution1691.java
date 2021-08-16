package leetcode.p20210630;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/30
 * @time 2:37 PM
 */
public class Solution1691 {

    private int maxHgt=Integer.MIN_VALUE;
    static class Pair{
        public int x;
        public int y;
        public int z;


        public Pair(int x,int y,int z){
            this.x=x;
            this.y=y;
            this.z=z;

        }

        @Override
        public int hashCode() {
            return x*13+y*17+z*19;
        }


        @Override
        public boolean equals(Object obj) {
            Pair pair=(Pair)obj;
            if (pair.x==this.x && pair.y==this.y  && pair.z==this.z  ){
                return true;
            }
            return false;
        }
    }
    public int maxHeight(int[][] cuboids) {

        int len=cuboids.length;
        Map<Integer,Set<Pair>> map =new HashMap<>();

        for (int i=0;i<cuboids.length;i++){
            int[] array=cuboids[i];
            Set<Pair> set=new HashSet<>();
            set.add(new Pair(array[0],array[1],array[2]));
            set.add(new Pair(array[0],array[2],array[1]));
            set.add(new Pair(array[1],array[0],array[2]));
            set.add(new Pair(array[1],array[2],array[0]));
            set.add(new Pair(array[2],array[0],array[1]));
            set.add(new Pair(array[2],array[1],array[0]));
            map.put(i,set);
        }


        dfs(map,0,new ArrayList<>());

        return maxHgt;

    }


    private void dfs(Map<Integer,Set<Pair>> map,int index,List<Pair> list){
        if (index==map.size()){
            int sum=0;
            for (Pair pair:list){
                sum+=pair.z;
            }
            System.out.println(list);
            maxHgt=Math.max(maxHgt,sum);
            return;
        }
        Set<Pair> pairs=map.get(index);
//        for (Pair pair:pairs){
//            if (!list.isEmpty()){
//                final
//                if (last.x>=pair.x && last.y>=pair.y && last.z>=pair.z) {
//                    list.add(pair);
//                    getDepth(map, index+1, list);
//                    list.remove(list.size() - 1);
//                }else{
//                    maxHgt=Math.max(maxHgt,pair.z);
//                }
//            }else{
//                list.add(pair);
//                getDepth(map, index+1, list);
//                list.remove(list.size() - 1);
//            }
//        }
    }

    private boolean isInsertOk(List<Pair> pairList,Pair pair){
        for (int i=0;i<pairList.size();i++){
            int curr=i;
            int next=i+1;
            if (curr==pairList.size()-1){
                if (pairList.get(curr).y<=pair.y && pairList.get(curr).y<=pair.y && pairList.get(curr).z<=pair.z ){
                    pairList.add(curr+1,pair);
                    return true;
                }
            }else{
                if (pairList.get(curr).x>=pair.x &&
                        pairList.get(curr).y>=pair.y &&
                        pairList.get(curr).z>=pair.z &&
                        pairList.get(next).x<=pair.x &&
                        pairList.get(next).y<=pair.y &&
                        pairList.get(next).z<=pair.z ){
                    pairList.add(next,pair);
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args){
        Solution1691 solution1691=new Solution1691();
        int[][] test1=new int[][]{{7,11,17},{7,17,11},{11,7,17},{11,17,7},{17,7,11},{17,11,7}};
        int[][] test2=new int[][]{{38,25,45},{76,35,3}};
        int[][] test3=new int[][]{{50,45,20},{95,37,53},{45,23,12}};
        int maxHgt=solution1691.maxHeight(test3);
        System.out.println(maxHgt);
    }
}
