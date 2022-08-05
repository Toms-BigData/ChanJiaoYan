package com.lyx.teach.controller;

import com.lyx.teach.service.SchoolService;
import com.lyx.teach.vo.req.UserFileReq;
import com.lyx.teach.vo.req.workInformationReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    /**
     * 批量上传学生数据
     * @param req
     */
    @PostMapping(value = "/uploadstu")
    @ResponseBody
    public void handleFileUpload(UserFileReq req) throws Exception {
        schoolService.handleFileUpload(req);
//        System.out.println(req.getUsername());
//        System.out.println(req.getFile());
    }
    /**
     * 资料上传
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public String FileUpload(workInformationReq req) throws Exception {
//        System.out.println(req.getWorkId());
//        System.out.println(req.getFile());
//        return "1";
        return schoolService.FileUpload(req);
    }
}
