package leetcode.p2021m11;

/**
 * <p>Description: </p>
 * <p>Company: Harbin Institute of Technology</p>
 *
 * @author weihuang
 * @date 2021/11/20
 * @time 11:27 AM
 */
public class Solution1185 {
    public String dayOfTheWeek(int day, int month, int year) {

        //1971-1-1 Friday


        int[] months = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int   days   = 0;

        for (int i = 1971; i < year; i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }


        boolean isLeap = isLeapYear(year);
        for (int i = 0; i < month - 1; i++) {
            if (i == 1 && isLeap) {
                days += 29;
            } else {
                days += months[i];
            }
        }

        days += day;

        int temp = (days - 1) % 7;

        switch (temp) {
            case 0:
                return "Friday";
            case 1:
                return "Saturday";
            case 2:
                return "Sunday";
            case 3:
                return "Monday";
            case 4:
                return "Tuesday";

            case 5:
                return "Wednesday";
            case 6:
                return "Thursday";

        }

        return "";

    }

    private boolean isLeapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        }
        if (year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1185 solution1185 = new Solution1185();
        String       ans          = solution1185.dayOfTheWeek(18, 7, 1999);
        System.out.println(ans);
    }
}
