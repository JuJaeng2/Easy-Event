package com.project.easyEvent.event.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
public class EventController {

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        System.out.println("Success test");
        return ResponseEntity.ok().body("Success test");
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerOwner(@RequestBody String entity) {
        // TODO: process POST request

        return ResponseEntity.ok().body("Success register");
    }

}
