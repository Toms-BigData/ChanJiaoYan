package com.lyx.teach.databasepojo.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentInfo {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 学生Id
     */
    private String studentId;
    /**
     * 学生姓名
     */
    private String Name;
    /**
     * 学生性别
     */
    private String sex;
    /**
     * 学生生日
     */
    private String birthdate;
    /**
     * 所属班级
     */
    private String classId;
    /**
     * 学生账户名
     */
    private String username;
    /**
     * 学生密码
     */
    private String password;
    /**
     * 学生权限
     */
    private String power;
    /**
     * 学生电话号码
     */
    private String phoneNumber;
    /**
     * 学生住址
     */
    private String address;
    /**
     * 学生email
     */
    private String email;
    /**
     * 学生师傅Id
     */
    private String teacherId;
}
