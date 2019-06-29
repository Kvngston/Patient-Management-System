package com.project.patientmanagementsystem.Repositories;

import com.project.patientmanagementsystem.Domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
