package com.ptravel.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringJoiner;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ptravel.pojos.User;
import com.ptravel.service.UserService;
import com.ptravel.validator.WebAppValidator;

@Controller
public class UserController {

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private WebAppValidator userPasswordValidator;

    private static String UPLOADED_FOLDER = "C://Users//quoch//Desktop//ptravel//src//main//webapp//resources//images//avatar//";

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(userPasswordValidator);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model,
        @ModelAttribute(value = "user") @Valid User user,
        BindingResult result){
        if(!result.hasErrors()){
            if(this.userDetailsService.addUser(user, User.USER) == true){
                return "redirect:/login";
            }
        }
        return "register";
    }

    @GetMapping("/info-user/{userId}")
    public String userUpdateView(Model model, @PathVariable(value = "userId") Integer userId, @ModelAttribute(value = "imageUser") User user) {
        model.addAttribute("user", this.userDetailsService.getUserById(userId));
        model.addAttribute("userId", userId);
        return "info-user";
    }
    
    @PostMapping("/info-user/{userId}")
    public String userUpdateAvatar(@ModelAttribute(value = "uploadAvatar") User user,
        @PathVariable(value = "userId") Integer userId) {
        
        this.userDetailsService.updateAvatar(userId, user.getAvatarFile());

        return "redirect:/info-user/" + userId;
        
    }
    
}
