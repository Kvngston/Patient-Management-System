package com.project.patientmanagementsystem.Domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String role;

    @OneToMany(mappedBy = "role")
    private List<Patient> patients;

    @OneToMany(mappedBy = "role")
    private List<Staff> staffs;


    public Role() {
    }

    public Role(String role, List<Patient> patients, List<Staff> staffs) {
        this.role = role;
        this.patients = patients;
        this.staffs = staffs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                '}';
    }
}
