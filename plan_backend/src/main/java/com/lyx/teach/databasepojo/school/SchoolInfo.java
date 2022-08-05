package com.lyx.teach.databasepojo.school;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolInfo {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 学校Id
     */
    private String schoolId;
    /**
     * 学校名称
     */
    private String name;
    /**
     * 学校邮箱
     */
    private String email;
    /**
     * 学校地址
     */
    private String address;
    /**
     *  学校联系电话
     */
    private String phoneNumber;
    /**
     * 学校注册资金
     */
    private String registeredCapital;
    /**
     * 学校官方网站
     */
    private String offcialWebsite;
    /**
     * 学校领导
     */
    private String leader;
}
