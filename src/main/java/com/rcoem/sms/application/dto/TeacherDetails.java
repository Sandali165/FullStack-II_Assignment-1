package com.rcoem.sms.application.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TeacherDetails {
    private String teacherId;
    private String name;
    private String email;
    private String department;
    private String specialization;
    private String mobileNumber;
}
