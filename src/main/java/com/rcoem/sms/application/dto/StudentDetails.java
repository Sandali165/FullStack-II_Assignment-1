package com.rcoem.sms.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentDetails {
    private String id;
    private String rollNo;
    private String name;
    private String email;
    private String department;
    private String gender;
    private String course;
}
