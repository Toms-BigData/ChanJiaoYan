package com.lyx.teach.pojo.toJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 查找数据封装为json
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectJson {
    private Map filter;
    private Map params;
    private String apiToken = "cms12345654321";
}
