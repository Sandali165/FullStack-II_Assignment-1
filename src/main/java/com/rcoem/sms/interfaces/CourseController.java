package com.rcoem.sms.interfaces;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping
    public ResponseEntity addCourse(@RequestBody CourseDetails courseDetails){
        CourseDetails inserted = courseService.createCourse(courseDetails);
        return ResponseEntity
                .created(URI.create("/courses/" + inserted.getCourseId()))
                .body(inserted);
    }

    @GetMapping
    public List<CourseDetails> getCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public CourseDetails getCourseById(@PathVariable String id){
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public CourseDetails updateCourse(@PathVariable String id, @RequestBody CourseDetails details){
        details.setCourseId(id); // Set ID for update
        return courseService.updateCourseById(details);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCourse(@PathVariable String id){
        CourseDetails existing = courseService.getCourseById(id);
        if(existing != null){
            courseService.deleteCourseById(existing);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

//@RestController
//@RequestMapping("/courses")
//public class CourseController {
//
//    @Autowired
//    CourseService courseService;
//
//    @PostMapping
//    public ResponseEntity addCourse(@RequestBody CourseDetails courseDetails){
//        CourseDetails inserted = courseService.createCourse(courseDetails);
//        return ResponseEntity
//                .created(URI.create("/courses/" + inserted.getCourseId()))
//                .body(inserted);
//    }
//
//    @GetMapping
//    public List<CourseDetails> getCourses(){
//        return courseService.getAllCourses();
//    }
//
//    @GetMapping("/{id}")
//    public CourseDetails getCourseById(@PathVariable String id){
//        return courseService.getCourseById(id);
//    }
//
//    @PutMapping("/{id}")
//    public CourseDetails updateCourse(@PathVariable String id, @RequestBody CourseDetails details){
//        details.setCourseId(id); // Set ID for update
//        return courseService.updateCourseById(details);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity deleteCourse(@PathVariable String id){
//        CourseDetails existing = courseService.getCourseById(id);
//        if(existing != null){
//            courseService.deleteCourseById(existing);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//}
