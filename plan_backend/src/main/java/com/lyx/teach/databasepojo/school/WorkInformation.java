package com.lyx.teach.databasepojo.school;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkInformation {
    /**
     * id(数据库必有字段用来查找是哪条数据)
     */
    private String Id;
    /**
     * 操作时间（数据库必有字段暂时无意义）
     */
    private String optime;
    /**
     * 学习资料编号
     */
    private String workInformationId;
    /**
     * 存储路径
     */
    private String path;
    /**
     * 岗位编号
     */
    private String workId;
}
