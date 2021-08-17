package common.uaf;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/17
 * @time 9:36 AM
 */
public class UnionAndFindWithWeight {
    public int[] parent;
    public double[] weight;



    public UnionAndFindWithWeight(int[] parent,double[] weight) {
        this.parent = parent;
        this.weight=weight;
    }


    public UnionAndFindWithWeight(int n) {
        this.parent = new int[n];
        this.weight = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        int p=parent[x];
        parent[x] = find(p);
        weight[x] = weight[x] * weight[p];
        return parent[x];

    }

    public void union(int x, int y,double val) {

        //x=val*y

        //x=weight[x]
        int parentX = find(x);
        int parentY = find(y);

        if (parentX==parentY){
            return;
        }
        parent[parentX]=parentY;
        weight[parentX]=weight[y] * val / weight[x];
    }

    public static void main(String[] args) {
        UnionAndFindWithWeight obj = new UnionAndFindWithWeight(1);
        obj.parent[2] = 3;
        obj.parent[1] = 2;
        obj.parent[4] = 2;
        obj.parent[5] = 1;

        System.out.println("Before " + Arrays.toString(obj.parent));

        System.out.println(obj.find(5));
        System.out.println("After " + Arrays.toString(obj.parent));
    }
}
