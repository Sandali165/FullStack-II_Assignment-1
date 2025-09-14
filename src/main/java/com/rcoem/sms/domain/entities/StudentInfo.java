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
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String rollNo;
    private String name;
    private String email;
    private String department;
    private String gender;
    private String course;
}
