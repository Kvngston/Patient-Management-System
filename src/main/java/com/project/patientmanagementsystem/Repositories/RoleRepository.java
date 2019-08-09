package com.project.patientmanagementsystem.Repositories;

import com.project.patientmanagementsystem.Domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
