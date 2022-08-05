package com.lyx.teach.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "url")
public class UrlInfoConfig {
    /**
     * 使用阿里云的数据库
     */
    private String aLiYun;
    /**
     * 使用实验室的数据库
     */
    private String shiYanShi;
    /**
     * 获取表中所有数据的url地址
     */
    private String selectAllUrl;

    /**
     * 获取表中一条数据的url地址
     */
    private String selectOneUrl;
    /**
     * 添加表中一条数据的url地址
     */
    private String addUrl;
    /**
     * 删除表中一条数据的url地址
     */
    private String deleteUrl;
    /**
     * 更新表中一条数据的url地址
     */
    private String updateUrl;

    private String uploadUrl;
}
