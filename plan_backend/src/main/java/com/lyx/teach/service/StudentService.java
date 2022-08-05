package com.lyx.teach.service;

import com.lyx.teach.databasepojo.school.WorkInformation;
import com.lyx.teach.databasepojo.student.StudentInfo;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;


public interface StudentService {
    /**
     * 获取所有学生的信息
     * @return
     */
    List<StudentInfo> getAllStudentsInfo() throws UnirestException;

    /**
     * 学生上班打卡记录
     * @param data
     */
    void getStudentMarkOnDuty(String data) throws UnirestException;
    /**
     * 学生下班打卡记录
     * @param data
     */
    void getStudentMarkOffDuty(String data) throws UnirestException;

    /**
     * 学生请假打卡记录
     * @param data
     */
    void getStudentMarkLeaveDuty(String data) throws UnirestException;


    List<WorkInformation> postWorkInforms(String data);
}
