package leetcode.p2021m07;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/30
 * @time 10:46 AM
 */
public class Vector2D {
    private int index1=0;
    private int index2=0;
    private int[][] array;
    public Vector2D(int[][] v) {
        this.array=v;
    }

    public int next() {
        int val=0;
        if (index2==array[index1].length-1){
            val=array[index1][index2];
            index1++;
            index2=0;
        }
        else {

            val=array[index1][index2];
            index2++;
        }
//        System.out.println(val);
        return val;
    }

    public boolean hasNext() {

        boolean res=true;
        if (index1>=array.length){
            return false;
        }

        while (index1<array.length){
            if (array[index1].length==0){
                index1++;
            }else{
                break;
            }
        }

        if (index1>=array.length){
            return false;
        }
        return res;
    }

    public static void main(String[] args){

        //[[[[]]],[]]
        Vector2D iterator=new Vector2D(new int[][]{new int[]{1,2},new int[]{},new int[]{}});
        iterator.next(); // 返回 1
        iterator.next(); // 返回 2

        System.out.println(iterator.hasNext());

    }
}
