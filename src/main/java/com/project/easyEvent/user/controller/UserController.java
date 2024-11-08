package com.project.easyEvent.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.easyEvent.common.exception.ValidationErrorResponse;
import com.project.easyEvent.user.jwt.JwtTokenProvider;
import com.project.easyEvent.user.model.dto.LoginForm;
import com.project.easyEvent.user.model.dto.SignUpForm;
import com.project.easyEvent.user.model.dto.TokenResponse;
import com.project.easyEvent.user.model.dto.UserDetailResponse;
import com.project.easyEvent.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;

    /*
     * 회원 가입
     */
    @PostMapping("signup")
    public ResponseEntity<?> signUp(@Valid @RequestBody SignUpForm signUpForm, BindingResult result) {
        if (result.hasErrors()) {
            List<ValidationErrorResponse> errors = result.getFieldErrors().stream()
                    .map(ValidationErrorResponse::from)
                    .toList();

            return ResponseEntity.badRequest().body(errors);
        }

        userService.signUp(signUpForm);

        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    /*
     * 로그인
     */
    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getEmail(), loginForm.getPassword()));

        String token = jwtTokenProvider.createToken(loginForm.getEmail());

        return ResponseEntity.ok(TokenResponse.builder()
                .token(token)
                .build());
    }

    /*
     * 유저 정보 조회
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<UserDetailResponse> getUserInfo(@PathVariable("id") Integer id) {
        UserDetailResponse userDetailResponse = userService.getUserInfo(id);
        return ResponseEntity.ok(userDetailResponse);
    }

}
