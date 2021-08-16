package leetcode.p2021m07.p20210703;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/3
 * @time 10:06 PM
 */
public class Solution10 {

    private static final int customLetter =1;
    private static final int dot          =2;
    private static final int question     =3;
    private static final int other     =4;
    static class State{
        private static int count=0;
        public boolean isEnd=false;
        public int stateID;
        public Map<Character,State> nextState=new HashMap<>();
        public static final Map<Integer,State> stateMap=new HashMap<>();
        public State(int index){
            this.stateID=index;
            stateMap.put(index,this);
        }



        public void addNextState(char type,State nextState){
            this.nextState.put(type,nextState);
        }

        public static State getStateByIndex(int index){
            return stateMap.get(index);
        }

    }

    private int getEventType(char ch){
        if (ch>='a' && ch<='z'){
            return customLetter;
        }
        else if(ch=='?'){
            return question;
        }else if (ch=='.'){
            return dot;
        }else{
            return other;
        }
    }

    private State buildStateMachine(String pattern){
        State initialState=new State(-1);
        State prevState=initialState;
        char[] charArray=pattern.toCharArray();
        for (int i=0;i<charArray.length;i++){
            char ch=charArray[i];
            int type=getEventType(ch);
            if (type==customLetter){
                State tempState=new State(i);
                prevState.addNextState(ch,tempState);


                if (i>0 && getEventType(charArray[i-1])==question)
                {
                    State.getStateByIndex(i-1).addNextState(ch,tempState);
                }

                if (i>0 && getEventType(charArray[i-3])==question)
                {
                    State.getStateByIndex(i-1).addNextState(ch,tempState);
                }

                prevState=tempState;
            }else if (type==dot){
                State tempState=new State(i);

               prevState.addNextState((char)-1, tempState);

                prevState=tempState;
            }else if (type==question){
                if (i>0)
                {
                    if (getEventType(charArray[i-1])==customLetter){
                       prevState.addNextState(charArray[i-1], prevState);
                    }else if (getEventType(charArray[i-1])==dot){
                      prevState.addNextState((char)-1, prevState);
                    }
                }
            }
        }

        return null;
    }


    public boolean isMatch(String s, String p) {

        return false;
    }
}
