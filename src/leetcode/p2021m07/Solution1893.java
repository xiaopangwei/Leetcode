package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/23
 * @time 9:50 AM
 */
public class Solution1893 {
    public boolean isCovered(int[][] ranges, int left, int right) {

        boolean[] visited=new boolean[51];

        for (int[] range:ranges){

            for (int i=range[0];i<=range[1];i++){
                visited[i]=true;
            }
        }

        for (int i=left;i<=right;i++){
            if (!visited[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Solution1893 solution1893=new Solution1893();
        System.out.println(solution1893.isCovered(new int[][]{{1,10},{10,20}},21,21));
    }

}
