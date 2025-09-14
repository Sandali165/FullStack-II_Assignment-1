//package com.rcoem.sms.domain.entities;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import lombok.*;
//
//@Entity
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//
//public class CourseInfo {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String courseId;
//
//    private String name;
//    private String description;
//    private int credits;
//}

package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Hibernate generates UUID automatically
    private String courseId;

    private String name;
    private String description;
}
