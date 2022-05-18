package leetcode.p2022m05.day0512;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/12
 * @time 10:20 PM
 */
public class Solution365 {

    class State {
        public int[] array;

        public State(int a, int b) {
            array = new int[2];
            array[0] = a;
            array[1] = b;
        }

        @Override
        public int hashCode() {
            return array[0] * 13 + array[1] * 17;
        }

        @Override
        public boolean equals(Object obj) {
            State t = (State) obj;
            return array[0] == t.array[0] && array[1] == t.array[1];
        }
    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {

        Queue<State> queue     = new LinkedList<>();
        Set<State>   visited   = new HashSet<>();
        State        initialS1 = new State(jug1Capacity, 0);
        State        initialS2 = new State(0, jug2Capacity);
        State        initialS3 = new State(jug1Capacity, jug2Capacity);
        queue.add(initialS1);
        queue.add(initialS2);
        queue.add(initialS3);
        visited.add(initialS1);
        visited.add(initialS2);
        visited.add(initialS3);
        while (!queue.isEmpty()) {
            State temp = queue.poll();

            System.out.println(temp.array[0] + " " + temp.array[1]);
            if (temp.array[0] == targetCapacity || temp.array[1] == targetCapacity || temp.array[0]+temp.array[1]==targetCapacity) {
                return true;
            }
            //clear 1
            State s1 = new State(0, temp.array[1]);
            //clear 2
            State s2 = new State(temp.array[1], 0);
            //full 1
            State s3 = new State(jug1Capacity, temp.array[1]);
            //full 2
            State s4 = new State(temp.array[0], jug2Capacity);

            //add+sub
            //1->2
            int   gap1 = Math.min(temp.array[0], jug2Capacity - temp.array[1]);
            State s5   = new State(temp.array[0] - gap1, temp.array[1] + gap1);



            //2-->1
            int   gap2 = Math.min(temp.array[1], jug1Capacity - temp.array[0]);
            State s6   = new State(temp.array[0] + gap2, temp.array[1] - gap2);


            Set<State> sets = new HashSet<>();
            sets.add(s1);
            sets.add(s2);
            sets.add(s3);
            sets.add(s4);
            sets.add(s5);
            sets.add(s6);

            for (State s : sets) {
                if (visited.contains(s) || queue.contains(s)) {
                    continue;
                }

                if (s.array[0]<0||s.array[1]<0||s.array[0]>jug1Capacity||s.array[1]>jug2Capacity){
                    continue;
                }
                queue.add(s);
                visited.add(s);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution365 solution365 = new Solution365();
        boolean     ans         = solution365.canMeasureWater(1, 2, 3);
        System.out.println(ans);
    }
}
