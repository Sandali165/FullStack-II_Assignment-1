//package com.rcoem.sms.application.services;
//
//import com.rcoem.sms.application.dto.CourseDetails;
//import com.rcoem.sms.application.mapper.CourseMapper;
//import com.rcoem.sms.domain.entities.CourseInfo;
//import com.rcoem.sms.domain.repositories.CourseRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//import java.util.Optional;
//
//@Service
//public class CourseServiceImpl implements CourseService {
//
//    @Autowired
//    CourseRepository courseRepository;
//
//    @Autowired
//    CourseMapper courseMapper;
//
//    @Override
//    public List<CourseDetails> getAllCourses() {
//        return courseRepository.findAll()
//                .stream()
//                .map(courseMapper::toDto)
//                .toList();
//    }
//
//    @Override
//    public CourseDetails createCourse(CourseDetails courseDetails) {
//        String uid = "COURSE-" + UUID.randomUUID();
//        courseDetails.setCourseId(uid);
//        CourseInfo insertRecord = courseRepository.save(courseMapper.toEntity(courseDetails));
//        return courseMapper.toDto(insertRecord);
//    }
//
//    @Override
//    public CourseDetails getCourseById(String courseId) {
//        Optional<CourseInfo> courseInfo = courseRepository.findById(courseId);
//        return courseInfo.map(courseMapper::toDto).orElse(null);
//    }
//
//    @Override
//    public CourseDetails updateCourseById(CourseDetails courseDetails) {
//        CourseInfo insertRecord = courseRepository.save(courseMapper.toEntity(courseDetails));
//        return courseMapper.toDto(insertRecord);
//    }
//
//    @Override
//    public void deleteCourseById(CourseDetails courseDetails) {
//        courseRepository.delete(courseMapper.toEntity(courseDetails));
//    }
//}
package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.application.mapper.CourseMapper;
import com.rcoem.sms.domain.entities.CourseInfo;
import com.rcoem.sms.domain.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<CourseDetails> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }

    @Override
    public CourseDetails createCourse(CourseDetails courseDetails) {
        CourseInfo saved = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(saved);
    }

    @Override
    public CourseDetails getCourseById(String courseId) {
        Optional<CourseInfo> courseInfo = courseRepository.findById(courseId);
        return courseInfo.map(courseMapper::toDto).orElse(null);
    }

    @Override
    public CourseDetails updateCourseById(CourseDetails courseDetails) {
        // Ensure courseDetails has courseId set from the controller
        CourseInfo saved = courseRepository.save(courseMapper.toEntity(courseDetails));
        return courseMapper.toDto(saved);
    }

    @Override
    public void deleteCourseById(CourseDetails courseDetails) {
        courseRepository.delete(courseMapper.toEntity(courseDetails));
    }
}
