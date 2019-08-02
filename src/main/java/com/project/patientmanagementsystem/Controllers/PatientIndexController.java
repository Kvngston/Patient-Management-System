package com.project.patientmanagementsystem.Controllers;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.PatientRecord;
import com.project.patientmanagementsystem.Repositories.PatientRecordRepository;
import com.project.patientmanagementsystem.Repositories.PatientRepository;
import com.project.patientmanagementsystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class PatientIndexController {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private AppointmentService appointmentService;


//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getPatientIndexPage(Model model){
//
//
//        return "index2";
//    }


    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute(name = "patient") @Valid Patient patient, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors())
            return "PatientRegister";

        patient.setPatientRecord(new PatientRecord());

        patientRepository.save(patient);
        model.addAttribute("PatientCreated", true);


        return "PatientIndex";
    }

    @RequestMapping(value = "/myRecord", method = RequestMethod.GET)
    public String showMyRecord(Principal principal, Model model){

        Patient patient = patientRepository.findByFirstName(principal.getName());

        if(patient == null)
            model.addAttribute("patientNotFound", true);

        model.addAttribute("patient", patient);

        return "recordsPage";
    }

    @RequestMapping(value = "/Appointment", method = RequestMethod.GET)
    public String requestAppointment(Principal principal, Model model){

        Patient patient = patientRepository.findByFirstName(principal.getName());
        model.addAttribute("patient", patient);

        return "AppointmentPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLoginPage(){

        return "login";
    }
}
