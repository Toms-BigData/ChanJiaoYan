package com.lyx.teach.databasepojo.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SchoolManager {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 管理员ID
     */
    private String schoolManagerId;
    /**
     * 管理员姓名
     */
    private String name;
    /**
     * 管理员登录账户
     */
    private String username;
    /**
     * 管理员密码
     */
    private String password;
    /**
     * 管理员权限
     */
    private String power;
    /**
     * 管理员所属学校Id
     */
    private String SchoolId;
    /**
     * 管理员电话号码
     */
    private String phoneNumber;
}
