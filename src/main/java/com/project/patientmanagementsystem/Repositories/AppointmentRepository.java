package com.project.patientmanagementsystem.Repositories;

import com.project.patientmanagementsystem.Domain.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    //Iterable<Appointment> fi

}
