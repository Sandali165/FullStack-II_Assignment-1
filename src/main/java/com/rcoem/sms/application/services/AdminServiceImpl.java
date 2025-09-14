package com.rcoem.sms.application.services;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.mapper.AdminMapper;
import com.rcoem.sms.domain.entities.AdminInfo;
import com.rcoem.sms.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<AdminDetails> getAllAdmins() {
        return adminRepository.findAll()
                .stream()
                .map(adminMapper::toDto)
                .toList();
    }

    @Override
    public AdminDetails createAdmin(AdminDetails adminDetails) {
        String uid = "ADMIN-" + UUID.randomUUID();
        adminDetails.setAdminId(uid);

        AdminInfo saved = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(saved);   // return saved object
    }

    @Override
    public AdminDetails getAdminById(String adminId) {
        Optional<AdminInfo> adminInfo = adminRepository.findById(adminId);
        return adminInfo.map(adminMapper::toDto).orElse(null);
    }

    @Override
    public AdminDetails updateAdminById(AdminDetails adminDetails) {
        AdminInfo updated = adminRepository.save(adminMapper.toEntity(adminDetails));
        return adminMapper.toDto(updated);
    }

    @Override
    public void deleteAdminById(String adminId) {
        adminRepository.deleteById(adminId);
    }
}
