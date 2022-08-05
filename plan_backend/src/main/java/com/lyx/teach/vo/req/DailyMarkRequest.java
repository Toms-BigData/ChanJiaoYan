package com.lyx.teach.vo.req;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 从前台接收到的打卡信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DailyMarkRequest {
    private String startTime;
    private String endTime;
    private Integer status;
}
