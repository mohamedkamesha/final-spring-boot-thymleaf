package com.example.aabbcc.controller;

import com.example.aabbcc.DTO.UserApplicantDTO;
import com.example.aabbcc.DTO.UserCompanyDTO;
import com.example.aabbcc.enumclass.Type;
import com.example.aabbcc.model.User;
import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.ApplicantService;
import com.example.aabbcc.services.CompanyService;
import com.example.aabbcc.services.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private final UserService userService;
    private final UserRepo userRepo;
    private final CompanyService companyService;
    private final ApplicantService applicantService;



    public HomeController(UserService userService, UserRepo userRepo, CompanyService companyService, ApplicantService applicantService) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.companyService = companyService;
        this.applicantService = applicantService;
    }

    @GetMapping("/")
    public  String homePage(Model model){

        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userEmail);

        User user = userRepo.findByEmail(userEmail);
        if(user==null)
            throw new UsernameNotFoundException("invalid email");

        if(user.getType()== Type.applicant) {
            model.addAttribute("posts",applicantService.getPost(user));
            return "applicant";
        }else {
            model.addAttribute("listJobs",companyService.getJobs(user));
            return "company";
        }
      // User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //System.out.println(user);

    }


       @GetMapping("/show/company")
        public String showRe(Model model){
        model.addAttribute("user",new UserCompanyDTO());

        return "registerc";
        }

    @PostMapping("/register/company")
    public String registerCompany(@ModelAttribute("user") UserCompanyDTO userCompanyDTO){
        System.out.println(userCompanyDTO);
        userService.saveAccount(userCompanyDTO);
        return "redirect:/login";
    }

    @GetMapping("/show/applicant")
    public String showReA(Model model){
        model.addAttribute("user",new UserApplicantDTO());

        return "registerA";
    }

    @PostMapping("/register/applicant")
    public String registerApplicant(@ModelAttribute("user") UserApplicantDTO userApplicantDTO){
        System.out.println(userApplicantDTO);
        userService.saveApplicant(userApplicantDTO);
        return "redirect:/login";
    }



    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
