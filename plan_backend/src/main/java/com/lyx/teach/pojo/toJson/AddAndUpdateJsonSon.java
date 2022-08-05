package com.lyx.teach.pojo.toJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * 更新的数据存储在这个类中
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddAndUpdateJsonSon {
    private String englishName;
    private List<Map> subcontentList;
}
