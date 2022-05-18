package leetcode.p2022m05.day0511;


import java.util.*;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2022/5/11
 * @time 10:13 PM
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
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        List<Interval> data = new ArrayList<>();
        for (List<Interval> item : schedule) {
            data.addAll(item);
        }

        Collections.sort(data, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start != o2.start) {
                    return o1.start - o2.start;
                }
                return o1.end - o2.end;
            }
        });

        List<Interval> workTimeList = new ArrayList<>();
        workTimeList.add(new Interval(data.get(0).start, data.get(0).end));


        for (int i = 1; i < data.size(); i++) {
            Interval last = workTimeList.get(workTimeList.size() - 1);
            if (data.get(i).start > last.end) {
                workTimeList.add(new Interval(data.get(i).start, data.get(i).end));
            } else {
                last.end = Math.max(data.get(i).end, last.end);
            }
        }
        List<Interval> ans = new ArrayList<>();

        for (int i = 0; i < workTimeList.size() - 1; i++) {
            int last  = workTimeList.get(i).end;
            int first = workTimeList.get(i + 1).start;
            if (last < first) {
                ans.add(new Interval(last, first));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution759          solution759 = new Solution759();
        List<List<Interval>> input       = new ArrayList<>();
        List<Interval>       t           = Arrays.asList(new Interval(1, 2), new Interval(5, 6), new Interval(1, 3), new Interval(4, 10));
        input.add(t);
        System.out.println(solution759.employeeFreeTime(input));
    }
}
