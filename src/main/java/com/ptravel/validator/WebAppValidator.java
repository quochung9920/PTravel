package com.ptravel.validator;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.ptravel.pojos.User;


public class WebAppValidator implements Validator{

    private Set<Validator> springValidators;
    @Autowired
    private javax.validation.Validator beanValidator;
    

    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        Set<ConstraintViolation<Object>> beans = this.beanValidator.validate(target);

        for (ConstraintViolation<Object> bean : beans) {
            errors.rejectValue(bean.getPropertyPath().toString(), bean.getMessageTemplate(), bean.getMessage());
        }

        for(Validator validator : this.springValidators) {
            validator.validate(target, errors);
        }
    }
    
}
