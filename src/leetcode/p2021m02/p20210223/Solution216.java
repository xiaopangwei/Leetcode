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
public class Solution216 {

    private List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combinationSum3( int k,int n) {

        List<Integer> dataList=new ArrayList<>();
        dfs(1,dataList,k,n);
//        System.out.println(res.size());
        return res;


    }

    private int sum(List<Integer> dataList){
        int sum=0;
        for (Integer i:dataList){
            sum+=i;
        }
        return sum;
    }
    public void dfs(int index,List<Integer> dataList,final int k,final int n)
    {

        int sumation=sum(dataList);
//        System.out.println("index: "+index+" dataList:"+dataList);
        if (dataList.size()==k && sumation==n){
//            System.out.println(dataList);
            res.add(new ArrayList<>(dataList));
            return;
        }
        if (sumation>n){
            return;
        }


        for (int i=index;i<=9;i++){
            if (!dataList.contains(i)){

                dataList.add(i);
//                System.out.println("Before "+dataList);
                dfs(i,dataList,k,n);
                dataList.remove(Integer.valueOf(i));
//                System.out.println("After "+dataList);
            }
        }



    }
    public static void main(String[] args){
        Solution216         solution77 =new Solution216();
        List<List<Integer>> ans        =solution77.combinationSum3(3,7);
        System.out.println(ans);

    }
}
