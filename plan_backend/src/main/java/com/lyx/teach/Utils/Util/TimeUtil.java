package com.lyx.teach.Utils.Util;

import java.util.ArrayList;
import java.util.List;

public class TimeUtil {
    /**
     * 将输入进来的字符串解析成需要的数据格式
     * @param TimeString "2022/7/23 16:44:00"
     * @return List[0] = "2022/7/23" List[1] = "2022/7/23 16:44:00"
     */
    public static List<String> DateParse(String TimeString){
        String Date = TimeString.split(" ")[0];
        List<String> dateList = new ArrayList<>();
        dateList.add(Date);
        dateList.add(TimeString);
        return dateList;
    }
}
