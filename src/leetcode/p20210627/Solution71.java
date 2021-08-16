package leetcode.p20210627;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/27
 * @time 5:02 PM
 */
public class Solution71 {
    public String simplifyPath(String path) {

        String[] pathArray=path.split("/");
        Stack<String> stack=new Stack<>();
        for (int i=0;i<pathArray.length;i++){
            String element=pathArray[i];
            if ("".equals(element.trim())){
                continue;
            }

            else if (".".equals(element)){
                continue;
            }

            else if ("..".equals(element)){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(element);
            }
        }

        LinkedList<String> resList=new LinkedList<>();

        while (!stack.isEmpty()){
            resList.addFirst(stack.pop());
        }

        if (resList.isEmpty()){
            return "/";
        }
        return "/"+String.join("/",resList);
    }

    public static void main(String[] args){
        Solution71 solution71=new Solution71();
//        System.out.println(solution71.simplifyPath("/a/./b/../../c/"));
//        "/a//b////c/d//././/.."
        System.out.println(solution71.simplifyPath("/.../"));
    }
}
