package com.rcoem.sms.interfaces;

import com.rcoem.sms.application.dto.StudentDetails;
import com.rcoem.sms.application.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;
    @Autowired
    private DefaultTransactionDefinition defaultTransactionDefinition;
    @Autowired
    private ResourceTransactionManager resourceTransactionManager;

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentDetails studentDetails){
        StudentDetails insertedStudentDetails = studentService.createStudent(studentDetails);
        return ResponseEntity.created(URI.create("/students"+insertedStudentDetails.getId())).build();
    }

    @GetMapping
    public List<StudentDetails> getStudents() { return studentService.getAllStudents(); }

    @GetMapping("/{id}")
    public StudentDetails getStudentById(@RequestParam String id){
        return studentService.getStudentById(id);
    }
}

