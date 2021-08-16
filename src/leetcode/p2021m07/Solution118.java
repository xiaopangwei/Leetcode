package leetcode.p2021m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/31
 * @time 11:45 PM
 */
public class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> initialArray= Arrays.asList(1);
        ans.add(initialArray);
        if (numRows==1){
            return ans;
        }

        List<Integer> data=initialArray;
        for (int i=2;i<=numRows;i++){
            List<Integer> temp=transform(data);
            ans.add(temp);
            data=temp;
        }
        return ans;
    }

    private List<Integer> transform(List<Integer> array){
        List<Integer> newList=new ArrayList<>();
        newList.add(1);
        for (int i=0;i<array.size()-1;i++){
            int temp=array.get(i)+array.get(i+1);
            newList.add(temp);
        }
        newList.add(1);
        return newList;
    }

    public static void main(String[] args){
        Solution118 solution118=new Solution118();
        System.out.println(solution118.generate(5));
    }
}
