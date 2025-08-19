package basics;

import java.time.*;

public class Clock {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // 定位到本月第一天
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue(); // 1 = Monday, 7 = Sunday

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        // 打印第一行的前导空格
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*"); // 标记今天
            } else {
                System.out.print(" ");
            }

            // 如果是周日就换行
            if (date.getDayOfWeek().getValue() == 7) {
                System.out.println();
            }

            date = date.plusDays(1);
        }

        // 确保最后换行
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}
