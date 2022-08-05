package com.lyx.teach.controller;

import com.lyx.teach.databasepojo.school.WorkInformation;
import com.lyx.teach.databasepojo.student.StudentInfo;
import com.lyx.teach.service.StudentService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 测试打卡
     * @return
     */
    @GetMapping("/test")
    public String test(){
        return "lyx";
    }
    /**
     * 获取所有学生的信息
     * @return
     */
    @PostMapping(value="/allinfos")
    public List<StudentInfo> getAllStudentsInfo() throws UnirestException {
        return studentService.getAllStudentsInfo();
    }
//    @GetMapping("/mark")
//    public void getStudentMark1(String startTime, String endTime, Integer status){
//        studentService.getAllStudentsInfo(startTime, endTime, status);
//    }
    /**
     * 学生上班打卡记录
     * @param data //"{\"studentId\":\"201808103312\",\"startTime\":\"2022/7/22 13:49:05\",\"status\":\"正常\"}";
     */
    @PostMapping("/mark/onduty")
    public void getStudentMarkOnDuty(@RequestBody String data) throws UnirestException {
//        System.out.println(data);
        studentService.getStudentMarkOnDuty(data);
    }
    /**
     * 学生下班打卡记录
     * @param data //"{\"studentId\":\"201808103312\",\"offTime\":\"2022/7/22 13:49:12\"}";
     */
    @PostMapping("/mark/offduty")
    public void getStudentMarkOffDuty(@RequestBody String data) throws UnirestException{
//        System.out.println(data);
        studentService.getStudentMarkOffDuty(data);
    }
    /**
     * 学生请假打卡记录
     * @param data//"{\"studentId\":\"201808103312\",\"status\":\"请假\"}";
     */
    @PostMapping("/mark/leaveduty")
    public void getStudentMarkLeaveDuty(@RequestBody String data) throws UnirestException{
//        System.out.println(data);
        studentService.getStudentMarkLeaveDuty(data);
    }

    @PostMapping("/workInforms")
    public List<WorkInformation> postWorkInforms(@RequestBody String data)throws UnirestException{
        return studentService.postWorkInforms(data);
    }

}
