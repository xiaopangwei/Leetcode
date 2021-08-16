package leetcode.p20210627;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/27
 * @time 1:23 PM
 */
public class Solution65 {
    static class State{
        public static int count=0;
        public static final int DOT=1;
        public static final int DIGIT=2;
        public static final int SIGN=3;
        public static final int EXP=4;


        public int id;
        public String description;
        public Map<Integer,State> transferMap=new HashMap<>();
        public boolean terminated=false;


        public State(String description){
            this.id=count++;
            this.description=description;
            this.terminated=false;
        }

        public void addNextState(int type,State nextState){
            transferMap.put(type,nextState);
        }
    }
    public boolean isNumber(String s) {

        char[] charArray=s.toCharArray();
        State initialState=buildStateMachine();
        int countOfDot=0;
        int countOfExp=0;
        for (char ch:charArray){
            if (ch=='.'){
                countOfDot++;
                if (countOfDot>=2){
                    return false;
                }
            }else if (ch=='E'||ch=='e') {
                countOfExp++;
                if (countOfExp>=2){
                    return false;
                }
            }else if (ch>='0' && ch<='9'){
                continue;
            }
            else if (ch=='+' || ch=='-'){
                continue;
            }else {
                return false;
            }
        }

        return dfs(initialState,charArray,0);
    }


    private int getType(char ch){
        if (ch=='.'){
            return State.DOT;
        }else if (ch=='+'||ch=='-'){
            return State.SIGN;
        }else if (ch=='E'||ch=='e'){
            return State.EXP;
        }else if (ch>='0'&& ch<='9'){
            return State.DIGIT;
        }else{
            return -1;
        }
    }
    private boolean dfs(State currentState,final char[] sourceArray,int index){
      if (sourceArray.length==index){
          if (currentState.terminated){
              if (currentState.description.equals("Doted")){
                  if (index-2>=0){
                      if (getType(sourceArray[index-2])!=State.DIGIT){
                          return false;
                      }
                  }else{
                      return false;
                  }
              }
              return true;
          }else{
              return false;
          }
      }
      int type=getType(sourceArray[index]);

      if (!currentState.transferMap.containsKey(type)){
          return false;
      }
      State nextState=currentState.transferMap.get(type);
      if (nextState.description.equals("Exp") && currentState.description.equals("Doted")) {
            if (index-2>=0){
                if (getType(sourceArray[index-2])!=State.DIGIT){
                    return false;
                }
            }else{
                return false;
            }
        }
      return dfs(nextState,sourceArray,index+1);
    }

    private State buildStateMachine(){
        State initialState=new State("Initial");

        State signedState1=new State("Signed1");
        State dotState=new State("Doted");
        dotState.terminated=true;
        State digitedState1=new State("Digit1");
        digitedState1.terminated=true;

        State expState=new State("Exp");


        State signedState2=new State("Signed2");
        State digitedState2=new State("Digit2");
        digitedState2.terminated=true;
        initialState.addNextState(State.SIGN,signedState1);
        initialState.addNextState(State.DOT,dotState);
        initialState.addNextState(State.DIGIT,digitedState1);

        signedState1.addNextState(State.DIGIT,digitedState1);
        signedState1.addNextState(State.DOT,dotState);

        dotState.addNextState(State.DIGIT,digitedState1);
        dotState.addNextState(State.EXP,expState);
        digitedState1.addNextState(State.DIGIT,digitedState1);
        digitedState1.addNextState(State.EXP,expState);
        digitedState1.addNextState(State.DOT,dotState);

        expState.addNextState(State.SIGN,signedState2);
        expState.addNextState(State.DIGIT,digitedState2);

        signedState2.addNextState(State.DIGIT,digitedState2);
        digitedState2.addNextState(State.DIGIT,digitedState2);

        return initialState;
    }
    public static void main(String[] args){

        Solution65 solution65=new Solution65();
        System.out.println(solution65.isNumber("46.e3"));
        System.out.println(solution65.isNumber(".e1"));
//        String[] positiveCases=new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
//        String[] negativeCases=new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
//
//        for (String item:positiveCases){
//            System.out.println(item+" "+solution65.isNumber(item));
//        }
////
//
//        System.out.println("---------------------");
//        for (String item:negativeCases){
//            System.out.println(item+" "+solution65.isNumber(item));
//        }
    }
}
