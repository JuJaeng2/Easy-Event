package com.project.easyEvent.user.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpForm {

    private String name;
    private String email;
    private String password;
    private String phone;

}
