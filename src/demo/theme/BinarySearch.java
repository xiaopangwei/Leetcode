package demo.theme;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/20
 * @time 11:01 PM
 */
public class BinarySearch {

    public static final int[] testCase1=new int[]{1,2,2,3,3,3,4,4,4,4,7,10,20,30,100};

    /**
     * 获取第一个跟指定元素相等的位置
     * @param array
     * @param target
     * @return
     */
    public int getEqualsFirst(int[] array,int target){

        int left=0;
        int right=array.length-1;
        if (array[left]>target || array[right]<target){
            return -1;
        }
        while (left<=right){
            System.out.println(left+" "+right);
            int mid=(left+right)/2;
            if (array[mid]<target){
                left=mid+1;
            }
            else if (array[mid]>target){
                right=mid-1;
            }else{
                right=mid-1;
            }

        }
        if (left>=0 && left<array.length && right>=0 && right<array.length) {
            System.out.println(String.format("left:[%d] leftValue:[%d] right:[%d] leftValue:[%d]",left,array[left],right,array[right]));

        }
        return left;
    }


    /**
     * 获取最后一个跟指定元素相等的位置
     * @param array
     * @param target
     * @return
     */
    public int getEqualsLast(int[] array,int target){
        int left=0;
        int right=array.length-1;
        if (array[left]>target || array[right]<target){
            return -1;
        }
        while (left<=right){
            System.out.println(left+" "+right);
            int mid=(left+right)/2;
            if (array[mid]<target){
                left=mid+1;
            }
            else if (array[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        if (left>=0 && left<array.length && right>=0 && right<array.length) {
            System.out.println(String.format("left:[%d] leftValue:[%d] right:[%d] leftValue:[%d]",left,array[left],right,array[right]));

        }
        return right;
    }


    /**
     * 1 3 5
     * 小于元素并且最接近的元素
     * @param array
     * @param target
     * @return
     */
    public int getLessThanLast(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while (left<=right){
            System.out.println(left+" "+right);
            int mid=(left+right)/2;
            if (array[mid]<target){
                left=mid+1;
            }
            else if (array[mid]>target){
                right=mid-1;
            }else{
                right=mid-1;
            }

        }
        if (left>=0 && left<array.length && right>=0 && right<array.length) {
            System.out.println(String.format("left:[%d] leftValue:[%d] right:[%d] leftValue:[%d]",left,array[left],right,array[right]));

        }
        if (right>=0 && right<array.length){
            return right;
        }

        return -1;
    }


    /**
     * 1 3 5
     * 大于元素并且最接近的元素
     * @param array
     * @param target
     * @return
     */
    public int getGreaterThanFirst(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while (left<=right){
            System.out.println(left+" "+right);
            int mid=(left+right)/2;
            if (array[mid]<target){
                left=mid+1;
            }
            else if (array[mid]>target){
                right=mid-1;
            }else{
                left=mid+1;
            }

        }
        if (left>=0 && left<array.length && right>=0 && right<array.length) {
            System.out.println(String.format("left:[%d] leftValue:[%d] right:[%d] leftValue:[%d]",left,array[left],right,array[right]));

        }
        if (left>=0 && left<array.length){
            return left;
        }
        return -1;
    }


    /**
     * 最后一个小于或者等于元素的位置
     * 1 2 13 17 24 35
     * @param array
     * @param target
     * @return
     */
    public int getLessThanOrEqualsLast(int[] array,int target){
        int left=0;
        int right=array.length-1;
        while (left<=right){
            System.out.println(left+" "+right);
            int mid=(left+right)/2;
            if (array[mid]<target){
                left=mid+1;
            }
            else if (array[mid]>target){
                right=mid-1;
            }else{
                right=mid-1;
            }

        }
        if (left>=0 && left<array.length && right>=0 && right<array.length) {
            System.out.println(String.format("left:[%d] leftValue:[%d] right:[%d] leftValue:[%d]",left,array[left],right,array[right]));

        }
        if (right>=0 && right<array.length){
            return right;
        }

        return -1;
    }

    //1,2,2,3,3,3,4,4,4,4,7,10,20,30,100
    public static void main(String[] args){
        BinarySearch binarySearch=new BinarySearch();
        System.out.println(binarySearch.getGreaterThanFirst(BinarySearch.testCase1,3));
//        binarySearch.getLessThanLast(BinarySearch.testCase1,15);
//        binarySearch.getLessThanLast(BinarySearch.testCase1,3);
//        System.out.println(binarySearch.getEqualsLast(BinarySearch.testCase1,4));
    }



}
