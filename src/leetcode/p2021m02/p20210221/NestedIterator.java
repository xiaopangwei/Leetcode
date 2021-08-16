package leetcode.p2021m02.p20210221;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/2/21
 * @time 4:24 PM
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }

public class NestedIterator implements Iterator<Integer> {


    private List<Integer> flattenList;

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {

        this.flattenList=new ArrayList<>();
        dfs(nestedList);
        iterator=flattenList.iterator();
    }

    public void dfs(List<NestedInteger> nestedList){
        if (nestedList==null || nestedList.isEmpty()){
            return;
        }
        for (NestedInteger integer:nestedList) {
            Integer result = null;
            if (integer.isInteger()) {
                result = integer.getInteger();
                flattenList.add(result);

            } else {
                List<NestedInteger> list = integer.getList();
                dfs(list);
            }
        }
    }
    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    static class MyNestedInt implements NestedInteger{

        private int number;
        public MyNestedInt(int number){
            this.number=number;
        }
        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return number;
        }

        @Override
        public List<NestedInteger> getList() {
            return null;
        }
    }

    static class MyNestedList implements NestedInteger{

        private List<NestedInteger> data;

        public MyNestedList(List<NestedInteger> data){
            this.data=data;
        }
        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedInteger> getList() {
            return data;
        }
    }
    public static void main(String[] args){
        List<NestedInteger> data=new ArrayList<>();
        data.add(new MyNestedInt(1));
        data.add(new MyNestedInt(2));

        List<NestedInteger> a1=new ArrayList<>();
        a1.add(new MyNestedInt(5));
        a1.add(new MyNestedInt(10));

        MyNestedList a2=new MyNestedList(a1);


        data.add(a2);
        NestedIterator iterator=new NestedIterator(data);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());

    }
}