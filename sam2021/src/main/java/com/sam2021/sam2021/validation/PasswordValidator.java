package com.sam2021.sam2021.validation;

import com.sam2021.sam2021.models.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("passwordValidator")
public class PasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        if(!(user.getPassword()).equals(user.getConfirmpassword())){
            errors.rejectValue("password","confirmpassword", "Password and Confirm Password do not match.");
        }

    }
 
}
