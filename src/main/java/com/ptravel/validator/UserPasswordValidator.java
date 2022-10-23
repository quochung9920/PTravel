package com.ptravel.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ptravel.pojos.User;

@Component
public class UserPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(!user.getPassword().contains("NQH")){
            errors.rejectValue("password", "user.password.passwordValidatorMessage");
        } 
        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("confirmPassword", "user.confirmPassword.passwordValidatorMessage");
        }

    }
    
}
