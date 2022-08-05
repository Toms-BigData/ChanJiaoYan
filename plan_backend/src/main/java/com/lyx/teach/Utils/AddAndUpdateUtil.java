package com.lyx.teach.Utils;

import com.alibaba.fastjson.JSON;
import com.lyx.teach.Utils.Util.EntityUtils;
import com.lyx.teach.pojo.toJson.AddAndUpdateJsonFather;
import com.lyx.teach.pojo.toJson.AddAndUpdateJsonSon;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AddAndUpdateUtil {
    /**
     * 将需要添加的数据封装成json格式body
     * @Param url 要执行的方法的url
     * @param tableName 表名
     * @param addAndUpdateJsonSon 需要添加的具体信息和字段
     * @return
     */
    public static void sendInfoByAddOrUpdata(String url, String tableName, AddAndUpdateJsonSon addAndUpdateJsonSon) throws UnirestException {
        //将updateJsonSon数据装载到list中
        List<Map> contentList = new ArrayList<>();
        Map<String, Object> content = EntityUtils.entityToMap(addAndUpdateJsonSon);
        contentList.add(content);
        //组装json请求
        AddAndUpdateJsonFather addAndUpdateJsonFather = new AddAndUpdateJsonFather();
        addAndUpdateJsonFather.setEnglishName(tableName);
        addAndUpdateJsonFather.setContentList(contentList);
        Map bodyMap = EntityUtils.entityToMap(addAndUpdateJsonFather);
        //将Map请求体转化成json格式
        String json = JSON.toJSONString(bodyMap);
        //将添加请求返回给数据库
        Unirest.post(url+ tableName).header("Content-Type", "application/json").body(json).asString();
    }

}
