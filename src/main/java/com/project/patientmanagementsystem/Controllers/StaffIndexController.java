package com.project.patientmanagementsystem.Controllers;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.PatientRecord;
import com.project.patientmanagementsystem.Domain.Staff;
import com.project.patientmanagementsystem.Repositories.PatientRecordRepository;
import com.project.patientmanagementsystem.Repositories.PatientRepository;
import com.project.patientmanagementsystem.Repositories.StaffRepository;
import com.project.patientmanagementsystem.Services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Set;

@Controller
public class StaffIndexController {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientRecordRepository patientRecordRepository;

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "/staffPage", method = RequestMethod.GET)
    public String getStaffPage(Model model){

        return "staffIndex";
    }

    @RequestMapping(value = "/addStaff", method = RequestMethod.POST)
    public String addStaff(@ModelAttribute(value = "Staff") @Valid Staff staff, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors())
            return "staffRegister";

        staffRepository.save(staff);

        return "staffIndex";
    }

    //to show the patient records for a particular patient
    @RequestMapping(value = "/showPatientRecord", method = RequestMethod.GET)
    public String showPatientRecords(@RequestParam String cardNumber, Model model){

        Set<PatientRecord> patientRecord = patientRecordRepository.findByPatient(patientRepository.findByCardNumber(cardNumber));
        if(patientRecord == null)
            model.addAttribute("notFound", false);
        model.addAttribute("patientRecord",patientRecord);




        return "recordsPage";
    }
    @RequestMapping(value = "/createAppointment", method = RequestMethod.POST)
    public String createAppoint(@ModelAttribute("patient") Patient patient, Model model){

        appointmentService.CreateAppointment(patient);

        return "redirect:/patientIndexPage";
    }
}
