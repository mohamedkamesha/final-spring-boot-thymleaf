package com.example.aabbcc.services.impl;

import com.example.aabbcc.enumclass.JopApplyStatus;
import com.example.aabbcc.enumclass.Type;
import com.example.aabbcc.model.Applicant;
import com.example.aabbcc.model.Apply;
import com.example.aabbcc.model.CompanyJob;
import com.example.aabbcc.model.User;
import com.example.aabbcc.random.RandomName;
import com.example.aabbcc.repo.ApplicantRepo;
import com.example.aabbcc.repo.ApplyRepo;
import com.example.aabbcc.repo.CompanyJobRepo;
import com.example.aabbcc.repo.UserRepo;
import com.example.aabbcc.services.UploadFileService;
import com.example.aabbcc.storage_file.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UploadFileServiceImpl implements UploadFileService {

    private final UserRepo userRepo ;
    private final CompanyJobRepo companyJobRepo;
    private final ApplyRepo applyRepo;
    private final ApplicantRepo applicantRepo;
    private final FileStorageService fileStorageService;
    public final Path root = Paths.get("uploads");

    public UploadFileServiceImpl(UserRepo userRepo, CompanyJobRepo companyJobRepo, ApplyRepo applyRepo, ApplicantRepo applicantRepo, FileStorageService fileStorageService) {
        this.userRepo = userRepo;
        this.companyJobRepo = companyJobRepo;
        this.applyRepo = applyRepo;
        this.applicantRepo = applicantRepo;
        this.fileStorageService = fileStorageService;
    }


    @Override
    public String uploadFile(Long id, MultipartFile file) {


        if(file.isEmpty() || !(file.getContentType().equals("application/pdf")) ) {
             throw new RuntimeException("file not pdf");
        }

        String fileName = RandomName.generateRandomName(5);

        String message = null;
        try {
            fileStorageService.save(file,fileName);
            message = "ok";
            //message = UploadFile.upload(fileName, file.getInputStream());
    }catch (Exception e){
            throw new RuntimeException("file not pdf");
    }




        String userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepo.findByEmail(userEmail);
        System.out.println(root);
        if(user==null)
            throw new UsernameNotFoundException("invalid email");


            Apply apply = new Apply();
            apply.setCvName(fileName);
            apply.setJopApplyStatus(JopApplyStatus.InProgress);

            apply.setCvRank((int) Math.random()*200);


           CompanyJob companyJob = companyJobRepo.findById(id).orElseThrow(() ->  new RuntimeException("company job not founded"));

        System.out.println(companyJob);
           companyJob.getCvs().add(apply);
           apply.setCompanyJob(companyJob);

            if(user.getType() == Type.applicant){
                Applicant applicant = user.getApplicant();
                applicant.getApplies().add(apply);
                apply.setApplicant(applicant);
                applyRepo.save(apply);
                applicantRepo.save(applicant);
                companyJobRepo.save(companyJob);
            }else {
                applyRepo.save(apply);
                companyJobRepo.save(companyJob);
            }





        Resource resource = fileStorageService.load(fileName);
        System.out.println(resource);

        return message ;
    }
}
