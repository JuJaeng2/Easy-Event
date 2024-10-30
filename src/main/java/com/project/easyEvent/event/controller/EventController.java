package com.project.easyEvent.event.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/evnet")
@RequiredArgsConstructor
public class EventController {
    
    @PostMapping("/register")
    public String registerOwner(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
}
