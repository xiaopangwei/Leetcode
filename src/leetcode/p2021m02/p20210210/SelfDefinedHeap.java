package leetcode.p2021m02.p20210210;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * 大根堆
 * @author weihuang
 * @date 2021/2/10
 * @time 4:11 PM
 */

public class SelfDefinedHeap {

    public List<Integer> heap=new ArrayList<>();

    public void insert(int num){
        heap.add(num);
        heapify();

    }

    public int remove(){
        int ans=heap.get(0);

        int lastOne=heap.get(heap.size()-1);
        heap.set(0,lastOne);
        heap.remove(heap.size()-1);


        int index=0;

        while(true){
            if (heap.isEmpty()){
                break;
            }
            int left=index*2+1;
            int right=index*2+2;
            int maxIndex=-1;
            int current=heap.get(index);

            if (left<=heap.size()-1){
                if (heap.get(left)>current){
                    maxIndex=left;
                }
            }

            if (right<=heap.size()-1){
                if (heap.get(right)>current && heap.get(right)>heap.get(left)){
                    maxIndex=right;
                }
            }

            if (maxIndex==-1){
                break;
            }
            else{
                //交换数据
                int temp=heap.get(maxIndex);
                heap.set(maxIndex,heap.get(index));
                heap.set(index,temp);
                index=maxIndex;

            }
        }
        return ans;
    }



    private void heapify(){
        int lastIndex=heap.size()-1;
        int parentIndex=(lastIndex-1)/2;

        while (true){
            int parentValue=heap.get(parentIndex);
            int lastValue=heap.get(lastIndex);
            if (parentValue>=lastValue){
                break;
            }
            else{
                //parentV 小
                //lastV 大
                heap.set(lastIndex,parentValue);
                heap.set(parentIndex,lastValue);

                lastIndex=parentIndex;
                parentIndex=(parentIndex-1)/2;
            }
        }

    }


    public static void main(String[] args){
        SelfDefinedHeap selfDefinedHeap=new SelfDefinedHeap();
        selfDefinedHeap.insert(1);
        selfDefinedHeap.insert(9);
        selfDefinedHeap.insert(11);
        selfDefinedHeap.insert(3);
        selfDefinedHeap.insert(20);
        selfDefinedHeap.insert(100);
        System.out.println(selfDefinedHeap);
        for (int i=0;i<6;i++) {
            System.out.println(selfDefinedHeap.remove());
        }
    }


}
