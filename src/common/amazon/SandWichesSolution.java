package common.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/8/16
 * @time 9:32 PM
 */
public class SandWichesSolution {
    public int countStudents(int[] students, int[] sandwiches) {
        LinkedList<Integer> studentList  = new LinkedList<>();
        LinkedList<Integer> sandwichList = new LinkedList<>();

        for (int s : students) {
            studentList.add(s);
        }

        for (int s : sandwiches) {
            sandwichList.add(s);
        }

        while (true) {
            if (sandwichList.isEmpty() || studentList.isEmpty()) {
                break;
            }
            if (studentList.peek() == sandwichList.peek()) {
                studentList.pollFirst();
                sandwichList.pollFirst();
            } else {
                studentList.addLast(studentList.pollFirst());
            }

            if (!studentList.contains(sandwichList.peek())) {
                break;
            }
        }
        return studentList.size();
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> generate(int numRows) {
        res.add(dfs(numRows));
        return res;
    }


    private List<Integer> dfs(int numRows) {
        if (numRows == 1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            return temp;
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        List<Integer> lastRowList = dfs(numRows - 1);
        res.add(lastRowList);
        for (int i = 0; i < lastRowList.size() - 1; i++) {
            ans.add(lastRowList.get(i) + lastRowList.get(i + 1));
        }
        ans.add(1);
        return ans;
    }


    public int maxDotProduct(int[] nums1, int[] nums2) {
        int     m  = nums1.length;
        int     n  = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-10000);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int t1 = dp[i - 1][j];
                int t2 = dp[i][j - 1];
                int t3 = dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1];
                int t4 = dp[i - 1][j - 1];
                int t5 = nums1[i - 1] * nums2[j - 1];

                int m1=Math.max(t1,t2);
                int m2=Math.max(t3,t4);
                dp[i][j]=Math.max(dp[i][j],Math.max(m1,Math.max(m2,t5)));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
//        SandWichesSolution sandWichesSolution = new SandWichesSolution();
        //        输入：nums1 = [2,1,-2,5], nums2 = [3,0,-6]
//        System.out.println(sandWichesSolution.maxDotProduct(new int[]{3,-2},new int[]{2,-6,7}));

        System.out.println((5+(-7%5))%5);



    }
}
