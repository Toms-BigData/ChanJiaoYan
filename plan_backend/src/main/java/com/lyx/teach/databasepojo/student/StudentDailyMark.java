package com.lyx.teach.databasepojo.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDailyMark {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 学生id
     */
    private String studentId;
    /**
     * 打卡日期
     */
    private String dailyMarkDate;
    /**
     * 打卡开始日期
     */
    private String startTime;
    /**
     * 打卡结束日期
     */
    private String endTime;
    /**
     * 状态
     */
    private String status;
}
