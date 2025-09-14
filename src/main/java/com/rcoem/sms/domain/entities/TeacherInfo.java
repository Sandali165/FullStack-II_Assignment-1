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
@Getter
@Setter

public class TeacherInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String teacherId;
    private String name;
    private String email;
    private String department;
    private String specialization;
    private String mobileNumber;
}
