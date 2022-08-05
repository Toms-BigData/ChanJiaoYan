package com.lyx.teach.databasepojo.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Notice {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 通知Id
     */
    private String noticeId;
    /**
     * 通知名称
     */
    private String name;
    /**
     * 通知日期
     */
    private String date;
    /**
     * 通知内容
     */
    private String content;
}
