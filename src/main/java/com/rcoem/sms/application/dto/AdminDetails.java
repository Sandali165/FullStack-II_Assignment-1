package com.rcoem.sms.application.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AdminDetails {
    private String adminId;
    private String name;
    private String email;
    private String role;
    private String mobileNumber;
}
