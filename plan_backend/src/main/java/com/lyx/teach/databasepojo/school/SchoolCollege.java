package com.lyx.teach.databasepojo.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolCollege {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 学院ID
     */
    private String collegeId;
    /**
     * 学院名称
     */
    private String name;
    /**
     * 学院所属学校Id
     */
    private String schoolId;
}
