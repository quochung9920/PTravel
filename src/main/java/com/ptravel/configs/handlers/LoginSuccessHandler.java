package com.ptravel.configs.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ptravel.pojos.User;
import com.ptravel.service.UserService;


public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userDetailService;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        User user = this.userDetailService.getUsers(authentication.getName()).get(0);
        

        if(user.getUserRole().equals(User.ADMIN)) {
            response.sendRedirect("/ptravel-1.0-SNAPSHOT/admin");
        } else {
            response.sendRedirect("/ptravel-1.0-SNAPSHOT");
        }
        
        
        
    }
    
}
