package leetcode.p2021m08;

import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/8/22
 * @time 11:01 AM
 */
public class Solution759 {
    static class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public String toString() {
            return "{" + start + " " + end + "}";
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> datas = new ArrayList<>();
        for (List<Interval> list : schedule) {
            datas.addAll(list);
        }
        Collections.sort(datas, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                } else {
                    return o1.end - o2.end;
                }
            }
        });
        List<Interval> available = new ArrayList<>();
        Interval       first     = datas.get(0);
        available.add(new Interval(first.start, first.end));

        for (int i = 1; i < datas.size(); i++) {

            Interval target = datas.get(i);
            boolean  flag   = false;
            for (int j = 0; j < available.size(); j++) {

                Interval source = available.get(j);
                if (source.start <= target.start && target.start <= source.end) {

                    flag = true;
                    if (target.end > source.end) {
                        source.end = target.end;
                    }
                }

            }

            if (!flag) {
                available.add(new Interval(target.start, target.end));
            }
        }


        List<Interval> res = new ArrayList<>();

        for (int i = 0; i < available.size() - 1; i++) {

            Interval temp = new Interval(available.get(i).end, available.get(i + 1).start);
            res.add(temp);
        }

        return res;

    }

    public static void main(String[] args) {
        Solution759 solution759 = new Solution759();
        //[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]

        Interval i1 = new Interval(1, 3);
        Interval i2 = new Interval(6, 7);
        Interval i3 = new Interval(2, 4);
        Interval i4 = new Interval(2, 5);
        Interval i5 = new Interval(9, 12);

        List<List<Interval>> list = new ArrayList<>();

        list.add(Arrays.asList(i1, i2));
        list.add(Arrays.asList(i3));
        list.add(Arrays.asList(i4, i5));

        List<Interval> res = solution759.employeeFreeTime(list);
        System.out.println(res);


    }
}
