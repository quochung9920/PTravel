package com.ptravel.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

import com.ptravel.pojos.UploadForm;

@Controller
public class UploadController {

        private static String UPLOADED_FOLDER = "C://Users//quoch//Desktop//ptravel//src//main//webapp//resources//images//";

        @GetMapping("/upload")
        public String index() {
            return "upload";
        }
    
        @PostMapping("/uploadMulti")
        public String multiFileUpload(@ModelAttribute UploadForm form,
                                      RedirectAttributes redirectAttributes) {
    
            StringJoiner sj = new StringJoiner(" , ");
    
            for (MultipartFile file : form.getFiles()) {
    
                if (file.isEmpty()) {
                    continue; //next pls
                }
    
                try {
    
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                    Files.write(path, bytes);
    
                    sj.add(file.getOriginalFilename());
    
                } catch (IOException e) {
                    e.printStackTrace();
                }
    
            }
    
            String uploadedFileName = sj.toString();
            if (StringUtils.isEmpty(uploadedFileName)) {
                redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            } else {
                redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + uploadedFileName + "'");
            }
    
            return "redirect:/uploadStatus";
    
        }
    
        @GetMapping("/uploadStatus")
        public String uploadStatus() {
            return "uploadStatus";
        }
}
