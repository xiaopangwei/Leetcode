package leetcode.p2022m03;

import common.State;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/3/4
 * @time 2:16 PM
 */
public class Solution393 {
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx


    public int type(int d) {

        if (d >> 7 == 0b0) return 0;
        else if (d >> 6 == 0b10) return 1;
        else if (d >> 5 == 0b110) return 2;
        else if (d >> 4 == 0b1110) return 3;
        else if (d >> 3 == 0b11110) return 4;
        return 5;

    }


    public boolean validUtf8(int[] data) {
        State startState = new State("Initial");
        State state2     = new State("缺一个");
        State state3     = new State("缺两个");
        State state4     = new State("缺三个");

        startState.add(0, startState);
        startState.add(2, state2);
        startState.add(3, state3);
        startState.add(4, state4);


        state2.add(1, startState);
        state3.add(1, state2);
        state4.add(1, state3);

        State currentState = startState;
        for (int i = 0; i < data.length; i++) {
            State nextState = currentState.getNext(type(data[i]));
            if (nextState == null) {
                return false;
            }
            currentState = nextState;
        }

        return currentState == startState;
    }

    public static void main(String[] args) {
        Solution393 solution393 = new Solution393();
        int a=513;
        System.out.println(a >> 4);
        System.out.println(0b110);
        int ans=solution393.type(a >> 4);
//        boolean     ans         = solution393.validUtf8(new int[]{235, 140, 4});
        System.out.println(ans);
    }
}
