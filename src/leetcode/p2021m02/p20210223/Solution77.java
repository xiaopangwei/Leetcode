package leetcode.p2021m02.p20210223;


import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/23
 * @time 11:22 AM
 */
public class Solution77 {

    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        List<Integer> dataList=new ArrayList<>();
        dfs(1,dataList,k,n);
        System.out.println(res.size());
        return res;
    }




    public void dfs(int index,List<Integer> dataList,final int k,final int n)
    {
//        System.out.println("index: "+index+" dataList:"+dataList);
        if (dataList.size()==k){
//            System.out.println(dataList);
            res.add(new ArrayList<>(dataList));
            return;
        }


        for (int i=index;i<=n;i++){
            if (dataList.size()+n-i+1<k)
            {
                return;
            }
            if (!dataList.contains(i)){
                dataList.add(i);
                dfs(i,dataList,k,n);
                dataList.remove(Integer.valueOf(i));
            }
        }



    }
    public static void main(String[] args){
        Solution77 solution77=new Solution77();
        List<List<Integer>> ans=solution77.combine(7,4);
        System.out.println(ans);

    }
}
