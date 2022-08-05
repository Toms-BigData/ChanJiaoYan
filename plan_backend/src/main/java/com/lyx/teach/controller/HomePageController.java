package com.lyx.teach.controller;

import com.lyx.teach.databasepojo.other.Notice;
import com.lyx.teach.service.HomePageService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Home")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;

    /**
     * 返回通知信息列表
     * @return
     */
    @GetMapping("/notice")
    public List<Notice> sendNotices() throws UnirestException {
        return homePageService.getAllNotice();
    }

}
