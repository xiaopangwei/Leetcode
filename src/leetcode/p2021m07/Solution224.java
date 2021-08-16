package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/28
 * @time 11:19 AM
 */
public class Solution224 {
    public int calculate(String s) {

        int ans=-1;
        int currentNum=0;

        Stack<Integer> numStack=new Stack<>();
        Stack<Character> oprStack=new Stack<>();
        int i=0;
        char[] array=s.toCharArray();
        List<Character> list=new ArrayList<>();
        int k=0;
        for (char item:array){
            if (item!=' '){
                list.add(item);
            }
        }
        char[] newArray=new char[list.size()];
        for (char item:list){
            newArray[k++]=item;
        }
        s=new String(newArray);
        while (i<s.length()){
            char ch=s.charAt(i);
            if (ch==' '){
                i++;
                continue;
            }
            else if (ch>='0' && ch<='9'){
                currentNum=currentNum*10+(ch-'0');
            }
            else if (ch=='('||ch==')'){

                if (ch=='('){
                    oprStack.push(ch);
                }else{
                    if (i>0 && (s.charAt(i-1)>='0' && s.charAt(i-1)<='9')){
                        numStack.push(currentNum);
                        currentNum=0;
                    }

                    while (!oprStack.isEmpty() && oprStack.peek()!='('){
                            char topOpr=oprStack.pop();
                            int a=0,b=0;
                            if (!numStack.isEmpty()) {
                                a = numStack.pop();
                            }
                            if (!numStack.isEmpty()) {
                                b=numStack.pop();
                            }
//                            System.out.println("1:"+a+" "+topOpr+" "+b);
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
                        }//end while
                    //delete (
                    oprStack.pop();
                }
            }
            //+ - * /
            else {

                if (i>0 && s.charAt(i-1)!=')'){
                    numStack.push(currentNum);
                    currentNum = 0;
                }

                while (!oprStack.isEmpty() && getPriority(oprStack.peek())>=getPriority(ch)){

                    char topOpr=oprStack.pop();
                    int a=0,b=0;
                    if (!numStack.isEmpty()) {
                         a = numStack.pop();
                    }
                    if (!numStack.isEmpty()) {
                        b=numStack.pop();
                    }
//                    System.out.println("2:"+a+" "+topOpr+" "+b);
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
            }//end else

            i++;
        }

        int endIndex=s.length()-1;
        while (s.charAt(endIndex)==' '){
            endIndex--;
        }
        if (s.charAt(endIndex)>='0' && s.charAt(endIndex)<='9') {
            numStack.push(currentNum);
        }


        while (!oprStack.isEmpty()){
            char opr=oprStack.pop();
            int a=0,b=0;
            if (!numStack.isEmpty()) {
                a = numStack.pop();
            }
            if (!numStack.isEmpty()) {
                b=numStack.pop();
            }
//            System.out.println("3:"+a+" "+opr+" "+b);

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

        if (ch=='('||ch==')'){
            return -1;
        }

        return 0;
    }

    public static void main(String[] args){
        Solution224 solution227 =new Solution224();
        int ans=-1;
                 ans         =solution227.calculate("   (  3 ) ");
        System.out.println(ans);

                 ans         =solution227.calculate("- (3 + (4 + 5))");
        System.out.println(ans);

                 ans         =solution227.calculate(
                         "-2+ 1");
        System.out.println(ans);
    }

}
