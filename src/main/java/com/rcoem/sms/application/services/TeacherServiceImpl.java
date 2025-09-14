package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.mapper.TeacherMapper;
import com.rcoem.sms.domain.entities.TeacherInfo;
import com.rcoem.sms.domain.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TeacherDetails> getAllTeachers() {
        return teacherRepository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

    @Override
    public TeacherDetails createTeacher(TeacherDetails teacherDetails) {
        TeacherInfo insertRecord = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(insertRecord);
    }


    @Override
    public TeacherDetails getTeacherById(String teacherId) {
        Optional<TeacherInfo> teacherInfo = teacherRepository.findById(teacherId);
        return teacherInfo.map(teacherMapper::toDto).orElse(null);
    }

    @Override
    public TeacherDetails updateTeacherById(TeacherDetails teacherDetails) {
        TeacherInfo insertRecord = teacherRepository.save(teacherMapper.toEntity(teacherDetails));
        return teacherMapper.toDto(insertRecord);
    }

    @Override
    public void deleteTeacherById(TeacherDetails teacherDetails) {
        teacherRepository.delete(teacherMapper.toEntity(teacherDetails));
    }
}
