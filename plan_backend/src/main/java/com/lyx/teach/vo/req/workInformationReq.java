package com.lyx.teach.vo.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
public class workInformationReq {
    /**
     * 岗位Id
     */
    private String workId;
    /**
     * 用这个暂时代替文件名字
     */
    private String workInformationId;
    /**
     * 文件
     */
    private MultipartFile file;
    /**
     * 简介
     */
    private String content;
}
