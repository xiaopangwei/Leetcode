package leetcode.p2021m06.p20210627;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 8:33 AM
 */
public class Solution815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {


        if (source==target){return 0;}
        int routeNum=routes.length;
        Map<Integer,List<Integer>> routeIdAndDestIdMap=new HashMap<>();
        for (int i=0;i<routes.length;i++){
            List<Integer> list=new ArrayList<>();
            boolean findSource=false;
            boolean findTarget=false;
            for (int j=0;j<routes[i].length;j++){
                if (routes[i][j]==source){
                    findSource=true;
                }
                else if (routes[i][j]==target){
                    findTarget=true;
                }
                if (findSource && findTarget){
                    return 1;
                }
                list.add(routes[i][j]);
            }
            routeIdAndDestIdMap.put(i,list);
        }



        Map<Integer,List<Integer>> destIdAndBusIdMap=new HashMap<>();
        for (int i=0;i<routes.length;i++){
            for (int j=0;j<routes[i].length;j++){
                int key=routes[i][j];
                if (!destIdAndBusIdMap.containsKey(key)){
                    List<Integer> list=new ArrayList<>();
                    destIdAndBusIdMap.put(key,list);
                }
                destIdAndBusIdMap.get(key).add(i);
            }

        }

        boolean[][] reachable=new boolean[routeNum][routeNum];
        for (int i=0;i<routeNum;i++){
            reachable[i][i]=true;
        }

        for(int i=0;i<routeNum;i++){
            for (int j=i+1;j<routeNum;j++){
                boolean temp=isConnect(routeIdAndDestIdMap.get(i),routeIdAndDestIdMap.get(j));
                reachable[i][j]=temp;
                reachable[j][i]=temp;
            }
        }


        List<Integer> sourceRouteIdList=destIdAndBusIdMap.get(source);
        List<Integer> targetRouteIdList=destIdAndBusIdMap.get(target);
        if (sourceRouteIdList.isEmpty()){
            return -1;
        }
        if (targetRouteIdList.isEmpty()){
            return -1;
        }
        Queue<Integer> queue1=new LinkedList<>();
        Queue<Integer> queue2=new LinkedList<>();
        Map<Integer,Integer> visited1=new HashMap<>();
        Map<Integer,Integer> visited2=new HashMap<>();
        for (int routeId:sourceRouteIdList){
            queue1.add(routeId);
            visited1.put(routeId,0);
        }

        for (int routeId:targetRouteIdList){
            queue2.add(routeId);
            visited2.put(routeId,0);
        }

        while (!queue1.isEmpty() && !queue2.isEmpty() ){
            if (queue1.size()<=queue2.size()) {
                int           routeId    = queue1.poll();
                if (visited2.containsKey(routeId) && routeIdAndDestIdMap.get(routeId).contains(target)) {
                    return visited1.get(routeId)+visited2.get(routeId)+1;
                }
                boolean[] temp = reachable[routeId];
                for (int i = 0; i < routeNum; i++) {
                    if (temp[i] && !visited1.containsKey(i)) {
                        visited1.put(i, visited1.get(routeId)+1);
                        queue1.add(i);
                    }
                }
            }else{
                int           routeId    = queue2.poll();
                if (visited1.containsKey(routeId) && routeIdAndDestIdMap.get(routeId).contains(target)) {
                    return visited1.get(routeId)+visited2.get(routeId)+1;
                }
                boolean[] temp = reachable[routeId];
                for (int i = 0; i < routeNum; i++) {
                    if (temp[i] && !visited2.containsKey(i)) {
                        visited2.put(i, visited2.get(routeId) + 1);
                        queue2.add(i);
                    }
                }
            }

        }

        return -1;
    }

    private boolean isConnect(List<Integer> l1,List<Integer> l2){
        if (l1.isEmpty() || l2.isEmpty()) {return false;}
        for (int item:l1){
            if (l2.contains(item)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        Solution815 solution815=new Solution815();
//        System.out.println(solution815.numBusesToDestination(new int[][]{{1,7},{3,5}},5,5));

        int[][] matrix=new int[300][300];
        int count=0;
        for (int i=0;i<300;i++){
            for (int j=0;j<300;j++){
                matrix[i][j]=count++;
            }
        }
        System.out.println(solution815.numBusesToDestination(matrix,0,90000));
    }
//        System.out.println(solution815.numBusesToDestination(new int[][]{{2},{2,8}},2,8));
//        System.out.println(solution815.numBusesToDestination(new int[][]{{1,2,7},{3,6,7}},1,6));
//        System.out.println(solution815.numBusesToDestination(new int[][]{{7,12},{4,5,15},{6},{15,19},{9,12,13}},15,12));
//    }





}
