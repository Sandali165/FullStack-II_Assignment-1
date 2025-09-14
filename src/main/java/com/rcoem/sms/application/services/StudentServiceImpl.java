package com.rcoem.sms.application.services;
import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.application.mapper.StudentMapper;
import com.rcoem.sms.domain.entities.StudentInfo;
import com.rcoem.sms.domain.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDetails> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentInfo -> studentMapper.toDto(studentInfo))
                .toList();
    }

    @Override
    public StudentDetails createStudent(StudentDetails studentDetails) {
        String uid = "RCOEM" + UUID.randomUUID();
        studentDetails.setId(uid);
        StudentInfo insertRecord = studentRepository.save(studentMapper.toEntity(studentDetails));
        return studentMapper.toDto(insertRecord);
    }

    @Override
    public StudentDetails getStudentById(String id){
        Optional<StudentInfo> studentInfo = studentRepository.findById(id);
        return studentInfo.isPresent()? studentMapper.toDto(studentInfo.get()):null;
    }
//    @Override
//    public StudentDetails getStudentById(@PathVariable String id) {
//    }

    @Override
    public StudentDetails updateStudentById(StudentDetails studentDetails) {
        StudentInfo insertRecord = studentRepository.save(studentMapper.toEntity(studentDetails));
        return studentMapper.toDto(insertRecord);
    }

    @Override
    public void deleteStudentById(StudentDetails studentDetails) {
        studentRepository.delete(studentMapper.toEntity(studentDetails));
    }
}

