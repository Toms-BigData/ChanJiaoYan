package com.lyx.teach.service.Impl;

import com.google.gson.Gson;
import com.lyx.teach.Utils.SelectUtil;
import com.lyx.teach.config.UrlInfoConfig;
import com.lyx.teach.databasepojo.other.Notice;
import com.lyx.teach.pojo.toJson.SelectJson;
import com.lyx.teach.service.HomePageService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("HomePageService")
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private UrlInfoConfig urlInfoConfig;

    /**
     * 获取所有通知
     * @return
     * @throws UnirestException
     */
    @Override
    public List<Notice> getAllNotice() throws UnirestException {
        String tableName = "notice";
        Map paramsMap = new HashMap();
        paramsMap.put("englishName", tableName);
        SelectJson selectJson = new SelectJson();
        selectJson.setParams(paramsMap);
        List<Map> result = SelectUtil.getInfosBySelect(urlInfoConfig.getSelectAllUrl(), tableName, selectJson);
        Gson gson = new Gson();
        List<Notice> NoticeList = new ArrayList<>();
        for(int i = 0; i < result.size();i++){
            String json1 = gson.toJson(result.get(i));
            Notice stu1 =  gson.fromJson(json1, Notice.class);
            NoticeList.add(stu1);
        }
        return NoticeList;
    }
}
