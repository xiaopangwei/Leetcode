package leetcode.p20210626;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/26
 * @time 3:29 PM
 */
public class Solution773 {
    static class State{
       public int[][] matrix;
       public State(int[][] array){
           matrix=copy(array);
       }

       public int[][] copy(int[][] array){
           int[][] copy=new int[2][3];
           for (int i=0;i<2;i++){
               for (int j=0;j<3;j++){
                   copy[i][j]=array[i][j];
               }
           }
           return copy;
       }
        @Override
        public int hashCode() {
           int code=0;
            for (int i=0;i<2;i++){
                for (int j=0;j<3;j++){
                   code+=(matrix[i][j]*13);
                }
            }
            return code;
        }

        @Override
        public boolean equals(Object obj) {
            State state=(State)obj;
            for (int i=0;i<2;i++){
                for (int j=0;j<3;j++){
                    if (this.matrix[i][j]!=state.matrix[i][j])
                    {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    private boolean isValid(int x,int y){
        if (x<0 || y<0 || x>=2 || y>=3) {
            return false;
        }
        return true;
    }

    private int[] locate(State state){
        for (int i=0;i<2;i++){
            for (int j=0;j<3;j++){
                if (state.matrix[i][j]==0){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{0,0};
    }

    public State swap(State state,int[] coordinate){
        int[] zero=locate(state);
        int[][] newMatrix=state.copy(state.matrix);
        int temp=newMatrix[zero[0]][zero[1]];
        newMatrix[zero[0]][zero[1]]=newMatrix[coordinate[0]][coordinate[1]];
        newMatrix[coordinate[0]][coordinate[1]]=temp;
        return new State(newMatrix);
    }

    public int slidingPuzzle(int[][] board) {
        int[][] directions=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        Queue<State>       queue1 =new LinkedList<>();
        Queue<State>       queue2 =new LinkedList<>();
        int[][] terminateState=new int[][]{{1,2,3},{4,5,0}};
        Map<State,Integer> map1   =new HashMap<>();
        Map<State,Integer> map2   =new HashMap<>();
        State source=new State(board);
        State target=new State(terminateState);
        queue1.add(source);
        queue2.add(target);

        if (source.equals(target)){
            return 0;
        }
        map1.put(new State(board),0);
        map2.put(new State(terminateState),0);

        while (!queue1.isEmpty() && !queue2.isEmpty()){
            if (queue1.size()<=queue2.size()){
                State temp=queue1.poll();
                int[] point=locate(temp);
                for (int i=0;i<4;i++){
                    int newX=point[0]+directions[i][0];
                    int newY=point[1]+directions[i][1];
                    if (isValid(newX,newY)){
                        State newState=swap(temp,new int[]{newX,newY});
                        if (map2.containsKey(newState)){
                            return map1.get(temp)+map2.get(newState)+1;
                        }
                        if (!map1.containsKey(newState)){
                            queue1.add(newState);
                            map1.put(newState,map1.get(temp)+1);
                        }
                    }
                }
            }else{
                State temp=queue2.poll();
                int[] point=locate(temp);
                for (int i=0;i<4;i++){
                    int newX=point[0]+directions[i][0];
                    int newY=point[1]+directions[i][1];
                    if (isValid(newX,newY)){
                        State newState=swap(temp,new int[]{newX,newY});
                        if (map1.containsKey(newState)){
                            return map2.get(temp)+map1.get(newState)+1;
                        }
                        if (!map2.containsKey(newState)){
                            queue2.add(newState);
                            map2.put(newState,map2.get(temp)+1);
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[][] array=new int[][]{{3,0,1},{2,4,5}};
        Solution773 solution773=new Solution773();
        System.out.println(solution773.slidingPuzzle(array));
    }

}
