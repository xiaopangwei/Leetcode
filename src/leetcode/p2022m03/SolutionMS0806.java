package leetcode.p2022m03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/2/27
 * @time 10:03 PM
 */
public class SolutionMS0806 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A.size(),A,B,C);
    }

    public void dfs(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        }

        dfs(n - 1, A, C, B);
        int temp=A.remove(A.size() - 1);
        C.add(temp);
        dfs(n - 1, B, A, C);
    }

    public static void main(String[] args){
        SolutionMS0806 solutionMS0806=new SolutionMS0806();
        List<Integer> list=new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        solutionMS0806.hanota(list,new ArrayList<>(),new ArrayList<>());
    }
}
