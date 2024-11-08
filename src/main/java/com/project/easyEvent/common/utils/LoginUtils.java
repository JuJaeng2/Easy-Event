package com.project.easyEvent.common.utils;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class LoginUtils {

    public void checkAuthentication(){
        SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
    }

}
