package com.lyx.teach.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "id")
public class IdInfoConfig {
//    workId: 4028839e82630f2c018263ed1c490034 # 岗位表
//    workInformationId: 4028839e82630f2c018263f30ce50041 # 学习资料表
//    teachPlanId: 4028839e82630f2c018263f7e1cf004b # 计划表
//    noticeId: 4028839e82630f2c018263fcde840054 # 首页通告表
//    wonderfulMomentsId: 4028839e82630f2c018263feb6f2005a # 精彩瞬间表
//    enterpriseId: 4028839e82630f2c018264032d1f005e # 公司表
//    teacherId: 4028839e82630f2c018264086251006c # 师傅表
//    enterpriseManagerId: 4028839e82630f2c018264109ca70084 # 公司账户表
//    evaluationId: 4028839e82630f2c01826417a12b0090 # 互评表
//    studentId: 4028839e82630f2c0182641ccfea0099 # 徒弟表
//    classId: 4028839e82630f2c0182642827e200a7 # 班级表
//    majorId: 4028839e82630f2c0182642a06b200ad # 专业表
//    collegeId: 4028839e82630f2c0182642d3e4400b2 # 学院表
//    schoolId: 4028839e82630f2c01826432c0ad00bb # 学校表
//    schoolManagerId: 4028839e82630f2c01826448e25800c6 # 学校账户表
//    dailyMarkId: 4028839e82630f2c0182644b598600cf # 打卡记录表
    private String workId;
    private String workInformationId;
    private String teachPlanId;
    private String noticeId;
    private String wonderfulMomentsId;
    private String enterpriseId;
    private String teacherId;
    private String enterpriseManagerId;
    private String evaluationId;
    private String studentId;
    private String classId;
    private String majorId;
    private String collegeId;
    private String schoolId;
    private String schoolManagerId;
    private String dailyMarkId;
}