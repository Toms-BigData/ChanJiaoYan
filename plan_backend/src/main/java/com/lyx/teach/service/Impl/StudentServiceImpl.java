package com.lyx.teach.service.Impl;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.lyx.teach.Utils.SelectUtil;
import com.lyx.teach.Utils.Util.EntityUtils;
import com.lyx.teach.config.UrlInfoConfig;
import com.lyx.teach.databasepojo.school.WorkInformation;
import com.lyx.teach.databasepojo.student.StudentDailyMark;
import com.lyx.teach.databasepojo.student.StudentInfo;
import com.lyx.teach.pojo.toJson.SelectJson;
import com.lyx.teach.pojo.toJson.AddAndUpdateJsonSon;
import com.lyx.teach.service.StudentService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lyx.teach.Utils.AddAndUpdateUtil.sendInfoByAddOrUpdata;
import static com.lyx.teach.Utils.Util.TimeUtil.DateParse;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private UrlInfoConfig urlInfoConfig;
    /**
     * 获取所有学生的信息
     * @return
     */
    @Override
    public List<StudentInfo> getAllStudentsInfo() throws UnirestException {
        //1.
        String tableName = "studentInfo";
        Map<Object, Object> paramsMap = new HashMap();
        paramsMap.put("englishName", tableName);
        SelectJson selectJson = new SelectJson();
        selectJson.setParams(paramsMap);
        List<Map> result = SelectUtil.getInfosBySelect(urlInfoConfig.getSelectAllUrl(), tableName, selectJson);
        Gson gson = new Gson();
        List<StudentInfo> studentList = new ArrayList<>();
        for(int i = 0; i < result.size();i++){
            String json1 = gson.toJson(result.get(i));
            StudentInfo stu1 =  gson.fromJson(json1, StudentInfo.class);
            studentList.add(stu1);
        }
        return studentList;
    }
    /**
     * 获取学生打卡上班信息
     * @param data //json格式的字符串,eg:{"studentId":"201808103312","startTime":"2022/7/22 10:41:44","status":正常}
     */
    @Override
    public void getStudentMarkOnDuty(String data) throws UnirestException {
        String tableName = "dailyMarks";
        //1.解析json数据保存为pojo
        Gson gson = new Gson();
        StudentDailyMark studentDailyMark = gson.fromJson(data, StudentDailyMark.class);
        //2.从json数据中提取出markDate
        Map maps = (Map) JSON.parse(data);
        List<String> startTimeList = DateParse((String) maps.get("startTime"));
        studentDailyMark.setDailyMarkDate(startTimeList.get(0));
        //3.将pojo转为Map装载到List中
        Map<String, Object> subcontent = EntityUtils.entityToMap(studentDailyMark);
        List<Map> subcontentList = new ArrayList<>();
        subcontentList.add(subcontent);
        //4.List封装为json格式
        AddAndUpdateJsonSon addAndUpdateJsonSon = new AddAndUpdateJsonSon(tableName, subcontentList);
        sendInfoByAddOrUpdata(urlInfoConfig.getAddUrl(), tableName, addAndUpdateJsonSon);
        System.out.println("上班打卡成功");
    }
    /**
     * 获取学生打卡下班信息
     * @param data //"{\"studentId\":\"201808103312\",\"endTime\":\"2022/7/22 13:49:12\"}";
     * @throws UnirestException
     */
    @Override
    public void getStudentMarkOffDuty(String data) throws UnirestException{
        String tableName = "dailyMarks";

        //1.解析data获得studentId和endTime
        Map maps = (Map) JSON.parse(data);
        List<String> endTimeList = DateParse((String) maps.get("endTime"));
        String studentId = (String) maps.get("studentId");
        String markDate = endTimeList.get(0);
        String endTime = endTimeList.get(1);
        //2.封装请求格式,拿到学生打卡数据
        Map<String, String> filterMap = new HashMap<>();
        filterMap.put("EQ_studentId", studentId);
        filterMap.put("EQ_markDate", markDate);
        SelectJson selectJson = new SelectJson();
        selectJson.setFilter(filterMap);
        List<Map> studentMarkInfoList = SelectUtil.getInfosBySelect(urlInfoConfig.getSelectOneUrl(), tableName, selectJson);
        //3.将json格式的数据转换成pojo类
        Gson gson = new Gson();
        String json1 = gson.toJson(studentMarkInfoList.get(0));
        StudentDailyMark studentDailyMark = gson.fromJson(json1, StudentDailyMark.class);
        //4.将endTime数据放到pojo类中
        Map<String, Object> map = EntityUtils.entityToMap(studentDailyMark);
        //5.构建更新的数据List
        List<Map> subcontentList = new ArrayList<>();
        subcontentList.add(map);
        //6.封装并发送
        AddAndUpdateJsonSon addAndUpdateJsonSon = new AddAndUpdateJsonSon(tableName, subcontentList);
        sendInfoByAddOrUpdata(urlInfoConfig.getUpdateUrl(), tableName, addAndUpdateJsonSon);
        System.out.println("下班打卡成功");
    }

    /**
     * 获取学生打卡请假信息
     * @param data
     * @throws UnirestException
     */
    @Override
    public void getStudentMarkLeaveDuty(String data) throws UnirestException {
        String tableName = "dailyMarks";
        //1.解析json数据保存为pojo
        Gson gson = new Gson();
        StudentDailyMark studentDailyMark = gson.fromJson(data, StudentDailyMark.class);
        //2.将pojo转为Map装载到List中
        Map<String, Object> subcontent = EntityUtils.entityToMap(studentDailyMark);
        List<Map> subcontentList = new ArrayList<>();
        subcontentList.add(subcontent);
        //3.List封装为json格式
        AddAndUpdateJsonSon addAndUpdateJsonSon = new AddAndUpdateJsonSon(tableName, subcontentList);
        sendInfoByAddOrUpdata(urlInfoConfig.getAddUrl(), tableName, addAndUpdateJsonSon);
        System.out.println("请假打卡成功");
    }

    @Override
    public List<WorkInformation> postWorkInforms(String data) {
        String tableName1 = "teacher";
        String tableName2 = "work";
    }
}
