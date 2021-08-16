package leetcode.p20210218;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class DFS {



    void dfs(int i,List<String> res,List<List<String>> ans){
        if (i<=0){
            System.out.println("Return");
            ans.add(res);
            return;
        }

        res.add(String.valueOf(i));
        System.out.println("Before:"+res);
        dfs(i-1,res,ans);
        System.out.println("After1:"+res);
        res.remove(String.valueOf(i));
        System.out.println("After2:"+res);


    }

    public static void main(String[] args) throws Exception{


        DFS dfs=new DFS();
        List<String> a1=new ArrayList<>();
        List<List<String>> a2=new ArrayList<>();

        dfs.dfs(3,a1,a2);
        System.out.println(a1);


        System.out.println(a2);
        System.out.println(a2);





    }
}
