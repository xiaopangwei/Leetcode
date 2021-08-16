package leetcode.p2021m02.p20210224;

import java.util.Arrays;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/24
 * @time 3:53 PM
 */
public class QuickSortDemo {

    public int[] quickSort(int[] array,int k){
        int len=array.length;
        if (k<0 || k>len){
            return new int[0];
        }
        int[] res=sort(array,0,len-1,k);
//        System.out.println("result "+Arrays.toString(res));
        return res;
    }

    public int[] sort(int[] array,int start,int end,int k){

        int pivot=array[start];
        int i=start;
        int j=end;
        while (i<=j){
            while (i<=j && array[i]<=pivot) {i++;}
            while (i<=j && array[j]>=pivot) {j--;}

            if (i>j)
            {
                break;
            }
            else{
                swap(array,i,j);
//                i++;
//                j--;
            }
        }


        swap(array,start,j);
        System.out.println(pivot+" "+ Arrays.toString(array));

        int idx=j;
//        if (idx==k){
//            return Arrays.copyOf(array,k);
//        }
//        else if (idx>k){
//            return sort(array,idx,k,k);
//        }
//        else{
//            return sort(array,start,k,k);
//        }
        System.out.println(" index:"+idx+" content:"+array[idx]);
        return array;
    }


    public void swap(int[] array,int i,int j){
        System.out.println("Before swap "+Arrays.toString(array) +" "+i+"<-->"+j);
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
        System.out.println("After swap "+Arrays.toString(array));

    }


    public void threeWayPartition(int[] array,int start,int end,int pivot){
        int p1=start,p2=0;
        int p3=end;
        while (p2<p3){
            if (array[p2]==pivot){
                p2++;
            }
            else if (array[p2]>pivot)
            {
                swap(array,p2,p3);
                p3--;
            }
            else{
                p1++;
                p2++;
            }
        }
    }

    public static void main(String[] args){
//        int[] array=new int[]{2,1,2,1,1,1,12,1,1};
        int[] array=new int[]{90, 10, 20, 100, 3, 300, 400, 1670};
        QuickSortDemo demo=new QuickSortDemo();
        demo.quickSort(array,6);
    }
}
