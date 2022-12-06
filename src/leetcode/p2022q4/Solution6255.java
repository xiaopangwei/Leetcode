package leetcode.p2022q4;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/12/4
 * @time 10:10 PM
 */
public class Solution6255 {
    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] r : roads) {
            int s = r[0];
            int t = r[1];
            union(parent, s, t);
        }

        int minScore = Integer.MAX_VALUE;
        for (int[] r : roads) {
            int temp = find(parent, 1);
            if (temp == find(parent, r[0])) {
                minScore = Math.min(minScore, r[2]);
            }
        }
        return minScore;
    }

    private void union(int[] parent, int x, int y) {
        int px = find(parent,x);
        int py = find(parent,y);
        if (px != py) {
            parent[px] = py;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent, parent[x]);
    }

    public static void main(String[] args){
        int[][] array=new int[][]{{4,5,7468},{6,2,7173},{6,3,8365},{2,3,7674},{5,6,7852},{1,2,8547},{2,4,1885},{2,5,5192},{1,3,4065},{1,4,7357}};
        Solution6255 solution6255=new Solution6255();
        int ans=solution6255.minScore(6,array);
        System.out.println(ans);
    }

}
