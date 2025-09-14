package com.rcoem.sms.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity(name = "admin_info")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class AdminInfo {
    @Id
    private String adminId;
    private String name;
    private String email;
    private String role;
    private String mobileNumber;
}
