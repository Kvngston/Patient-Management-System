package com.project.patientmanagementsystem.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Patient extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String firstName;

    private String middleName;

    private String lastName;
    
    private int age;

    private Sex sex;

    private String cardNumber;

    private String height;

    private String weight;

    private String bloodGroup;

    private String genotype;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(name = "patient_role",
            joinColumns = @JoinColumn(name = "patient_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;

    @OneToOne
    private PatientRecord patientRecord;

    @OneToMany
    private Set<Appointment> appointment;

    public Patient() {
    }

    public Patient(String firstName, String middleName, String lastName, int age, Sex sex, String cardNumber, String height, String weight, String bloodGroup, String genotype, Role role, PatientRecord patientRecord, Set<Appointment> appointment) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
        this.cardNumber = cardNumber;
        this.height = height;
        this.weight = weight;
        this.bloodGroup = bloodGroup;
        this.genotype = genotype;
        this.role = role;
        this.patientRecord = patientRecord;
        this.appointment = appointment;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getGenotype() {
        return genotype;
    }

    public void setGenotype(String genotype) {
        this.genotype = genotype;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public PatientRecord getPatientRecord() {
        return patientRecord;
    }

    public void setPatientRecord(PatientRecord patientRecord) {
        this.patientRecord = patientRecord;
    }

    public Set<Appointment> getAppointment() {
        return appointment;
    }

    public void setAppointment(Set<Appointment> appointment) {
        this.appointment = appointment;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "Id=" + Id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", cardNumber='" + cardNumber + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", genotype='" + genotype + '\'' +
                ", role=" + role +
                ", patientRecord=" + patientRecord +
                ", appointment=" + appointment +
                '}';
    }
}
