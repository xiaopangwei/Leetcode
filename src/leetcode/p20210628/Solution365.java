package leetcode.p20210628;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technoloy</p>
 *
 * @author weihuang
 * @date 2021/6/28
 * @time 5:09 PM
 */

public class Solution365 {
    static class State{
        private List<State> prev=new ArrayList<>();
        public  int         c1;
        public  int         c2;
        public State(int v1,int v2){
            this.c1=v1;
            this.c2=v2;
        }

        @Override
        public int hashCode() {
            return c1*5+c2*13;
        }

        @Override
        public boolean equals(Object obj) {
            State state=(State)obj;
            if (state!=null) {
                return state.c1 == this.c1 && state.c2 == this.c2;
            }
            return false;
        }

        @Override
        public String toString() {
            return c1+" "+c2+" ";
        }

        public void add(State s){
            this.prev.add(s);
        }
    }
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        Map<State,Integer> visited=new HashMap<>();
        Queue<State> queue=new LinkedList<>();
        State initState1=new State(jug1Capacity,jug2Capacity);
        State initState2=new State(jug1Capacity,0);
        State initState3=new State(0,jug2Capacity);
        queue.add(initState1);
        queue.add(initState2);
        queue.add(initState3);

        visited.put(initState1,0);
        visited.put(initState2,0);
        visited.put(initState3,0);

        if (jug1Capacity+jug2Capacity==targetCapacity){
            return true;
        }


        while (!queue.isEmpty()){
            State state=queue.poll();
//            System.out.println(state);
            if (state.c1==targetCapacity || state.c2==targetCapacity || state.c2+state.c1==targetCapacity) {
                return true;
            }
            int step=visited.get(state)+1;

            //小瓶子清空
            if (state.c1!=0) {
                State next=new State(0,state.c2);
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next,step);
                    next.add(state);
                }
            }
            //大瓶子清空
            if (state.c2!=0) {
                State next=new State(state.c1,0);
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next,step);
                    next.add(state);
                }
            }
            //小瓶装满
            if (state.c1!=jug1Capacity) {
                State next=new State(jug1Capacity,state.c2);
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next,step);
                    next.add(state);
                }
            }
            //大瓶装满
            if (state.c2!=jug2Capacity) {
                State next=new State(state.c1,jug2Capacity);
                if (!visited.containsKey(next)) {
                    queue.add(next);
                    visited.put(next,step);
                    next.add(state);
                }
            }
            //从小瓶倒出来让大瓶子装满
            int bigMax=Math.min(state.c2+state.c1,jug2Capacity);
            int gap=bigMax-state.c2;
            State next=new State(state.c1-gap,bigMax);
            if (!visited.containsKey(next)) {
                queue.add(next);
                visited.put(next,step);
                next.add(state);
            }
            //从大瓶倒出来让小瓶子装满
            bigMax=Math.min(state.c2+state.c1,jug1Capacity);
//            System.out.println("从大瓶倒出来让小瓶子装满");
            gap=bigMax-state.c1;
            next=new State(bigMax,state.c2-gap);
            if (!visited.containsKey(next)) {
                queue.add(next);
                visited.put(next,step);
                next.add(state);
            }
        }

        return false;
    }

    public static void main(String[] args){
        Solution365 solution365=new Solution365();
//        System.out.println(solution365.canMeasureWater(3,5,4));
        System.out.println(solution365.canMeasureWater(4,6,8));
    }
}
