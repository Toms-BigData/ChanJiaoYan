package com.lyx.teach.Utils;

import com.alibaba.fastjson.JSON;
import com.lyx.teach.Utils.Util.EntityUtils;
import com.lyx.teach.pojo.toJson.SelectJson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;
import java.util.Map;

public class SelectUtil {
    /**
     *
     * @param url 执行select的url地址
     * @param tableName 表明
     * @param selectJson map类型的select的json数据
     * @return
     * @throws UnirestException
     */
    public static List<Map> getInfosBySelect(String url, String tableName, SelectJson selectJson) throws UnirestException {
        Map<String, Object> map = EntityUtils.entityToMap(selectJson);
        String json = JSON.toJSONString(map);
        HttpResponse<String> response = Unirest.post(url+tableName)
                .header("Content-Type", "application/json")
                .body(json)
                .asString();
        Map mapTypes = JSON.parseObject(response.getBody());
        List<Map> result = (List<Map>)mapTypes.get("result");
        return result;
    }



}
