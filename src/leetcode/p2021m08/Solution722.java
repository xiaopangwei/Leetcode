package leetcode.p2021m08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/6
 * @time 9:32 AM
 */
public class Solution722 {

    public static final int STAR    = 1;
    public static final int SLASH   = 2;
    public static final int LF      = 3;
    public static final int DEFAULT = 4;


    static class State {
        public int    id;
        public String name;
        Map<Integer, State> nextState = new HashMap<>();

        public State(int id) {
            this.id = id;
        }

        public void addNextState(int type, State state) {
            nextState.put(type, state);
        }

    }

    private State buildStateMachine() {
        State virtualState            = new State(-1);
        State initialState            = new State(0);
        State slashState              = new State(1);
        State lineCommentState        = new State(2);
        State blockCommentState       = new State(3);
        State cancelBlockCommentState = new State(4);

        initialState.addNextState(DEFAULT, initialState);
        initialState.addNextState(SLASH, slashState);
        initialState.addNextState(LF, initialState);

        slashState.addNextState(SLASH, lineCommentState);
        slashState.addNextState(STAR, blockCommentState);


        lineCommentState.addNextState(DEFAULT, lineCommentState);
        lineCommentState.addNextState(LF, initialState);
        lineCommentState.addNextState(SLASH, lineCommentState);
        lineCommentState.addNextState(STAR, lineCommentState);


        blockCommentState.addNextState(DEFAULT, blockCommentState);
        blockCommentState.addNextState(LF, blockCommentState);
        blockCommentState.addNextState(SLASH, blockCommentState);
        blockCommentState.addNextState(STAR, cancelBlockCommentState);

        cancelBlockCommentState.addNextState(SLASH, initialState);
        cancelBlockCommentState.addNextState(STAR, cancelBlockCommentState);
        cancelBlockCommentState.addNextState(DEFAULT, blockCommentState);
        cancelBlockCommentState.addNextState(LF, blockCommentState);

        virtualState.addNextState(DEFAULT, initialState);
        virtualState.addNextState(SLASH, slashState);

        return virtualState;

    }

    public List<String> removeComments(String[] source) {
        State        previousState = buildStateMachine();
        List<String> ans           = new ArrayList<>();
        State        nextState     = null;
        String       totalStr      = String.join("\n", source);

        List<Character> validList = new ArrayList<>();
        for (int i = 0; i < totalStr.length(); i++) {
            char ch = totalStr.charAt(i);
            nextState = previousState.nextState.get(getType(ch));
            System.out.println(ch + " prev:" + previousState.id + " nextMap:" + nextState.id);
            if (previousState.id == 0 && nextState.id == 0) {
                validList.add(ch);
            } else if (previousState.id == -1 && getType(ch) != SLASH) {
                validList.add(ch);
            } else if (previousState.id == 2 && ch == '\n') {
                validList.add(ch);
            }
            previousState = nextState;
        }

        char[] temp = new char[validList.size()];
        int    k    = 0;
        for (char item : validList) {
            temp[k++] = item;
        }
        String   res = new String(temp);
        String[] arr = res.split("\n");
        for (String item : arr) {
            if (!item.isEmpty()) {
                ans.add(item);
            }
        }
        return ans;
    }


    private int getType(char ch) {
        if (ch == '/') {
            return SLASH;
        } else if (ch == '*') {
            return STAR;
        } else if (ch == '\n') {
            return LF;
        } else {
            return DEFAULT;
        }
    }

    public static void main(String[] args) {
        Solution722 solution722 = new Solution722();
//        String[] source = new String[]{
//                "a/*comment", "line", "more_comment*/b"
//        };


        String[] source2={"void func(int k) {", "// this function does nothing /*", "   k = k*2/4;", "   k = k/2;*/", "}"};
//        String[] source1= {"struct Node{", "    /*/ declare members;/**/", "    int size;", "    /**/int val;", "};"};
//
//        String[] source = new String[]{
//                "/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
//        };

//        String[] source = new String[]{
//                "  // 1 2 ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"
//        };
        List<String> ans = solution722.removeComments(source2);

        for (String item : ans) {
            System.out.println(item);
        }
    }
}
