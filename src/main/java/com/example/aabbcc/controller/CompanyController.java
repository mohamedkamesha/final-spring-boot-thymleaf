package com.example.aabbcc.controller;

import com.example.aabbcc.DTO.CompanyJobDTO;
import com.example.aabbcc.model.ApplicantPost;
import com.example.aabbcc.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //start  add job
        @GetMapping("/deleteJob/{id}")
        public String deleteJob(@PathVariable Long id){
        companyService.deleteJob(id);
        return "redirect:/";
        }

        @GetMapping("/add_job")
        public String addJob(Model model){

           // CompanyJobDTO companyJobDTO = new CompanyJobDTO();
            model.addAttribute("company",new CompanyJobDTO());
        return "form";
        }

        @PostMapping("/saveJob")
        public String saveJob(@ModelAttribute ("companyJobDTO") CompanyJobDTO companyJobDTO){
            System.out.println(companyJobDTO);
            System.out.println("ok");
            companyService.addJob(companyJobDTO);
            return "redirect:/";
        }


    @GetMapping("/seePost")
    public String seePost(Model model){
        model.addAttribute("posts",companyService.seePost());
        return "post";
        }


    @GetMapping("/seeCv/{id}")
    private String seeCv(@PathVariable(value = "id") long id, Model model){
        model.addAttribute("cvs",companyService.seeCv(id));
        return "cv";
    }

    @PostMapping("/search")
    public String searchForApplicant(@RequestParam("position") String position,Model model){
        System.out.println(companyService.search(position));
        model.addAttribute("applicants",companyService.search(position));

        return "search";
    }


        //end add job
}
