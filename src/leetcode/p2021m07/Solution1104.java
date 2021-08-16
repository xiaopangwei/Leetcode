package leetcode.p2021m07;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/29
 * @time 9:15 AM
 */
public class Solution1104 {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> list=new LinkedList<>();
        list.addFirst(label);
        int level=getLevelId(label);
        while (true){
            if (level==1){
                break;
            }
            int parent=label/2;
            int sum= (1 << (level-1))-1 + (1 << (level-2));
            int realParent=sum-parent;
            label=realParent;
            list.addFirst(realParent);
            level--;

        }
        return list;
    }

    private int getLevelId(int label){
        if (label==1){
            return 1;
        }
        int base=1;

        while (true){
           int lower= 1 << base;
           int upper= (1 << (base+1))-1;

           if (label>=lower && label<=upper){
               return base+1;
           }
           base++;
        }

    }

    public static void main(String[] args){
        Solution1104 solution1104=new Solution1104();

        System.out.println(solution1104.pathInZigZagTree(26));
//        System.out.println(solution1104.pathInZigZagTree(26));
//        System.out.println(solution1104.getLevelId(1));
//        System.out.println(solution1104.getLevelId(6));
//        System.out.println("Level:"+solution1104.getLevelId(14));
//        System.out.println(solution1104.getLevelId(26));
//        System.out.println(solution1104.getLevelId(60));
    }
}
