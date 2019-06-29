package com.project.patientmanagementsystem.Controllers;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class indexController  {

    //to call the Main index page
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getIndexPage(){

        return "index2";
    }

    //to call the Patient Register Page
    @RequestMapping(value = "/registerPatient", method = RequestMethod.GET)
    public String getRegisterPage(Model model){

        Patient patient = new Patient();

        model.addAttribute("patient", patient);

        return "PatientRegister";
    }

    //To call the Staff Register Page
    @RequestMapping(value = "/registerStaff", method = RequestMethod.GET)
    public String getStaffRegisterPage(Model model){

        Staff staff = new Staff();

        model.addAttribute("patient", staff);

        return "staffRegister";
    }

}
