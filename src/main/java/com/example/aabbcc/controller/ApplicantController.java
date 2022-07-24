package com.example.aabbcc.controller;

import com.example.aabbcc.DTO.ApplicantPostDTO;
import com.example.aabbcc.DTO.CompanyJobDTO;
import com.example.aabbcc.enumclass.Type;
import com.example.aabbcc.model.User;
import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.ApplicantService;
import com.example.aabbcc.services.UploadFileService;

import com.example.aabbcc.storage_file.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class ApplicantController {
    private final ApplicantService applicantService;
    private final UploadFileService uploadFileService;
    private final FileStorageService fileStorageService;
    private final UserRepo userRepo;

    public ApplicantController(ApplicantService applicantService, UploadFileService uploadFileService, FileStorageService fileStorageService, UserRepo userRepo) {
        this.applicantService = applicantService;

        this.uploadFileService = uploadFileService;
        this.fileStorageService = fileStorageService;
        this.userRepo = userRepo;
    }


    @GetMapping("/addNewJob")
    public String addJob(Model model){
        model.addAttribute("applicant",new ApplicantPostDTO());
        return "addPost";
    }

    @PostMapping("/saveJobApplicant")
    public String saveJob(@ModelAttribute("applicantPostDTO") ApplicantPostDTO applicantPostDTO){
        System.out.println(applicantPostDTO);
        System.out.println("ok");
        applicantService.saveApplicantPost(applicantPostDTO);
        return "redirect:/";
    }



    @GetMapping("/deletePost/{id}")
    public String deletePost(@PathVariable Long id){
        applicantService.deletePost(id);
        return "redirect:/";
    }






    @GetMapping("/seeCompanyJobs")
    public String seeCompanyJobs(Model model){
        model.addAttribute("companyJobs",applicantService.seeCompanyJobs());
        return "job";
    }

    @PostMapping ("/searchCompanyJobs")
    public String searchCompanyJobs(@RequestParam("position") String position,Model model){
        model.addAttribute("companyJobs",applicantService.searchCompanyJobs(position));
        return "searchJob";
    }





    @PostMapping("/upload/{id}")
    public String uploadCv(@PathVariable Long id ,@RequestParam("file") MultipartFile file){
        System.out.println(file.getOriginalFilename());
        System.out.println(id);
        uploadFileService.uploadFile(id,file);



        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(userEmail);

        User user = userRepo.findByEmail(userEmail);
        if(user==null)
            throw new UsernameNotFoundException("invalid email");

        if(user.getType()== Type.applicant) {
            return "index";
        }else {
            return "ok";
        }


    }



    @GetMapping("/files/{filename:.+}")
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = fileStorageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }





}
