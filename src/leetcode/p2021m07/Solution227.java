package leetcode.p2021m07;

import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 11:19 AM
 */
public class Solution227 {
    public int calculate(String s) {

        int ans=-1;

        int currentNum=0;
        Stack<Integer> numStack=new Stack<>();
        Stack<Character> oprStack=new Stack<>();
        int i=0;
        while (i<s.length()){
            char ch=s.charAt(i);
            if (ch==' '){
                i++;
                continue;
            }
            if (ch>='0' && ch<='9'){
                currentNum=currentNum*10+(ch-'0');
            }else {
                numStack.push(currentNum);
                currentNum=0;

                //2+10*5*2+3;
                while (!oprStack.isEmpty() && getPriority(oprStack.peek())>=getPriority(ch)){

                    char topOpr=oprStack.pop();
                    int a=numStack.pop();
                    int b=numStack.pop();

                    switch (topOpr){
                        case '+':
                            numStack.push(b+a);
                            break;
                        case '-':
                            numStack.push(b-a);
                            break;
                        case '*':
                            numStack.push(a*b);
                            break;
                        case '/':
                            numStack.push(b/a);
                            break;
                        default:
                    }
                }

                oprStack.push(ch);
            }

            i++;
        }

        numStack.push(currentNum);


        while (!oprStack.isEmpty() && !oprStack.isEmpty()){



            char opr=oprStack.pop();
            int a=numStack.pop();
            int b=numStack.pop();

            switch (opr){
                case '+':
                    numStack.push(b+a);
                    break;
                case '-':
                    numStack.push(b-a);
                    break;

                case '*':
                    numStack.push(a*b);
                    break;

                case '/':
                    numStack.push(b/a);
                    break;

                default:
            }

        }

        ans=numStack.pop();
        return ans;


    }

    private int getPriority(char ch){

        if (ch=='*' || ch=='/'){
          return 1;
        }

        return 0;
    }

    public static void main(String[] args){
        Solution227 solution227=new Solution227();
        int ans=solution227.calculate("12+123");
        System.out.println(ans);
    }

}
