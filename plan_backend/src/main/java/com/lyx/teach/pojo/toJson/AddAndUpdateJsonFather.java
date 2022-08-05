package com.lyx.teach.pojo.toJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 将更新数据包装为请求
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAndUpdateJsonFather {
    private String englishName;
    private String apiToken = "cms123456654321";
    private String auditField = "auditStatusHideValue";
    private String id = "1";
    private String type = "false";
    private List<Map> contentList;
}
