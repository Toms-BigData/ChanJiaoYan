package com.lyx.teach.databasepojo.enterprise;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class enterpriseInfo {
    /**
     * 企业id
     */
    private String enterpriseId;
    /**
     * 企业名称
     */
    private String name;
    /**
     * 法定代表人
     */
    private String leader;
    /**
     * 统一社会信用代码
     */
    private String code;
    /**
     * 公司地址
     */
    private String address;
    /**
     * 联系人
     */
    private String contacts;
    /**
     * 联系人电话
     */
    private String phoneNumberPerson;
    /**
     * 公司电话
     */
    private String PhoneNumberEnterprise;
    /**
     * 公司邮件
     */
    private String email;
    /**
     * 公司类型
     */
    private String type;
    /**
     * 公司官网
     */
    private String offcialWebsite;
    /**
     * 公司注册资金
     */
    private String registeredCapital;
}
