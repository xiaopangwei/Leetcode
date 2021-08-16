package leetcode.p2021m02.p20200219;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/20
 * @time 1:42 PM
 */
public class RandomTest {

    public static void main(String[] args){
//        Random random=new Random();
//        int[] array=new int[]{1,2,3,4,5};
//        List<Integer> data=new ArrayList<>();
//
//        List<Integer> datas=Arrays.stream(array).boxed().collect(Collectors.toList());
//        for (int i=0;i<5;i++) {
//            int removeIdx=random.nextInt(datas.size());
//            data.add(datas.get(removeIdx));
//            datas.remove(removeIdx);
//        }
//
//        System.out.println(data);

        String expression="156+(234*61)";
        char[] array=expression.toCharArray();
        List<String> elements=new ArrayList<>();
        List<Integer> types=new ArrayList<>();
        int count=0;
        int endIndex=0;
        for (int i=0;i<array.length;i++){
            char ch=array[i];

            if (ch>='0' && ch<='9')
            {
                count++;
                endIndex=i;
            }
            else if (ch=='+' || ch=='-' || ch=='*' || ch=='/' )
            {
                String number=expression.substring(endIndex-count+1,endIndex+1);
                if (!number.trim().isEmpty()) {
                    elements.add(number);
                    types.add(1);
                }

                elements.add(String.valueOf(ch));
                types.add(2);
                count=0;

            }
            else if (ch=='(' || ch==')'){

                String number=expression.substring(endIndex-count+1,endIndex+1);
                if (!number.trim().isEmpty()) {
                    elements.add(number);
                    types.add(1);
                }

                elements.add(String.valueOf(ch));
                types.add(3);
                count=0;
            }
        }

        System.out.println(elements);
        System.out.println(types);

    }
}
