package com.project.patientmanagementsystem.Services;

import com.project.patientmanagementsystem.Domain.Staff;
import com.project.patientmanagementsystem.Repositories.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private StaffRepository staffRepository;

    @Override
    public UserDetails loadUserByUsername(String companyID) throws UsernameNotFoundException {
        Staff staff = staffRepository.findByCompanyID(companyID);
        CustomUserDetails customUserDetials = null;

        if(staff != null){
            customUserDetials = new CustomUserDetails();
            customUserDetials.setStaff(staff);
        }else {
            throw  new UsernameNotFoundException("user with Username " + companyID + "does not exist");
        }


        return customUserDetials;
    }
}
