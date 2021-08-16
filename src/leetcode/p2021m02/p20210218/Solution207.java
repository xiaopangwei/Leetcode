package leetcode.p2021m02.p20210218;


import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/18
 * @time 11:17 AM
 */
public class Solution207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            {
                for (int j = 0; j < prerequisites.length; j++)
                    if (prerequisites[j][0] == i) {
                        inDegree[i]++;
                    }
            }
        }
        boolean[] visited = new boolean[numCourses];
        List<Integer> zeroInDegreeIndex = getCandidates(inDegree,visited);
        if (zeroInDegreeIndex.isEmpty()){
            return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(zeroInDegreeIndex);
        System.out.println("a :"+zeroInDegreeIndex);
        while (!queue.isEmpty())
        {

            Integer index = queue.poll();
            visited[index] = true;

            for (int j = 0; j < prerequisites.length; j++) {
                if (prerequisites[j][1] == index) {
                    inDegree[prerequisites[j][0]]--;
                }
            }


            zeroInDegreeIndex=getCandidates(inDegree,visited);

            if (zeroInDegreeIndex.isEmpty()) {
                for (boolean b:visited){
                    if (!b){
                        return false;
                    }
                }
                return true;

            }
            else{
                System.out.println("b :"+zeroInDegreeIndex);
                for (Integer idx:zeroInDegreeIndex){
                    if (queue.contains(idx)||visited[idx])
                    {
                        continue;
                    }
                    else {
                        queue.add(idx);
                    }
                }
            }

        }
//        System.out.println(Arrays.toString(visited));
        return true;
    }


    public List<Integer> getCandidates(int[] inDegree,boolean[] visited){
        List<Integer> idx=new ArrayList<>();
        for (int i=0;i<inDegree.length;i++){
            if (inDegree[i]==0 && !visited[i]){
                idx.add(i);
            }
        }
        return idx;
    }

    public static void main(String[] args){
        Solution207 solution131 =new Solution207();
        boolean ans=solution131.canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}});
        System.out.println(ans);


    }





}
