package leetcode.unknown.shopee;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/7/5
 * @time 10:38 AM
 */
public class Solution726 {
    private int compare(char ch){
        if (ch>='0' && ch<='9'){return 1;}
        else if (ch>='a' && ch<='z'){return 2;}
        else if (ch>='A' && ch<='Z'){return 3;}
        return 4;
    }

    static class Pair{
        public String ch;
        public int freq;

        public Pair(String ch,int freq){
            this.ch=ch;
            this.freq=freq;
        }

        @Override
        public int hashCode() {
            return ch.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Pair pair=(Pair)obj;
            return pair.ch.equals(this.ch);
        }
    }
    public String countOfAtoms(String formula) {

        Map<String,Integer> freqMap=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Stack<Pair> stack=new Stack<>();
        char[] array=formula.toCharArray();
        int i=0;
        while (i<array.length){
            int charType=compare(array[i]);

            if (array[i]=='('){
               stack.push(new Pair("(",0));
               i++;
            }
            else if (array[i]==')'){
                int digit=1;


                int start=i+1;
                if (start < array.length && compare(array[start])==1 ) {
                    while (start < array.length && compare(array[start]) == 1) {
                        start++;
                    }
                    digit = Integer.valueOf(formula.substring(i + 1, start));
                }

                i=start;

                Queue<Pair> temp=new LinkedList<>();
                while (!stack.isEmpty() && stack.peek().ch.charAt(0)!='('){
                    Pair pair=stack.pop();
                    temp.add(new Pair(pair.ch,pair.freq*digit));
                }

                stack.pop();
                while (!temp.isEmpty()){
                    stack.push(temp.poll());
                }
            }
            else if (charType==3){
                int start=i+1;
                while (start<array.length){
                    //小写
                    if(compare(array[start])==2)
                    {start++;}
                    //大写或者数字
                    else if (array[start]=='(' || array[start]==')' )
                    {
                        break;
                    }
                    else if (compare(array[start])==1 || compare(array[start])==3){
                        break;
                    }
                }
                String element=formula.substring(i,start);
                if (start<array.length){
                    //数字
                    if (compare(array[start])==1){
                        int j=start;
                        while (start+1<array.length && compare(array[start+1])==1){
                            start++;
                        }
                        int len=Math.min(start+1,array.length);
                        int times=Integer.valueOf(formula.substring(j,len));
                        stack.push(new Pair(element,times));
                        i=start+1;
                    }else{
                        //大写字母
                        stack.push(new Pair(element,1));
                        i=start;
                    }
                }else{
                    stack.push(new Pair(element,1));
                    i=start;
                }
            }
        }

        while (!stack.isEmpty()){
            Pair temp=stack.pop();
           if (freqMap.containsKey(temp.ch)){
               freqMap.put(temp.ch,freqMap.get(temp.ch)+temp.freq);
           }else{
               freqMap.put(temp.ch,temp.freq);
           }
        }

        StringBuilder builder=new StringBuilder();
        for (Map.Entry<String,Integer> entry:freqMap.entrySet()){
            String key=entry.getKey();
            int value=entry.getValue();
            builder.append(key);
            if (value>1) {
                builder.append(String.valueOf(value));
            }
        }

        return builder.toString();
    }



    public static void main(String[] args){
        Solution726 solution726=new Solution726();
        System.out.println(solution726.countOfAtoms("(OH)"));
//        System.out.println(solution726.countOfAtoms("Mg(OH)21"));
//        System.out.println(solution726.countOfAtoms("K4(ON(SO3)2)2"));
    }

}
