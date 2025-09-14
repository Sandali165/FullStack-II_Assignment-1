package com.rcoem.sms.interfaces;

import com.rcoem.sms.application.dto.TeacherDetails;
import com.rcoem.sms.application.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping
    public ResponseEntity addTeacher(@RequestBody TeacherDetails teacherDetails) {
        TeacherDetails inserted = teacherService.createTeacher(teacherDetails);
        return ResponseEntity.created(URI.create("/teachers/" + inserted.getTeacherId())).body(inserted);
    }

    @GetMapping
    public List<TeacherDetails> getTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/{id}")
    public TeacherDetails getTeacherById(@PathVariable String id) {
        return teacherService.getTeacherById(id);
    }

    @PutMapping("/{id}")
    public TeacherDetails updateTeacher(@PathVariable String id, @RequestBody TeacherDetails details){
        details.setTeacherId(id);
        return teacherService.updateTeacherById(details);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable String id){
        TeacherDetails existing = teacherService.getTeacherById(id);
        if(existing != null){
            teacherService.deleteTeacherById(existing);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
