package leetcode.p2021m07;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/27
 * @time 4:16 PM
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] inDigree=new int[numCourses];
        Map<Integer,List<Integer>> outDegreeMap=new HashMap<>();
        for(int i=0;i<prerequisites.length;i++){
                inDigree[prerequisites[i][0]]++;
                if (!outDegreeMap.containsKey(prerequisites[i][1])){
                    outDegreeMap.put(prerequisites[i][1],new ArrayList<>());
                }
                outDegreeMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] ans=new int[numCourses];
        int index=0;

        boolean flag=false;
        for (int item:inDigree){
            if (item==0){
                flag=true;
                break;
            }
        }

        if (!flag){
            return new int[]{};
        }
        boolean[] visited=new boolean[numCourses];
        for (int i=0;i<numCourses;i++)
        {
            boolean loopFlag=false;
            for (int k=0;k<inDigree.length;k++) {
                if (inDigree[k] == 0) {
                    if (!visited[k]) {
                        visited[k] = true;
                        ans[index] = k;
                        loopFlag=true;
                        index++;
                        if (outDegreeMap.containsKey(k)) {
                            List<Integer> nextList = outDegreeMap.get(k);
                            for (int item : nextList) {
                                inDigree[item] -= 1;
                            }
                        }
                        break;
                    }
                }
            }
            if (!loopFlag){
                return new int[]{};
            }
       }


        return ans;
    }


    public static void main(String[] args){
        Solution210 solution210=new Solution210();
        int[] ans=solution210.findOrder(3,new int[][]{{1,0},{1,2},{0,1}});
        System.out.println(Arrays.toString(ans));
    }
}
