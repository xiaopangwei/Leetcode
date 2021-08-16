package leetcode.shopee;



import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 10:49 AM
 */
public class SolutionComputeString {

    public String computeString (String str) {


        Stack<Integer> timeStack=new Stack<>();
        LinkedList<String>  operateStack=new LinkedList<>();

        char[] charArray=str.toCharArray();

        List<Character> times=new ArrayList<>();

        for (char ch:charArray){
            if (ch>='0' && ch<='9'){
                times.add(ch);

            }
            else{
                if (!times.isEmpty()){

                    char[] temp=new char[times.size()];
                    for (int i=0;i<times.size();i++){
                        temp[i]=times.get(i);
                    }
                    int time=Integer.parseInt(new String(temp));
                    timeStack.push(time);
                    times.clear();
                }

                if (ch!=']'){
                    operateStack.push(String.valueOf(ch));
                }
                else{

                    LinkedList<String> repeatUnit=new LinkedList<>();
                    while (!operateStack.peek().equalsIgnoreCase("[")){
                        repeatUnit.addFirst(operateStack.peek());
                        operateStack.pop();
                    }

                    operateStack.pop();
                    operateStack.pop();
                    int repeatTimes=timeStack.pop();
                    StringBuilder stringBuilder=new StringBuilder();

                    for (int i=0;i<repeatUnit.size();i++){
                        stringBuilder.append(repeatUnit.get(i));
                    }

                    String unitStr=stringBuilder.toString();
                    StringBuilder total=new StringBuilder(unitStr);
                    for (int i=0;i<repeatTimes-1;i++){
                        total.append(unitStr);
                    }

                    operateStack.push(total.toString());

                }
            }
        }

        return  operateStack.pop();
    }

    public static void main(String[] args){

        SolutionComputeString solutionComputeString=new SolutionComputeString();
        System.out.println(solutionComputeString.computeString("10*[a]"));
    }
}
