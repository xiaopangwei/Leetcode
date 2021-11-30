package leetcode.p2021m11;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/29
 * @time 10:36 PM
 */
public class Solution386 {
    List<Integer> ans=new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++) {
            dfs(i, n);
        }
        return ans;
    }

    private void dfs(int val,final int maxVal){
        if (val>maxVal){
            return;
        }

        ans.add(val);

        for (int i=0;i<=9;i++){
            int tmp=val*10+i;
            dfs(tmp,maxVal);
        }
    }

    public static void main(String[] args){
        Solution386 solution386=new Solution386();
        List<Integer> ans=solution386.lexicalOrder(13);
        System.out.println(ans);
    }
}
