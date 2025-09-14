//package com.rcoem.sms.application.mapper;
//
//import com.rcoem.sms.application.dto.CourseDetails;
//import com.rcoem.sms.domain.entities.CourseInfo;
//import org.springframework.stereotype.Component;
//
//@Component
//public class CourseMapper {
//    public CourseDetails toDto(CourseInfo courseInfo) {
//        return CourseDetails.builder()
//                .courseId(courseInfo.getCourseId())
//                .name(courseInfo.getName())
//                .description(courseInfo.getDescription())
//                .credits(courseInfo.getCredits())
//                .build();
//    }
//
//    public CourseInfo toEntity(CourseDetails courseDetails) {
//        return CourseInfo.builder()
//                .courseId(courseDetails.getCourseId())
//                .name(courseDetails.getName())
//                .description(courseDetails.getDescription())
//                .credits(courseDetails.getCredits())
//                .build();
//    }
//}
package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.CourseDetails;
import com.rcoem.sms.domain.entities.CourseInfo;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseDetails toDto(CourseInfo courseInfo) {
        return CourseDetails.builder()
                .courseId(courseInfo.getCourseId())
                .name(courseInfo.getName())
                .description(courseInfo.getDescription())
                .build();
    }

    public CourseInfo toEntity(CourseDetails courseDetails) {
        return CourseInfo.builder()
                .courseId(courseDetails.getCourseId()) // can be null for new entities
                .name(courseDetails.getName())
                .description(courseDetails.getDescription())
                .build();
    }
}
