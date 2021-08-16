package leetcode.p2021m07.p20210701;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/1
 * @time 4:54 PM
 */
public class Solution8 {

    private static final long minVal=-(1 << 31);
    private static final long maxVal=(1 << 31)-1;
    static class State{
        static final int BLANK=1;
        static final int DIGIT=2;
        static final int SIGNED=3;
        static final int ZERO=4;
        static final int OTHER=5;

        public int stateID;
        public String descrption;

        public boolean isEnd=false;
        public Map<Integer,State> transfer=new HashMap<>();

        public State(int stateID,String descrption){
            this.stateID=stateID;
            this.descrption=descrption;
        }


        private void addNextStateTransition(int type,State nextState){
            transfer.put(type,nextState);
        }

    }
    public int myAtoi(String s) {
        char[] charArray=s.toCharArray();
        State state0=new State(0,"Initial");
        State state1=new State(1,"Signed");
        State state2=new State(2,"Digital");
        State state3=new State(3,"Zero");

        state0.addNextStateTransition(State.BLANK,state0);
        state0.addNextStateTransition(State.DIGIT,state2);
        state0.addNextStateTransition(State.SIGNED,state1);
        state0.addNextStateTransition(State.ZERO,state3);


        state1.addNextStateTransition(State.DIGIT,state2);
        state1.addNextStateTransition(State.ZERO,state3);


        state2.addNextStateTransition(State.DIGIT,state2);
        state2.addNextStateTransition(State.ZERO,state2);

        state3.addNextStateTransition(State.DIGIT,state2);
        state3.addNextStateTransition(State.ZERO,state3);


        State currentState=state0;
        long ans=0;
        boolean isPositive=true;

        int validNumericDigitNumber=0;
        for (int i=0;i<charArray.length;i++){
            char ch=charArray[i];
            int type=getEventType(ch);
            if (!currentState.transfer.containsKey(type)){
                break;
            }else{
                State nextState=currentState.transfer.get(type);
                if (nextState.stateID==1){
                    if (ch=='-')
                    {
                        isPositive=false;
                    }
                }
                else if (nextState.stateID==2){
                    ans=ans*10+(ch-'0');
                    validNumericDigitNumber++;
                }
                currentState=nextState;
            }
        }

        if (validNumericDigitNumber>11){
            if (!isPositive){
                return (int)minVal;
            }else{
                return (int)maxVal;
            }
        }
        long temp=0;
        if (!isPositive){
            if (ans<0){
                return (int)minVal;
            }else {
                temp = -ans;
            }
        }else{
            if (ans<0){
                return (int)maxVal;
            }else {
                temp = ans;
            }
        }
        if (temp<minVal){
            return (int)minVal;
        }
        if (temp>maxVal){
            return (int)maxVal;
        }
        return (int)temp;
    }

    public int getEventType(char ch){
        if (ch=='0'){
            return State.ZERO;
        }
        else if (ch==' '){
            return State.BLANK;
        }
        else if (ch=='+' || ch=='-'){
            return State.SIGNED;
        }
        else if (ch>='1' && ch<='9'){
            return State.DIGIT;
        }else{return State.OTHER;}
    }

    public static void main(String[] args){
        Solution8 solution8=new Solution8();
        System.out.println(minVal);
        System.out.println(solution8.myAtoi("-18446744073709551617"));
//        System.out.println(solution8.myAtoi("00000-42a1234"));
//        System.out.println(solution8.myAtoi("4193 with words"));
//        System.out.println(solution8.myAtoi("words and 987"));
//        System.out.println(solution8.myAtoi("-91283472332"));
    }
}
