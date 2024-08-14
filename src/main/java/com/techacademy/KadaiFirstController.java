package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
public class KadaiFirstController {

    @GetMapping("/dayofweek/{date}")
    public String dispDayOfWeek(@PathVariable String date) {
        // 日付文字列から年、月、日を抽出
        String yearStr = date.substring(0, 4);
        String monthStr = date.substring(4, 6);
        String dayStr = date.substring(6, 8);

        // 年、月、日を整数に変換
        int year = Integer.parseInt(yearStr);
        int month = Integer.parseInt(monthStr) - 1; // Calendarクラスでは月が0から始まるため、1を引く
        int day = Integer.parseInt(dayStr);

        // Calendarオブジェクトを作成し、日付を設定
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        // 曜日を取得
        String[] daysOfWeek = {"日曜日", "月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日"};
        int dayOfWeekIndex = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Calendarクラスでは日曜日が1のため、1を引く
        String dayOfWeek = daysOfWeek[dayOfWeekIndex];

        return dayOfWeek;
    }

    @GetMapping("/plus/{num1}/{num2}")
    public int calcPlus(@PathVariable int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/minus/{num1}/{num2}")
    public int calcMinus(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping("/times/{num1}/{num2}")
    public int calcTimes(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/{num2}")
    public int calcDivide(@PathVariable int num1, @PathVariable int num2) {
        if (num2 == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return num1 / num2;
    }
}
