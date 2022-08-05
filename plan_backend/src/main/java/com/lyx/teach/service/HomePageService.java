package com.lyx.teach.service;

import com.lyx.teach.databasepojo.other.Notice;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;

public interface HomePageService {


    List<Notice> getAllNotice() throws UnirestException;
}
