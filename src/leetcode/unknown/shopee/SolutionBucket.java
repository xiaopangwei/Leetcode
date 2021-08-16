package leetcode.unknown.shopee;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/3/14
 * @time 1:53 PM
 */
public class SolutionBucket {

    public boolean checkValidString (String s) {

        char[] charArray=s.toCharArray();


        return dfs(charArray,0,new ArrayList<>());



    }


    public  boolean dfs(char[] charArray, int index, List<Character> result){

        if (index==charArray.length){
            return isValid(new ArrayList<>(result));
        }
        if (charArray[index]=='*'){
            boolean b1=dfs(charArray,index+1,result);
            if (b1){
                return true;
            }


            result.add('(');
            boolean b2=dfs(charArray,index+1,result);
            if (b2){
                return true;
            }
            result.remove(result.size()-1);


            result.add(')');
            boolean b3=dfs(charArray,index+1,result);
            if(b3){
                return true;
            }
            result.remove(result.size()-1);
        }

        else{
            result.add(charArray[index]);
            boolean b4=dfs(charArray,index+1,result);
            if (b4){
                return true;
            }
            result.remove(result.size()-1);
        }

        return  false;

    }

    public boolean isValid(List<Character> list){

        Stack<Character> stack=new Stack<>();
        for (Character ch:list){
            if (ch=='(')
            {
                stack.push(ch);
            }
            else if(ch==')'){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else{
                continue;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){

        SolutionBucket solutionBucket=new SolutionBucket();
        System.out.println(solutionBucket.checkValidString("((*)"));

//        List<Character> chas=new ArrayList<>();
//        chas.add('(');
//        chas.add(')');
//        chas.add('(');
//        chas.add(')');
//        System.out.println(solutionBucket.isValid(chas));
    }
}
