package leetcode.p2021m02.p20210209;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/9
 * @time 10:19 AM
 */
public class TemplateMain {

    private List<List<Integer>> ans=new ArrayList<>();

    public void dfs(int index,int[] num,List<Integer> data){
        if (index>=num.length){
            ans.add(new ArrayList<>(data));
            return;
        }
//        System.out.println(num[index]);

        data.add(num[index]);
        System.out.println("Before "+data);
        dfs(index+1,num,data);

        dfs(index+2,num,data);
        data.remove(data.size()-1);
        System.out.println("After "+data);

    }
    public static void main(String[] args){
        TemplateMain templateMain=new TemplateMain();
        templateMain.dfs(0,new int[]{1,2,3},new ArrayList<>());
    }
}
