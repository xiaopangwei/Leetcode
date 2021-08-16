package leetcode.p20210209;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class Solution22 {


    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        Queue<String> queue=new LinkedList<>();
        queue.add("(");
        queue.add(")");
        while (!queue.isEmpty()){
            String c=queue.poll();
            if (n*2==c.length() && isValid(c))
            {
                ans.add(c);
            }
            else{
                String c1 = c + "(";
                String c2 = c + ")";
                if (c1.length()<=n*2){
                    queue.add(c1);
                }
                if (c2.length()<=n*2) {
                    queue.add(c2);
                }
            }
        }
        return  ans;
    }


    public boolean isValid(String srcStr){
        LinkedList<Character> list=new LinkedList<>();
        for (char c:srcStr.toCharArray()){

            if (c=='('){
                list.push(c);
            }
            else if(c==')'){

                if (list.isEmpty()){
                    return false;
                }

                else{
                    char top=list.peek();
                    if (top==')'){
                        list.push('(');
                    }
                    else if (top=='('){
                        list.pop();
                    }
                }
            }
        }

        if (list.isEmpty()){
            return true;
        }
        return false;
    }
    public static void main(String[] args){
        Solution22 solution22=new Solution22();
        System.out.println(solution22.isValid("()()"));
        System.out.println( solution22.isValid("(())"));
        System.out.println(solution22.isValid("())("));

        System.out.println(solution22.generateParenthesis(1));
        System.out.println(solution22.generateParenthesis(2));
        System.out.println(solution22.generateParenthesis(3));
    }
}
