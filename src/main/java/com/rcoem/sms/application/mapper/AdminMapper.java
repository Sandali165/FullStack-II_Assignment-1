package com.rcoem.sms.application.mapper;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.domain.entities.AdminInfo;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDetails toDto(AdminInfo adminInfo) {
        return AdminDetails.builder()
                .adminId(adminInfo.getAdminId())
                .name(adminInfo.getName())
                .email(adminInfo.getEmail())
                .role(adminInfo.getRole())
                .mobileNumber(adminInfo.getMobileNumber())
                .build();
    }

    public AdminInfo toEntity(AdminDetails adminDetails) {
        return AdminInfo.builder()
                .adminId(adminDetails.getAdminId())
                .name(adminDetails.getName())
                .email(adminDetails.getEmail())
                .role(adminDetails.getRole())
                .mobileNumber(adminDetails.getMobileNumber())
                .build();
    }
}
