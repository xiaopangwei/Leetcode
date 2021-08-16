package demo.completition;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/6/24
 * @time 9:58 AM
 */
public class Solution1791 {
    public int findCenter(int[][] edges) {

        if (edges[0][0]==edges[1][0]|edges[0][0]==edges[1][1])
        {
            return edges[0][0];
        }else{
            return edges[0][1];
        }
    }

    public static void main(String[] args){
        Solution1791 solution1791=new Solution1791();
        System.out.println(solution1791.findCenter(new int[][]{{1,2},{2,3},{4,2}}));
        System.out.println(solution1791.findCenter(new int[][]{ {1,2},{5,1},{1,3},{1,4}}));

    }
}
