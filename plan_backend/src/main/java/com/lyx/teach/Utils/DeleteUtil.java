package com.lyx.teach.Utils;

import com.lyx.teach.config.UrlInfoConfig;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteUtil {

    @Autowired
    private UrlInfoConfig urlInfoConfig;
    /**
     * 通过Id删除表中的数据
     * @param tableName
     * @param Id
     */
    public void deleteById(String tableName, String Id) throws UnirestException {
        Unirest.delete( urlInfoConfig.getDeleteUrl()+tableName+"/?ids="+Id)
                .asString();
    }
}
