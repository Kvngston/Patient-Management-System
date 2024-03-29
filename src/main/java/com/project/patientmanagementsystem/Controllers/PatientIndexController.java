package com.project.patientmanagementsystem.Controllers;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.PatientRecord;
import com.project.patientmanagementsystem.Domain.Sex;
import com.project.patientmanagementsystem.Repositories.PatientRecordRepository;
import com.project.patientmanagementsystem.Repositories.PatientRepository;
import com.project.patientmanagementsystem.Repositories.RoleRepository;
import com.project.patientmanagementsystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class PatientIndexController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/viewPatients", method = RequestMethod.GET)
    public String getPatientsPage(Model model){

        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("listNotEmpty", true);
        model.addAttribute("patient", patients);
        return "viewPatients";
    }

    @RequestMapping(value = "/addPatients", method = RequestMethod.GET)
    public String getAddPatientsPage(Model model){
        Patient patient = new Patient();
        model.addAttribute("patient", patient);
        return "AddPatient";
    }

    @RequestMapping(value = "/createPatient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute(name = "patient") @Valid Patient patient,
                             BindingResult bindingResult,
                             @RequestParam("Sex") String patientSex,
                             Model model){

        if(bindingResult.hasErrors())
            return "addPatient";


        patient.setPatientRecord(new PatientRecord());
        patientRecordRepository.save(patient.getPatientRecord());


        if(patientRepository.findByCardNumberAndFirstName(patient.getCardNumber(), patient.getFirstName()) == null) {
            System.out.println(patient);
            patient.setRole(roleRepository.findByRole("Patient"));
            patientRepository.save(patient);
            model.addAttribute("PatientCreated", true);
        }else{
            model.addAttribute("PatientExists", true);
            return "addPatient";
        }

        return "addPatient";
    }

    @RequestMapping(value = "/myRecord", method = RequestMethod.GET)
    public String showMyRecord(Principal principal, Model model){

//        Patient patient = patientRepository.findByFirstName(principal.getName());
//
//        if(patient == null)
//            model.addAttribute("patientNotFound", true);
//
//        model.addAttribute("patient", patient);

        return "recordsPage";
    }

    @RequestMapping(value = "/Appointment", method = RequestMethod.GET)
    public String requestAppointment(Principal principal, Model model){

//        Patient patient = patientRepository.findByFirstName(principal.getName());
//        model.addAttribute("patient", patient);
//
        return "AppointmentPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(Model model){

        return "login";
    }
}
