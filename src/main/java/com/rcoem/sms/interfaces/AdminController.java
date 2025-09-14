package com.rcoem.sms.interfaces;

import com.rcoem.sms.application.dto.AdminDetails;
import com.rcoem.sms.application.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity addAdmin(@RequestBody AdminDetails adminDetails) {
        AdminDetails inserted = adminService.createAdmin(adminDetails);
        return ResponseEntity.created(URI.create("/admins/" + inserted.getAdminId()))
                .body(inserted);
    }

    @GetMapping
    public List<AdminDetails> getAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminDetails getAdminById(@PathVariable String id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public AdminDetails updateAdmin(@PathVariable String id, @RequestBody AdminDetails details) {
        details.setAdminId(id);
        return adminService.updateAdminById(details);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable String id) {
        adminService.deleteAdminById(id);
        return ResponseEntity.noContent().build();
    }
}
