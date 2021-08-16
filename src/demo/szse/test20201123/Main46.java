package demo.szse.test20201123;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2020/11/23
 * @time 11:30 AM
 */
public class Main46 {
    public static void main(String[] args){
//

        Main46 main46=new Main46();
        main46.permute(new int[]{1,2,3});

    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        boolean[] visited=new boolean[nums.length];

        for (int i=0;i<nums.length;i++){
            enumerate(nums,i,visited);
        }
        return result;


    }



    public void enumerate(int[] num, final int index,boolean[] visited){
        System.out.println("==>index start"+index);
        boolean flag=true;
        for (int i=0;i<num.length;i++){
            if (!visited[i])
            {
                flag=false;
            }
        }
        if (flag){
            return;
        }

        if (!visited[index]) {
            int value = num[index];
            System.out.println(value);
            visited[index] = true;
        }

        for (int i=0;i<num.length;i++){
//            System.out.println(num[i]);
            if (i!=index && !visited[i]){
                enumerate(num, i, visited);
            }
        }

        visited[index]=false;

        System.out.println("==>index end "+index);
    }
}
