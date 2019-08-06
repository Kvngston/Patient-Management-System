package com.project.patientmanagementsystem.Controllers;

import com.project.patientmanagementsystem.Domain.Patient;
import com.project.patientmanagementsystem.Domain.Sex;
import com.project.patientmanagementsystem.Domain.Staff;
import com.project.patientmanagementsystem.Repositories.RoleRepository;
import com.project.patientmanagementsystem.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class indexController  {

    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    //to call the Main index page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Principal principal, Model model){
        model.addAttribute("noUserYet", true);
        return "index2";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getIndex(Principal principal, Model model){
        Staff staff = staffRepository.findByCompanyID(principal.getName());
        model.addAttribute("noUserYet", false);
        return "index2";
    }

    //to call the Patient Register Page
    @RequestMapping(value = "/registerPatient", method = RequestMethod.GET)
    public String getPatientRegisterPage(Model model){

        Patient patient = new Patient();

        model.addAttribute("patient", patient);

        return "PatientRegister";
    }

    //To call the Staff Register Page
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterPage(Model model){

        Staff staff = new Staff();

        model.addAttribute("staff", staff);

        return "Register";
    }

    @RequestMapping(value = "/registerStaff", method = RequestMethod.POST)
    public String addStaff(@ModelAttribute(name = "staff") @Valid Staff staff,
                           BindingResult bindingResult,
                           @RequestParam("cpassword") String cpassword,
                           @RequestParam("Sex") String staffSex,
                           Model model){

            System.out.println("I'm Here");
            if(staffSex.toLowerCase().equals(Sex.MALE.toString().toLowerCase())){
                staff.setSex(Sex.MALE);
            }else if(staffSex.toLowerCase().equals(Sex.FEMALE.toString().toLowerCase())){
                staff.setSex(Sex.FEMALE);
            }else {
                model.addAttribute("InvalidSex", true);
                return "register";
            }
            if(staff.getPassword().equals(cpassword))
                staff.setPassword(passwordEncoder.encode(staff.getPassword()));
            else {
                model.addAttribute("PasswordMisMatch", true);
                return "register";
            }
            staff.setRole(roleRepository.getOne(1));
            System.out.println(staff);
            staffRepository.save(staff);

        return "redirect:/staffPage";
    }

}
