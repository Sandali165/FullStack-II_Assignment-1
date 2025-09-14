package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.domain.entities.TeacherInfo;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public TeacherDetails toDto(TeacherInfo teacherInfo) {
        return TeacherDetails.builder()
                .teacherId(teacherInfo.getTeacherId())
                .name(teacherInfo.getName())
                .email(teacherInfo.getEmail())
                .department(teacherInfo.getDepartment())
                .specialization(teacherInfo.getSpecialization())
                .mobileNumber(teacherInfo.getMobileNumber())
                .build();
    }
    public TeacherInfo toEntity(TeacherDetails teacherDetails) {
        TeacherInfo.TeacherInfoBuilder builder = TeacherInfo.builder()
                .name(teacherDetails.getName())
                .email(teacherDetails.getEmail())
                .department(teacherDetails.getDepartment())
                .specialization(teacherDetails.getSpecialization())
                .mobileNumber(teacherDetails.getMobileNumber());

        if (teacherDetails.getTeacherId() != null) {
            builder.teacherId(teacherDetails.getTeacherId());
        }

        return builder.build();
    }

//    public TeacherInfo toEntity(TeacherDetails teacherDetails) {
//        return TeacherInfo.builder()
//                .teacherId(teacherDetails.getTeacherId())
//                .name(teacherDetails.getName())
//                .email(teacherDetails.getEmail())
//                .department(teacherDetails.getDepartment())
//                .specialization(teacherDetails.getSpecialization())
//                .mobileNumber(teacherDetails.getMobileNumber())
//                .build();
//    }
}
