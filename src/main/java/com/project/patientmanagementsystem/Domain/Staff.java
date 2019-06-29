package com.project.patientmanagementsystem.Domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Staff implements Serializable {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String department;

    private Sex sex;

    private final String Role = "Staff";

    private String companyID;

    public Staff() {
    }

    public Staff(String firstName, String lastName, String middleName, String department, Sex sex, String companyID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.department = department;
        this.sex = sex;
        this.companyID = companyID;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return Role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", department='" + department + '\'' +
                ", sex=" + sex +
                ", companyID='" + companyID + '\'' +
                '}';
    }
}
