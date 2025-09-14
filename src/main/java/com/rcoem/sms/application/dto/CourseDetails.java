//package com.rcoem.sms.application.dto;
//
//import lombok.*;
//
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//
//public class CourseDetails {
//    private String courseId;
//    private String name;
//    private String description;
//    private int credits;
//}
package com.rcoem.sms.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseDetails {
    private String courseId;
    private String name;
    private String description;
}
