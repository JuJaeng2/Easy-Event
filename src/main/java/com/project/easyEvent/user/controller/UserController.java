package com.project.easyEvent.user.controller;

import com.project.easyEvent.user.model.dto.SignUpForm;
import com.project.easyEvent.user.model.dto.UserDetailResponse;
import com.project.easyEvent.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    /*
    * 회원 가입
    * */
    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody SignUpForm signUpForm){



        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    /*
    * 유저 정보 조회
    * */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDetailResponse> getUserInfo(@PathVariable("id") Integer id){
        UserDetailResponse userDetailResponse = userService.getUserInfo(id);
        return ResponseEntity.ok(userDetailResponse);
    }

}
