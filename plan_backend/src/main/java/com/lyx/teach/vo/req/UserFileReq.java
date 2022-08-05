package com.lyx.teach.vo.req;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class UserFileReq {

    private String username;

    private MultipartFile file;

}
