package com.lyx.teach.service;

import com.lyx.teach.vo.req.UserFileReq;
import com.lyx.teach.vo.req.workInformationReq;
import com.mashape.unirest.http.exceptions.UnirestException;

public interface SchoolService {
    void handleFileUpload(UserFileReq req) throws Exception;


    String FileUpload(workInformationReq req) throws UnirestException;
}
