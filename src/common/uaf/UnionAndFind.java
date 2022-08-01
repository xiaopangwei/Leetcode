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
public class UnionAndFind {
    public int[] parent;
    public int[] rank;


    public UnionAndFind() {
        parent = new int[10];
        rank = new int[10];

        for (int i = 0; i < 10; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }


    public UnionAndFind(int[] parent, int[] rank) {
        this.parent = parent;
        this.rank = rank;
    }


    public UnionAndFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        parent[x] = find(parent[x]);
//        System.out.println(x + " " + parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {

        int parentX = find(x);
        int parentY = find(y);

        if(parentX==parentY){
            return;
        }
        if (rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
            rank[parentY]+=rank[parentX];
        } else if (rank[parentY] < rank[parentX]) {
            parent[parentY] = parentX;
            rank[parentX]+=rank[parentY];
        } else {
            parent[parentX] = parentY;
            rank[parentY]+=rank[parentX];
        }

    }

    public static void main(String[] args) {
        UnionAndFind obj = new UnionAndFind();
        obj.parent[2] = 3;
        obj.parent[1] = 2;
        obj.parent[4] = 2;
        obj.parent[5] = 1;

        obj.rank[3] = 4;
        obj.rank[2] = 3;

        obj.rank[1] = 2;
        obj.rank[4] = 2;
        System.out.println("Before " + Arrays.toString(obj.parent));

        System.out.println(obj.find(5));
        System.out.println("After " + Arrays.toString(obj.parent));
    }
}
