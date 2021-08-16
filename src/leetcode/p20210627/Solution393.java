package leetcode.p20210627;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/27
 * @time 3:24 PM
 */
public class Solution393 {
    static class State{
        public static int count=0;
        public int id;

        public String description;

        public boolean isEnd=false;
        //0*******
        public static final int type1=1;
        //10xxxxxx
        public static final int type3=3;


        //110xxxxx 192-223
        public static final int type4=4;
        //1110xxxx 224-239
        public static final int type5=5;
        //11110xxx 240-247
        public static final int type6=6;

        public Map<Integer,State> stateMap=new HashMap<>();
        public State(String desc){
            this.description=desc;
            this.id=count++;
            isEnd=false;
        }

        public void addNextNode(int type,State state){
            this.stateMap.put(type,state);
        }
    }
    public boolean validUtf8(int[] data) {

        return dfs(data,0,buildStateMachine());
    }

    private boolean dfs(int[] data,int index,State initState){
        if (data.length==index ){
            if(initState.isEnd)
            {return true;}
            else{
                return false;
            }
        }
        State currentState=initState;
        int type=getType(data[index]);
        if (!currentState.stateMap.containsKey(type))
        {
            return false;
        }
        State nextState=currentState.stateMap.get(type);
//        System.out.println(currentState.description+" "+nextState.description);
        return dfs(data, index+1, nextState);
    }

    private State buildStateMachine(){

        State initState=new State("Initial");
        initState.isEnd=true;
        initState.addNextNode(State.type1,initState);

        State twoState=new State("two");
        initState.addNextNode(State.type4,twoState);
        twoState.addNextNode(State.type3,initState);


        State threeState=new State("three");
        initState.addNextNode(State.type5,threeState);
        State three1State=new State("three");
        threeState.addNextNode(State.type3,three1State);
        three1State.addNextNode(State.type3,initState);

        State fourState=new State("four");
        initState.addNextNode(State.type6,fourState);
        State four1State=new State("four");
        fourState.addNextNode(State.type3,four1State);
        State four2State=new State("four");
        four1State.addNextNode(State.type3,four2State);
        four2State.addNextNode(State.type3,initState);

        return initState;
    }

    private int getType(int data){
        if (data<=127){
            return 1;
        }else if(data<=191){
            return 3;
        }else if (data<=223){
            return 4;
        }
        else if (data<=239){
            return 5;
        }
        else if (data<=247){
            return 6;
        }
        return 0;

    }

    public static void main(String[] args){
//       System.out.println(8 >> 2);
        Solution393 solution393=new Solution393();
        System.out.println(solution393.validUtf8(new int[]{230,136,145}));

    }
}
