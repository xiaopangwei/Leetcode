package leetcode.shopee;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 10:16 AM
 */
public class SolutionRomeNumer {

    public int romanToInt(String s) {
        char[] charArray=s.toCharArray();
        int temp=0;

        LinkedList<Character> stack=new LinkedList<>();
        for (int i=0;i<charArray.length;i++){
            char ch=charArray[i];
            if (stack.isEmpty()){
                stack.push(ch);
            }
            else{
                if (convertCharToInt(ch)<=convertCharToInt(stack.peek())){
                    stack.push(ch);
                }
                else{
                    while (!stack.isEmpty() && convertCharToInt(stack.peek())<convertCharToInt(ch)){
                        temp+=(-convertCharToInt(stack.poll()));
                    }

                    stack.push(ch);
                }
            }
        }

        while (!stack.isEmpty()){
            temp+=convertCharToInt(stack.poll());
        }
        return temp;
    }


    private int convertCharToInt(char ch){
      switch (ch){
          case 'I':
              return 1;
          case 'V':
              return 5;
          case 'X':
              return 10;

          case 'L':
              return 50;

          case 'C':
              return 100;

          case 'D':
              return 500;

          case 'M':
              return 1000;

          default:
              return -1;
      }
    }


    public static void main(String[] args){
        SolutionRomeNumer solutionRomeNumer=new SolutionRomeNumer();
        System.out.println(solutionRomeNumer.romanToInt("MCMXCIV"));
    }

}
