package com.lyx.teach.service.Impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lyx.teach.Utils.Util.EntityUtils;
import com.lyx.teach.config.IdInfoConfig;
import com.lyx.teach.config.UrlInfoConfig;
import com.lyx.teach.databasepojo.school.WorkInformation;
import com.lyx.teach.pojo.toJson.AddAndUpdateJsonSon;
import com.lyx.teach.service.SchoolService;
import com.lyx.teach.vo.req.UserFileReq;
import com.lyx.teach.vo.req.workInformationReq;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.lyx.teach.Utils.AddAndUpdateUtil.sendInfoByAddOrUpdata;
import static com.lyx.teach.Utils.Util.FileUtil.MultipartFile2File;

@Service("SchoolService")
public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private IdInfoConfig idInfoConfig;

    @Autowired
    private UrlInfoConfig urlInfoConfig;

    @Override
    public void handleFileUpload(UserFileReq req) throws Exception {
        //1.从前台拿数据存到本地
//        MultipartFile mfile = req.getFile();
//        String fileName = mfile.getOriginalFilename();
//        String path = "D:\\testUpload\\" + fileName;
//        InputStream inputStream = mfile.getInputStream();
//        FileOutputStream fileOut = new FileOutputStream(path);//这里可以改路径
//        IOUtils.copy(inputStream, fileOut);
//        fileOut.flush();
        //2.从本地上传到服务器
        String path = "D:\\testUpload\\StudentInfo1.xls";
        File file = new File(path);
        HttpResponse<String> response = Unirest.post("http://222.24.63.60:8888/sadata/uploadExcleRest/uploadFile")
                .field("file", file)
                .asString();
        System.out.println(response);
    }

    @Override
    public String FileUpload(workInformationReq req) throws UnirestException {
        String tableName = "workInformation";
        MultipartFile multipartFile = req.getFile();
        //转换文件类型
        File file = MultipartFile2File(multipartFile);
        Unirest.setTimeouts(0, 0);
        HttpResponse<String> response = Unirest.post(urlInfoConfig.getUploadUrl())
                .field("file",file)
                .asString();
//        System.out.println(response.getBody());
        Map mapTypes = JSON.parseObject(response.getBody());
        Map result = (Map) mapTypes.get("result");
        //获取url
        String url = (String) result.get("url");

        // 将数据封装为pojo
        Gson gson = new Gson();
        String data = gson.toJson(req);
        WorkInformation workInformation = gson.fromJson(data, WorkInformation.class);
        workInformation.setPath(url);

        //将pojo转为Map装载到List中
        Map<String, Object> subcontent = EntityUtils.entityToMap(workInformation);
        List<Map> subcontentList = new ArrayList<>();
        subcontentList.add(subcontent);
        //List封装为json格式
        AddAndUpdateJsonSon addAndUpdateJsonSon = new AddAndUpdateJsonSon(tableName, subcontentList);
        sendInfoByAddOrUpdata(urlInfoConfig.getAddUrl(), tableName, addAndUpdateJsonSon);
        return "成功";
    }


}
