package leetcode.p2022m03;

import common.State;


/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/14
 * @time 10:45 PM
 */
public class Solution8 {



    private int type(char ch) {
        if (ch >= '0' && ch <= '9') {
            return 0;
        } else if (ch == ' ') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 2;
        }
        return -1;
    }

    public int myAtoi(String s) {

        State initialState  = new State("initialState");
        State signedState   = new State("signedState");
        State digitalState  = new State("digitalState");
        State terminalState = new State("terminalState");

        initialState.add(type(' '), initialState);
        initialState.add(type('+'), signedState);
        initialState.add(type('0'), digitalState);
        initialState.add(type('x'), terminalState);

        signedState.add(type(' '), terminalState);
        signedState.add(type('+'), terminalState);
        signedState.add(type('0'), digitalState);
        signedState.add(type('x'), terminalState);

        digitalState.add(type(' '), terminalState);
        digitalState.add(type('+'), terminalState);
        digitalState.add(type('0'), digitalState);
        digitalState.add(type('x'), terminalState);

        terminalState.add(type(' '), terminalState);
        terminalState.add(type('+'), terminalState);
        terminalState.add(type('0'), terminalState);
        terminalState.add(type('x'), terminalState);

        State   currentState = initialState;
        long    temp         = 0;
        boolean signed       = true;
        for (int i = 0; i < s.length(); i++) {
            char  ch        = s.charAt(i);
            State nextState = currentState.getNext(type(ch));
            if (nextState == terminalState) {
                break;
            }
            if (nextState == signedState) {
                if (ch == '-') {
                    signed = false;
                } else {
                    signed = true;
                }
            }
            if (nextState == digitalState) {
                temp = temp * (long) 10 + (long) (ch - '0');
                if (signed && temp >= (long) Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (!signed && temp < (long) Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            }

            currentState = nextState;
        }


        if (!signed) {
            temp = -temp;
        }

        if (temp < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (temp > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) temp;
    }


    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        System.out.println(Long.MAX_VALUE);
        int ans = solution8.myAtoi("9223372036854775808");
        System.out.println(ans);
    }

}
